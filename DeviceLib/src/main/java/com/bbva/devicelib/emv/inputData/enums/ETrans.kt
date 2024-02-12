package com.bbva.devicelib.emv.inputData.enums

enum class ETrans(val type: String) {
    GOOD_SERVICE("00"),
    CASH("01"),
    CASHBACK("09"),
    PURCHASE_WITH_CASHBACK("17"),
    REFUND("20")
}