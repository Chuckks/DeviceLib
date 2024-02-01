package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_TLV_RESULT = ""
private const val DEFAULT_CRYPTOGRAM = ""

data class IccData(

    var app: Application = Application(),
    var tlvResult: String = DEFAULT_TLV_RESULT,
    var cryptogram: String = DEFAULT_CRYPTOGRAM,
    var tvr: Tvr = Tvr(),
    var tsi: Tsi = Tsi(),
    var cvmResult: CvmResult = CvmResult()

): IEmpty {

    override fun isEmpty() = app.isEmpty() && cvmResult.isEmpty() && cryptogram == DEFAULT_CRYPTOGRAM && tlvResult == DEFAULT_TLV_RESULT
}

