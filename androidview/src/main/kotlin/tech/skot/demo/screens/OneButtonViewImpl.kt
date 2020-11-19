// //### First generated by SKot but then you can (have to) edit, the main constructor only will modifyed by generator if needed
package tech.skot.demo.screens

import tech.skot.view.extensions.setOnClick
import tech.skot.view.extensions.setVisible

class OneButtonViewImpl(
  onTapButton: Function0<Unit>,
  onTapDemoBaseActions: Function0<Unit>
) : OneButtonViewImplGen(onTapButton, onTapDemoBaseActions) {
    override fun onOnTapButton(onTapButton: Function0<Unit>) {
        binding.button.setOnClick(onTapButton)
    }

    override fun onOnTapDemoBaseActions(onTapDemoBaseActions: () -> Unit) {
        binding.btnDemoBaseActions.setOnClick(onTapDemoBaseActions)
    }

    override fun onLoading(loading: Boolean) {
        binding.progressBar.root.setVisible(loading)
    }
}
