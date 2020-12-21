package tech.skot.demo.components

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import tech.skot.components.ComponentViewImpl
import tech.skot.components.ComponentViewProxy
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKFragment
import tech.skot.demo.androidviewlegacy.databinding.TabBinding
import tech.skot.view.extensions.setOnClick
import tech.skot.view.live.MutableSKLiveData


class TabViewProxy(
    override val label: String,
    override val onTap: () -> Unit,
    selectedInitial:Boolean
): ComponentViewProxy<TabBinding>(),TabView{


    private val selectedLD: MutableSKLiveData<Boolean> = MutableSKLiveData(selectedInitial)

    override var selected: Boolean
        get() = selectedLD.value
        set(newVal) {
            selectedLD.postValue(newVal)
        }

    override fun bindTo(
        activity: SKActivity,
        fragment: SKFragment?,
        layoutInflater: LayoutInflater,
        binding: TabBinding
    ) =
        TabViewImpl(activity, fragment, binding).apply {
            onLabel(label)
            onOnTap(onTap)
            selectedLD.observe() {
                onSelected(it)
            }
        }


}


class TabViewImpl(activity: SKActivity, fragment: SKFragment?, binding: TabBinding): ComponentViewImpl<TabBinding>(activity, fragment, binding) {

    fun onLabel(label:String) {
        binding.tvLabel.text = label
    }

    fun onOnTap(onTap:() -> Unit) {
        binding.root.setOnClick(onTap)
    }

    fun onSelected(selected:Boolean) {
        val color = ContextCompat.getColor(activity, if (selected) android.R.color.black else android.R.color.darker_gray)
        binding.tvLabel.setTextColor(color)
    }

}