package com.bbva.devicelib.physical

import com.bbva.utilitieslib.utils.TimeSpan

interface IPower {
    fun sleep()
    fun shutdown()
    fun reboot()
    fun savingPower()
    fun forceReboot(timeSpan: TimeSpan)
}