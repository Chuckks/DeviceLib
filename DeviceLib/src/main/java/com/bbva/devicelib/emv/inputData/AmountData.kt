package com.bbva.devicelib.emv.inputData

import com.bbva.devicelib.Constant
import com.bbva.utilitieslib.extensions.formatAmount

data class AmountData(
    var amount: String = "0",
    var otherAmount: String = "0",
    var currencyCode: String = Constant.MX_CURRENCY_CODE,
    var currencyExponent: Int = 2,
    var symbol: String = Constant.MX_CURRENCY_SYMBOL,
    var nDecimal: Int = Constant.NUMBER_OF_DECIMALS
) {

    fun toFormatString(): String = amount.formatAmount(symbol, nDecimal)

    val totalAmount
        get() = amount.toLong() + otherAmount.toLong()
}
