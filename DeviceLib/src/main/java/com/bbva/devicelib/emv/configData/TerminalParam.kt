package com.bbva.devicelib.emv.configData

import android.media.ApplicationMediaCapabilities
import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_TERMINAL_TYPE = "22"
private const val DEFAULT_ADD_CAPABILITIES = "7200F0E001"
private const val DEFAULT_CTLS_ADD_CAPABILITIES = "F000F0A001"

private const val DEFAULT_MERCHANT_CAT_CODE = "0000"
private const val DEFAULT_CODE = ""
private const val DEFAULT_CAPABILITY = "60F8C8"

data class TerminalParam(
    var terminalType: String = DEFAULT_TERMINAL_TYPE,
    var capability: String = DEFAULT_CAPABILITY,
    var addCapability: String = DEFAULT_ADD_CAPABILITIES,
    var cltsAddCapability: String = DEFAULT_CTLS_ADD_CAPABILITIES,
    var currencyCode: String = DEFAULT_CODE,
    var countryCode: String =  DEFAULT_CODE,
    var currencyExp: String = DEFAULT_CODE,
    var merchantCategoryCOde: String = DEFAULT_MERCHANT_CAT_CODE,
    var forceOnline: Boolean = false ): IEmpty{

    override fun isEmpty() = (currencyCode == DEFAULT_CODE && countryCode == DEFAULT_CODE && currencyExp == DEFAULT_CODE)

}
