package com.bbva.devicelib.emv.configData

import com.bbva.utilitieslib.interfaces.IEmpty


private const val DEFAULT_MODULE = ""
private const val DEFAULT_INDEX = ""
private const val DEFAULT_RID = ""

data class CapkData(
    var rid: String = DEFAULT_RID,
    var index: String = DEFAULT_INDEX,
    var hashInd: String = "",
    var modul: String = DEFAULT_MODULE,
    var exponent: String = "",
    var expDate: String = "",
    var checkSum: String = ""
): IEmpty {

    override fun isEmpty() = (index == DEFAULT_INDEX && modul == DEFAULT_MODULE && rid == DEFAULT_RID)
}
