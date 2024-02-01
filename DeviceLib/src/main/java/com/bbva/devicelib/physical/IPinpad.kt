package com.bbva.devicelib.physical

import com.bbva.devicelib.physical.data.PinpadData
import com.bbva.devicelib.physical.data.PinpadText

interface IPinpad: IAvailable {

    enum class EResult(val value: Int) {
        INIT(-1),
        SUCCESS(0),
        CANCEL(1),
        SKIPPED(2),
        FAILS(3);

        fun isSuccess() = this == SUCCESS
    }

    fun config(pinpad: PinpadData)
    fun config(pinpadText: PinpadText)
    fun config(pinpad: PinpadData, pinpadText: PinpadText)

    fun capture(panValue: String, onCaptureResult: (result: EResult) -> Unit)
    fun getPinBlock(): String
}