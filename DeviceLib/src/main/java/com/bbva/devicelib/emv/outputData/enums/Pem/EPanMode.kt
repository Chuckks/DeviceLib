package com.bbva.devicelib.emv.outputData.enums.Pem

enum class EPanMode(val code: String) {
    UNKNOW("00"),
    MANUAL("01"),
    MAG("02"),
    CHIP("05"),
    CTLS_CHIP("07"),
    FALLBACK("90"), //TODO Validar si es un 80
    CTLS_MAG("91");

    companion object {

        fun isPresent(code: String) = values().any { it.code == code }
        fun find(code: String) = values().find { it.code == code }
    }
}