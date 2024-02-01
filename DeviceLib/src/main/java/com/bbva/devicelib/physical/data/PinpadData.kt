package com.bbva.devicelib.physical.data

import com.bbva.utilitieslib.interfaces.IEmpty
import com.bbva.utilitieslib.utils.TimeSpan

private const val DEFAULT_KEY_INDEX = 0
private val DEFAULT_TIMEOUT = TimeSpan(60000)
private const val DEFAULT_MIN = 4
private const val DEFAULT_MAX = 6

data class PinpadData(var keyIndex: Int = DEFAULT_KEY_INDEX, var timeout: TimeSpan = DEFAULT_TIMEOUT):
    IEmpty {
    var maxInputLen: Int = 6
    var minInputLen: Int = 4
    var supportbypass: Boolean = false
    var orderNumKey: Boolean = true
    var offline: Boolean = false
    var dukpt: Boolean = false

    override fun isEmpty() = keyIndex == DEFAULT_KEY_INDEX && timeout == DEFAULT_TIMEOUT
            && minInputLen == DEFAULT_MIN && maxInputLen == DEFAULT_MAX
}
