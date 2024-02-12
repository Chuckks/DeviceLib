package com.bbva.devicelib.emv.inputData.enums

enum class EAccount(val type: String) {
    DEFAULT("00"),
    SAVINGS("10"),
    DEBIT("20"),
    CREDIT("30")
}