package com.bbva.devicelib.emv.configData

data class CtlsSpecificData(
    var icc: List<SpecificData> = arrayListOf(),
    var paypass: List<SpecificData> = arrayListOf(),
    var paywave: List<SpecificData> = arrayListOf(),
    var expresspay: List<SpecificData> = arrayListOf()
)
