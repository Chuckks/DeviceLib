package com.bbva.devicelib.emv.inputData

import com.bbva.devicelib.emv.inputData.enums.EOnlineStatus

data class HostResponseData(
    val tvlList: String = "",
    val removeCard: Boolean = false,
    val onlineStatus: EOnlineStatus = EOnlineStatus.FAILED
)