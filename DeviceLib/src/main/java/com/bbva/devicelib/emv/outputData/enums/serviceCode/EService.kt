package com.bbva.devicelib.emv.outputData.enums.serviceCode

enum class EService(val code: Int) {
    NO_RESTRICTIONS_WITH_PIN(0),
    NO_RESTRICTIONS(1),
    GOODS_AND_SERVICE(2),
    ATM_ONLY_WITH_PIN(3),
    CASH_ONLY(4),
    GOODS_AND_SERVICE_WITH_PIN(5),
    NO_RESTRICTIONS_WITH_PIN1(6),
    GOODS_AND_SERVICE_WITH_PIN1(7);

    companion object {
        fun find(code: Int) = values().find { it.code == code }
        fun isPresent(code: Int) = values().any { it.code == code }
    }
}
