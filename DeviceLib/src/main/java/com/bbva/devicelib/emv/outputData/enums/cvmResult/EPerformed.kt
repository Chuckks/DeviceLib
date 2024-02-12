package com.bbva.devicelib.emv.outputData.enums.cvmResult

enum class EPerformed(val code: String) {
    UNKNOWN("00"),
    PLAINTEXT_PIN("01"),
    ENCYPHERED_PIN_ONLINE("02"),
    PLAINTEXT_PIN_SIGNATURE("03"),
    ENCYPHERED_PIN_OFFLINE("04"),
    ENCYPHERED_PIN_SIGNATURE("05"),
    SIGNATURE("1E"),
    NOCVM_REQUIRED("1F"),
    NOCVM_PERFORMED("3F");

    companion object {
        fun find(code: String) = values().find { it.code == code }
    }
}