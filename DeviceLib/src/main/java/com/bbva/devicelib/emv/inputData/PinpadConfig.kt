package com.bbva.devicelib.emv.inputData

import com.bbva.utilitieslib.utils.TimeSpan

data class PinpadConfig(
    var keyIndex: Int = 0,
    var dukpt: Boolean = false,
    var timeout: TimeSpan = TimeSpan(50000)
)