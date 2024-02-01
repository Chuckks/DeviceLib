package com.bbva.devicelib.emv.configData

enum class EFormat {
    ASCII,
    NUMERIC,
    HEXA,
    UNKNOW
}

data class TagData(val code: String, val format: EFormat, val minLength: Int, val maxLength: Int = minLength)
