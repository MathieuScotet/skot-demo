package tech.skot.demo.screens

import android.view.LayoutInflater
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import tech.skot.core.SKLog
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKFragment
import tech.skot.demo.androidviewlegacy.databinding.AScreenInAStackBinding
import tech.skot.view.legacy.ScreenViewImpl
import tech.skot.view.legacy.ScreenViewProxy

class AScreenInAStackProxy(
    override val title: String,
    override val lines: List<AScreenInAStackView.Line>
):ScreenViewProxy<AScreenInAStackViewImpl>(),AScreenInAStackView {


    override fun inflateAndLinkChildren(
        layoutInflater: LayoutInflater,
        activity: SKActivity,
        fragment: SKFragment?
    ) = AScreenInAStackViewImpl(activity, fragment, AScreenInAStackBinding.inflate(layoutInflater))


    var state:MutableMap<String,Any> = mutableMapOf()

    override fun linkTo(impl: AScreenInAStackViewImpl, lifeCycleOwner: LifecycleOwner) {
        impl.onTitle(title)
        impl.onLines(lines)
        impl.restoreState(state)
        lifeCycleOwner.lifecycle.addObserver(object : LifecycleObserver {

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroyView() {
                SKLog.d("OnLifecycleEvent onDestroyView lifeCycleOwner ${lifeCycleOwner.hashCode()}")
                impl.saveState(state)
            }
        })
    }
}


class AScreenInAStackViewImpl(activity: SKActivity, fragment: SKFragment?, binding: AScreenInAStackBinding) : ScreenViewImpl<AScreenInAStackBinding>(activity, fragment, binding) {

    fun saveState(state:MutableMap<String,Any>) {
        state.put("SCROLL", binding.sv.scrollY)
    }

    fun restoreState(state: Map<String, Any>) {
        SKLog.d("restoreState --- $state")
        (state.get("SCROLL") as? Int?)?.let {
            SKLog.d("restoreState --- scroll: $it")
            binding.sv.post {
                binding.sv.scrollY = it
            }
        }
    }

    fun onTitle(title:String) {
        binding.tvTitle.text = title
    }


    fun onLines(lines: List<AScreenInAStackView.Line>) {
        binding.tvTextLines.text = lines.joinToString(separator = "\n") {
            "Ligne n°${it.id}"
        }
    }

}