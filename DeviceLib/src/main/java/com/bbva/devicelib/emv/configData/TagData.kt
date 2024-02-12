package com.bbva.devicelib.emv.configData

enum class EFormat {
    ASCII,
    NUMERIC,
    HEXA,
    UNKNOW
}

data class TagData(val code: String, val format: EFormat, val minLength: Int, val maxLength: Int = minLength)

enum class ETag(val tagData: TagData) {

    //@TERMINAL
    TERM_TYPE(TagData("9F35", EFormat.NUMERIC, 1)),
    TERM_CAPABILITIES(TagData("9F33", EFormat.HEXA, 3)),
    TERM_ADD_CAPABILITIES(TagData("9F40", EFormat.HEXA, 5)),
    TERM_CURRENCY_CODE(TagData("5F2A", EFormat.NUMERIC, 2)),
    TERM_TAG_IFDSN(TagData("9F1E", EFormat.ASCII, 8)),
    TERM_TAG_TM_AID(TagData("9F06", EFormat.HEXA, 5, 16)),
    TERM_ID(TagData("9F1C", EFormat.ASCII, 8)),
    TERM_MERCHANT_ID(TagData("9F16", EFormat.ASCII, 15)),
    TERM_RISK_MANAGEMENT_DATA(TagData("9F1D", EFormat.HEXA, 1, 8)),
    TERM_MERCHANT_CATEGORY(TagData("9F15", EFormat.NUMERIC, 2));

    fun isTag(tagCode: String) = tagData.code == tagCode
    fun isTag(tagData: TagData) = isTag(tagData.code)
}