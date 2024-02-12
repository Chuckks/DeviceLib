package com.bbva.devicelib.emv.outputData.enums.Pem

enum class EPinMode(val code: String) {
    UNKNOW("0"),
    PIN_ENABLE("1"),
    PIN_DISABLE("2"),
    PIN_FAIL("8");

    companion object {

        fun isPresent(code: String) = EPanMode.values().any { it.code == code }
        fun find(code: String) = values().find { it.code == code }
    }
}