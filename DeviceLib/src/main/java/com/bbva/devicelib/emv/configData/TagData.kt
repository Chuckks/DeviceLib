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
    TERM_MERCHANT_CATEGORY(TagData("9F15", EFormat.NUMERIC, 2)),

    //@AID
    AID_VERSION_NUMBER(TagData("9F09", EFormat.HEXA, 2)),
    AID_ACQUIRER_IDENTIFIER(TagData("9F01", EFormat.NUMERIC, 6)),
    AID_TX_REF_CURRENCY_CODE(TagData("9F3C", EFormat.NUMERIC, 2)),
    AID_MERCHANT_NAME_LOCATION(TagData("9F4E", EFormat.ASCII, 50)),

    //@TX
    TX_CURRENCY_EXP(TagData("5F36", EFormat.NUMERIC, 1)),
    TX_COUNTRY_CODE(TagData("9F1A", EFormat.NUMERIC, 2)),
    TX_AMOUNT(TagData("9F02", EFormat.NUMERIC, 6)),
    TX_OTHER_AMOUNT(TagData("9F03", EFormat.NUMERIC, 6)),
    TX_DATE(TagData("9A", EFormat.NUMERIC, 3)),
    TX_SECUENCE_NUMBER(TagData("9F41", EFormat.NUMERIC, 2, 4)),
    TX_TSI(TagData("9B", EFormat.HEXA, 2)),
    TX_TVR(TagData("95", EFormat.HEXA, 5)),
    TX_TRANS_TYPE(TagData("9C", EFormat.NUMERIC, 1)),
    TX_CVM_RESULT(TagData("9F34", EFormat.HEXA, 3)),
    TX_UNPREDITABLE_NUMBER(TagData("9F37", EFormat.HEXA, 4)),
    TX_POS_ENTRY_MODE(TagData("9F39", EFormat.NUMERIC, 1)),
    TX_FACTOR_INDICATOR(TagData("9F6E", EFormat.HEXA, 4)),
    TX_APP_TRANSACTION_COUNTER(TagData("9F36", EFormat.HEXA, 2)),

    //@ICC
    ICC_TRACK2(TagData("57", EFormat.HEXA, 0, 19)),
    ICC_EXP_DATE(TagData("5F24", EFormat.NUMERIC, 3)),
    ICC_SERVICE_CODE(TagData("5F30", EFormat.HEXA, 2)),
    ICC_CAPK_INDEX(TagData("8F", EFormat.HEXA, 1)),
    ICC_APP_CRYPTOGRAM(TagData("9F26", EFormat.HEXA, 8)),
    ICC_ISSUER_ID(TagData("42", EFormat.NUMERIC, 3)),
    ICC_PAN_SECUENCE_NUM(TagData("5F34", EFormat.NUMERIC, 1)),
    ICC_PAN(TagData("5A", EFormat.HEXA, 4, 10)),
    ICC_AID(TagData("4F", EFormat.HEXA, 5, 16)),
    ICC_CARDHOLDER_NAME(TagData("5F20", EFormat.ASCII, 2, 26)),
    ICC_CRYPTO_INFO_DATA(TagData("9F27", EFormat.HEXA, 1)),
    ICC_APP_NAME(TagData("9F12", EFormat.ASCII, 1, 16)),
    ICC_PREFERRED_NAME(TagData("9F12", EFormat.ASCII, 1, 16)),
    ICC_APP_LABEL(TagData("50", EFormat.ASCII, 1, 16)),

    //@CTLS VISA
    CTLS_VISA_TTQ(TagData("9F66", EFormat.HEXA, 4)),

    //@CTLS MC
    CTLS_MC_CARD_DATA_INPUT_CAPABILITY(TagData("DF8117", EFormat.HEXA, 1)),
    CTLS_MC_CVM_CAPABILITY(TagData("DF8118", EFormat.HEXA, 1)),
    CTLS_MC_NO_CVM_CAPABILITY(TagData("DF8119", EFormat.HEXA, 1)),
    CTLS_MC_TAC_DEFAULT(TagData("DF8120", EFormat.HEXA, 5)),
    CTLS_MC_TAC_DENIAL(TagData("DF8121", EFormat.HEXA, 5)),
    CTLS_MC_TAC_ONLINE(TagData("DF8122", EFormat.HEXA, 5)),
    CTLS_MC_READER_FLOOT_LIMIT(TagData("DF8123", EFormat.NUMERIC, 6)),
    CTLS_MC_TRANSACTION_LIMIT_NO_CDCVM(TagData("DF8124", EFormat.NUMERIC, 6)),
    CTLS_MC_TRANSACTION_LIMIT_CDCVM(TagData("DF8125", EFormat.NUMERIC, 6)),
    CTLS_MC_CVM_REQUIRED_LIMIT(TagData("DF8126", EFormat.NUMERIC, 6)),
    CTLS_OUTCOME_PARAMETER_SET(TagData("DF8129", EFormat.HEXA, 8)),
    CTLS_MC_HOLD_TIME_VALUE(TagData("DF8130", EFormat.HEXA, 1)),
    CTLS_MC_KERNEL_CONFIGURATION(TagData("DF811B", EFormat.HEXA, 1)),
    CTLS_MC_LIFETIME_TRANS_LOG(TagData("DF811C", EFormat.HEXA, 2)),
    CTLS_MC_MESG_HOLD_TIME(TagData("DF812D", EFormat.NUMERIC, 3)),
    CTLS_MC_MAG_STRIPE_CVM_CAPABILITY(TagData("DF811E", EFormat.HEXA, 1)),
    CTLS_MC_SECURITY_CAPABILITY(TagData("DF811F", EFormat.HEXA, 1)),
    CTLS_MC_MAG_STRIPE_NO_CVM_CAPABILITY(TagData("DF812C", EFormat.HEXA, 1)),
    CTLS_MC_MAX_NUMBER_TRANS_LOG(TagData("DF811D", EFormat.HEXA, 1)),

    //@CTLS AE
    CTLS_AE_READER_CAPABILITY(TagData("9F6D", EFormat.HEXA, 1)),
    CTLS_AE_ENHANCED_READER_CAPABILITY(TagData("9F6E", EFormat.HEXA, 4)),
    CTLS_AE_DRL_SETS(TagData("DF8167", EFormat.HEXA, 19)),
    CTLS_AE_SUPPORT_DELAYED_AUTH(TagData("DF8168", EFormat.HEXA, 1)),
    CTLS_AE_GO_ONLINE(TagData("DF8169", EFormat.HEXA, 1)),
    CTLS_AE_UN_RANGE(TagData("DF8170", EFormat.NUMERIC, 2)),

    //@ISSUER
    ISSUER_AUTH_RESP_CODE(TagData("8A", EFormat.ASCII, 2)),
    ISSUER_AUTH_DATA(TagData("91", EFormat.HEXA, 8, 16)),
    ISSUER_AUTH_CODE(TagData("89", EFormat.ASCII, 6)),
    ISSUER_SCRIPT71(TagData("71", EFormat.HEXA, 0, 128)),
    ISSUER_SCRIPT72(TagData("72", EFormat.HEXA, 0, 128));

    fun isFixed() = (tagData.minLength == tagData.maxLength)
    fun isVariable() = !isFixed()

    fun isTag(tagCode: String) = tagData.code == tagCode
    fun isTag(tagData: TagData) = isTag(tagData.code)
}