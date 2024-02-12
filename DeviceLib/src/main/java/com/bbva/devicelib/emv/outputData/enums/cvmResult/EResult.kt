package com.bbva.devicelib.emv.outputData.enums.cvmResult

enum class EResult(val code: String) {
    UNKNOWN("00"),
    FAILED("01"),
    SUCCESSFUL("02");

    companion object {

        fun find(code: String) = values().find { it.code == code }
    }
}