package com.bbva.devicelib.emv.inputData

import android.content.pm.Capability

// Byte 2 Tag 9F33
private const val SIGNATURE = 0X20
private const val PIN_ONLINE = 0X40
private const val PIN_OFFLINE = 0X10
private const val NO_CVM = 0x08
private const val PLAIN_TEXT_PIN = 0x80
private const val MOBILE_CVM = 0x80

data class CvmOptions(
    val noCvm: Boolean = false,
    val pinOnline: Boolean = false,
    val pinOffline: Boolean = false,
    val signature: Boolean = false,
    val mobileCvm: Boolean = false,
    val qps: Boolean = false){

    enum class ECapabilities{
        GENERAL,
        AMEX
    }

    private fun toString(option: Int) = String.format("%02X", option)

    fun getNoCvmCapabilities() = toString(NO_CVM)

    fun getCvmCapabilities(capability: ECapabilities = ECapabilities.GENERAL) =
        when(capability) {
            ECapabilities.GENERAL   -> getGeneralCapabilities()
            ECapabilities.AMEX      -> getAmexCapabilities()
        }

    private fun getGeneralOptions(): Int {
        var cvmOption = 0

        if (pinOnline)
            cvmOption += PIN_ONLINE

        if (signature)
            cvmOption += SIGNATURE

        if (pinOffline) {
            cvmOption += PIN_OFFLINE
        }

        return cvmOption
    }

    private fun getGeneralCapabilities(): String {
        var cvmOption = getGeneralOptions()

        if (noCvm)
            cvmOption += NO_CVM

        if (pinOffline)
            cvmOption += PLAIN_TEXT_PIN

        return toString(cvmOption)
    }

    private fun getAmexCapabilities(): String {
        var cvmOption = getGeneralOptions()

        if (mobileCvm)
            cvmOption += MOBILE_CVM

        return toString(cvmOption)
    }

}
