package com.bbva.devicelib.emv.configData

import com.bbva.utilitieslib.interfaces.IEmpty


private const val DEFAULT_AID = ""
private const val DEFAULT_NAME = ""
private const val DEFAULT_AMOUNT = "0000000000"
private const val DEFAULT_TAC = "0000000000"
private const val DEFAULT_VERSION = "0000"

data class AidData(
    var name: String = DEFAULT_NAME,
    var aid: String = DEFAULT_AID,
    var version: String = DEFAULT_VERSION,
    var ddol: String = "",
    var tdol: String = "",

    //@Icc
    var floorLimit: String = DEFAULT_AMOUNT,
    var checkCvmLimit: Boolean = false,
    var cvmLimit: String = DEFAULT_AMOUNT,
    var tacDefault: String = DEFAULT_TAC,
    var tacOnline: String = DEFAULT_TAC,
    var tacDenial: String = DEFAULT_TAC,

    //@Contactless
    var ctlsCheckTransLimit: Boolean = true,
    var ctlsTransLimit: String = DEFAULT_AMOUNT,
    var ctlsCheckCvmLimit: Boolean = true,
    var ctlsCvmLimit: String = DEFAULT_AMOUNT,
    var ctlsCheckFloorLimit: Boolean = true,
    var ctlsFloorLimit: String = DEFAULT_AMOUNT,
    var ctlsCdCvmLimit: String = DEFAULT_AMOUNT,
    var ctlsNoCdCvmLimit: String = DEFAULT_AMOUNT,
    var ctlsRiskData: String = "",
    var ctlsTacDefault: String = DEFAULT_TAC,
    var ctlsTacOnline: String = DEFAULT_TAC,
    var ctlsTacDenial: String = DEFAULT_TAC,
    var ctlsStatusCheck: String = "",

    ): IEmpty {

    override fun isEmpty() = (aid == DEFAULT_AID && version == DEFAULT_VERSION && name == DEFAULT_NAME)

    fun checkAid(aid: String) = (aid.contains(this.aid))
}
