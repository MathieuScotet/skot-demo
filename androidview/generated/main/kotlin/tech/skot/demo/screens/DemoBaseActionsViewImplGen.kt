// //### Generated by SKot do not modify
package tech.skot.demo.screens

import android.view.LayoutInflater
import androidx.lifecycle.LifecycleOwner
import kotlin.Function0
import kotlin.Unit
import tech.skot.demo.android.BaseActivity
import tech.skot.demo.android.BaseFragment
import tech.skot.demo.androidview.databinding.DemoBaseActionsBinding
import tech.skot.demo.base.BaseScreenViewImpl

abstract class DemoBaseActionsViewImplGen(
  override val onTapAlert: Function0<Unit>,
  override val onTapBack: Function0<Unit>,
  override val onTapConfirm: Function0<Unit>,
  override val onTapOpenExternalNavigator: Function0<Unit>,
  override val onTapShortSnack: Function0<Unit>,
  override val onTapSnack: Function0<Unit>
) : BaseScreenViewImpl<BaseActivity, BaseFragment, DemoBaseActionsBinding>(), DemoBaseActionsView {
  abstract fun onOnTapAlert(onTapAlert: Function0<Unit>)

  abstract fun onOnTapBack(onTapBack: Function0<Unit>)

  abstract fun onOnTapConfirm(onTapConfirm: Function0<Unit>)

  abstract fun onOnTapOpenExternalNavigator(onTapOpenExternalNavigator: Function0<Unit>)

  abstract fun onOnTapShortSnack(onTapShortSnack: Function0<Unit>)

  abstract fun onOnTapSnack(onTapSnack: Function0<Unit>)

  final override fun inflateBinding(layoutInflater: LayoutInflater) =
      DemoBaseActionsBinding.inflate(layoutInflater)

  final override fun linkTo(lifecycleOwner: LifecycleOwner) {
    super.linkTo(lifecycleOwner)
    onOnTapAlert(onTapAlert)
    onOnTapBack(onTapBack)
    onOnTapConfirm(onTapConfirm)
    onOnTapOpenExternalNavigator(onTapOpenExternalNavigator)
    onOnTapShortSnack(onTapShortSnack)
    onOnTapSnack(onTapSnack)
  }
}