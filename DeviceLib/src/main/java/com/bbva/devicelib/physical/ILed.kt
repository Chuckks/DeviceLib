package com.bbva.devicelib.physical

interface ILed: IAvailable {
    enum class EColor {
        RED,
        GREEN,
        YELLOW,
        BLUE
    }

    fun turnOn(color: EColor)
    fun turnOff(color: EColor)

    fun isColorOn(color: EColor): Boolean

    fun turnOnLights(vararg colors: EColor)
    fun turnOffLights(vararg colors: EColor)

    fun turnOnAllLights()
    fun turnOffAllLights()

    fun switchLight(color: EColor)
    fun switchLights(vararg colors: EColor)

    fun switch()
}