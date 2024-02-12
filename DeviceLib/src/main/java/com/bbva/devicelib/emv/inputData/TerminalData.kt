package com.bbva.devicelib.emv.inputData

import com.bbva.devicelib.emv.inputData.enums.ETrans

data class TerminalData(
    var terminalId: String = "",
    var merchantId: String = "",
    var currencyCode: String = "",
    var transType: ETrans = ETrans.GOOD_SERVICE
)