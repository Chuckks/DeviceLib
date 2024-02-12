package com.bbva.devicelib.emv.outputData.enums.serviceCode

enum class EInterchange(val code: Int) {
    NONE(0),
    INTERNATIONAL(1),
    INTERNATIONAL_WITH_ICC(2),
    NATIONAL(5),
    NATIONAL_WITH_ICC(6),
    NO_INTERCHANGE(7);

    companion object{
        fun find(code: Int) = values().find { it.code == code }
        fun isPresent(code: Int) = values().any { it.code == code }
    }
}