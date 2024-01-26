package com.bbva.devicelib.physical

import android.os.Bundle

interface ISoftwareInstall {
    enum class EUpdateStatus() {
        INIT,
        SUCCESS,
        UPDATING,
        LOW_POWER,
        NOT_AVAILABLE,
        FAIL
    }

    fun install(arg: Bundle)
    fun uninstall()
    fun stopInstall()

    fun onPercentageEvent(onPercentageInstall: (percentage: Int) -> Unit)
    fun onUpdateFirmwareResEvent(onUpdateFirmwareResponse: (response: EUpdateStatus) -> Unit)
}