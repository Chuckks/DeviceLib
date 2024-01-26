package com.bbva.devicelib.physical

interface ISound: IAvailable {
    fun infoBeep()
    fun errorBeep()

    fun successBeep()
    fun warningBeep()

    fun custom(count: Int, freq: Int, duration: Int, interval: Int)
}