// //### Generated by SKot do not modify
package tech.skot.demo.screens

import android.view.LayoutInflater
import androidx.lifecycle.LifecycleOwner
import kotlin.String
import tech.skot.demo.android.BaseActivity
import tech.skot.demo.android.BaseFragment
import tech.skot.demo.androidview.databinding.SplashBinding
import tech.skot.demo.base.BaseScreenViewImpl
import tech.skot.view.live.MutableSKLiveData

abstract class SplashViewImplGen(
  messageInitial: String,
  override val title: String
) : BaseScreenViewImpl<BaseActivity, BaseFragment, SplashBinding>(), SplashView {
  private val messageLD: MutableSKLiveData<String> = MutableSKLiveData(messageInitial)

  override var message: String
    get() = messageLD.value
    set(newVal) {
      messageLD.postValue(newVal)
    }

  abstract fun onMessage(message: String)

  abstract fun onTitle(title: String)

  final override fun inflateBinding(layoutInflater: LayoutInflater) =
      SplashBinding.inflate(layoutInflater)

  final override fun linkTo(lifecycleOwner: LifecycleOwner) {
    super.linkTo(lifecycleOwner)
    onTitle(title)
    messageLD.setObserver(lifecycleOwner) {
      onMessage(it)
    }
  }
}
