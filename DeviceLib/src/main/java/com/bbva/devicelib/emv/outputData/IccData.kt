package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_TLV_RESULT = ""
private const val DEFAULT_CRYPTOGRAM = ""
private const val DEFAULT_APP_TX_COUNTER = ""
private const val DEFAULT_FACTOR_INDICATOR = ""

data class IccData(

    var app: Application = Application(),
    var tlvResult: String = DEFAULT_TLV_RESULT,
    var cryptogram: String = DEFAULT_CRYPTOGRAM,
    var appTxCounter: String = DEFAULT_APP_TX_COUNTER,
    var factorIndicator: String = DEFAULT_FACTOR_INDICATOR,
    var tvr: Tvr = Tvr(),
    var tsi: Tsi = Tsi(),
    var cvmResult: CvmResult = CvmResult()

): IEmpty {

    override fun isEmpty() = app.isEmpty() && cvmResult.isEmpty() && cryptogram == DEFAULT_CRYPTOGRAM
            && tlvResult == DEFAULT_TLV_RESULT && appTxCounter == DEFAULT_APP_TX_COUNTER
            && factorIndicator == DEFAULT_FACTOR_INDICATOR
}
