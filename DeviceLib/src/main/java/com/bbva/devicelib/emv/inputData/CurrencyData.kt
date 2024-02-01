package com.bbva.devicelib.emv.inputData

import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_NAME = ""
private const val DEFAULT_CODE = ""
private const val DEFAULT_SYMBOL = ""

data class CurrencyData(
    var name: String = "",
    var symbol: String = "",
    var code: String = "",
    var exponent: String = "",
    var decimalNumber: String = ""
): IEmpty {

    override fun isEmpty() = name == DEFAULT_NAME && code == DEFAULT_CODE && symbol == DEFAULT_SYMBOL

}
