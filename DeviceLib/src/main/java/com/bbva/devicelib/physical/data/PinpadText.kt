package com.bbva.devicelib.physical.data

import com.bbva.devicelib.utilities.IEmpty

private const val DEFAULT_CONFIRM = "CONFIRME"
private const val DEFAULT_INPUT_PIN = "INGRESE PIN"
private const val DEFAULT_OFFLINE_PIN = "PIN OFFLINE"

data class PinpadText(
    var confirm: String = DEFAULT_CONFIRM,
    var inputPin: String = DEFAULT_INPUT_PIN,
    var errorMessage: String = "ERROR",
    var inputOfflinePin: String = DEFAULT_OFFLINE_PIN,
    val reInputOfflinePinFormat: String = "REINGRESE"
): IEmpty {

    override fun isEmpty() = confirm == DEFAULT_CONFIRM && inputPin == DEFAULT_INPUT_PIN
            && inputOfflinePin == DEFAULT_OFFLINE_PIN
}
