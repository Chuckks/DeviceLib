package com.bbva.devicelib.physical

interface IPower {
    fun sleep()
    fun shutdown()
    fun reboot()
    fun savingPower()
}