package com.bbva.devicelib.emv

import com.bbva.devicelib.emv.inputData.InputData
import com.bbva.devicelib.emv.outputData.OutputData
import com.bbva.devicelib.physical.IAvailable

interface IEmvProcess: IAvailable {
    enum class EError {
        NONE,
        UNKNOWN,
        MAG_NOT_ALLOW,
        EXPIRED_DATE,
        TRACK_BAD_FORMAT,
        USE_OTHER_INTERFACE,
        CARD_NUM_REFUSED,
        CARD_UNSUPPORTED,
        CARD_BLOCKED,
        CARD_INVALID,
        CARD_REFUSED_SYNC,
        INPUT_PIN,
        TRY_AGAIN,
        USE_CHIP,
        INTERNAL_ERROR,
        FALLBACK,
        SEE_PHONE,
        INTENT_OTHER_CARD,
        TIMEOUT,
        USER_CANCEL,
        ONLINE_PROCESS
    }

    enum class EResult {
        NONE,
        ONLINE_APPROVAL,
        ONLINE_DENIAL,
        OFFLINE_APPROVAL,
        OFFLINE_DENIAL,
        SUCCESS,
        ERROR,
        TRY_AGAIN
    }

    val outputData: OutputData

    fun isInit(): Boolean
    fun init(emvProcessView: IEmvProcessView)
    fun start(inputData: InputData): Boolean
    fun stop()

    fun setSelectApp(selectedApp: Int)
    fun confirmTrxData(userConfirm: Boolean)
    fun isSignatureCaptured(value: Boolean)
}