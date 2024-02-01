package com.bbva.devicelib.emv.inputData

data class CvmOptions(
    val noCvm: Boolean = false,
    val pinOnline: Boolean = false,
    val pinOffline: Boolean = false,
    val signature: Boolean = false,
    val mobileCvm: Boolean = false,
    val qps: Boolean = false
)
