package com.bbva.devicelib.emv.inputData

import com.bbva.utilitieslib.extensions.formatAmount

data class AmountData(
    var amount: String = "0",
    var otherAmount: String = "0",
    var currencyCode: String = "",
    var currencyExponent: Int = 2,
    var symbol: String = "",
    var nDecimal: Int = 2
) {

    fun toFormatString(): String = amount.formatAmount(symbol, nDecimal)

    val totalAmount
        get() = amount.toLong() + otherAmount.toLong()
}
