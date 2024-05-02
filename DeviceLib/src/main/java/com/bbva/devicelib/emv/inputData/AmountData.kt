package com.bbva.devicelib.emv.inputData

import com.bbva.devicelib.Constant
import com.bbva.utilitieslib.extensions.formatAmount
import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_CURRENCY_CODE = "0484"
private const val DEFAULT_CURRENCY_SYMBOL = "$"
private const val DEFAULT_NUMBER_OF_DECIMALS = 2
private const val DEFAULT_CURRENCY_EXP = 2
private const val DEFAULT_OTHER_AMOUNT = "0"
private const val DEFAULT_AMOUNT = "0"

data class AmountData(
    var amount: String = DEFAULT_AMOUNT,
    var otherAmount: String = DEFAULT_OTHER_AMOUNT,
    var currencyCode: String = DEFAULT_CURRENCY_CODE,
    var currencyExponent: Int = DEFAULT_CURRENCY_EXP,
    var symbol: String = DEFAULT_CURRENCY_SYMBOL,
    var nDecimal: Int = DEFAULT_NUMBER_OF_DECIMALS
): IEmpty {

    override fun isEmpty() = (amount == DEFAULT_AMOUNT && otherAmount == DEFAULT_OTHER_AMOUNT
            && currencyCode == DEFAULT_CURRENCY_CODE && currencyExponent == DEFAULT_CURRENCY_EXP
            && symbol == DEFAULT_CURRENCY_SYMBOL && nDecimal == DEFAULT_NUMBER_OF_DECIMALS)

    fun toFormatString(): String = amount.formatAmount(symbol, nDecimal)

    fun clean() = amount.replace(Regex("[$currencyCode,.]"), "")

    val totalAmount
        get() = amount.toLong() + otherAmount.toLong()
}