package com.bbva.devicelib.physical

interface IScan: IAvailable {
    fun start()
    fun stop()

    fun getResult(): String
}