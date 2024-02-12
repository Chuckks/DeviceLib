package com.bbva.devicelib.emv.outputData.enums.serviceCode

enum class EAuthorization(val code: Int) {
    NORMAL(0),
    USER_ONLINE(2),
    USER_ONLINE_EXPLICIT(4);

    companion object {
        fun find(code: Int) = values().find { it.code == code }
        fun isPresent(code: Int) = values().any { it.code == code }
    }
}