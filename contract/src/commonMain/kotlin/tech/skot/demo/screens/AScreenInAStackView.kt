package tech.skot.demo.screens

import tech.skot.core.components.ScreenView


interface AScreenInAStackView : ScreenView {
    val title:String
    var lines: List<Line>

    data class Line(val id:Long)
}