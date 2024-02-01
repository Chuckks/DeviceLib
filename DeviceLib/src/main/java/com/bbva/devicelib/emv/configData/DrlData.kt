package com.bbva.devicelib.emv.configData

const val DEFAULT_LIMIT = "000000"

data class DrlData(
    val floorLimit: String = DEFAULT_LIMIT,
    val termFloorLimit: String = DEFAULT_LIMIT)
