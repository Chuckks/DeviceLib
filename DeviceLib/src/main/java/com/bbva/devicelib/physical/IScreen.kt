package com.bbva.devicelib.physical

interface IScreen {
    fun setExclusiveMode(exclusive: Boolean)
    fun setDropDown(enable: Boolean)
    fun setNavigationVisibility(visible: Boolean)

    enum class ENavigator {
        NONE,
        HOME,
        BACK,
        RECENT
    }

    fun hideNavigationItems(vararg items: ENavigator)

    enum class EPosition {
        RIGHT,
        LEFT,
        DOWN,
        UP
    }
}