package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_NUMBER = ""
private const val DEFAULT_SEQUENCE_NUMBER = ""

data class PanData(var number: String = DEFAULT_NUMBER, var sequenceNumber: String = DEFAULT_SEQUENCE_NUMBER):
    IEmpty {
    override fun isEmpty() = number == DEFAULT_NUMBER
}