package com.bbva.devicelib.emv.outputData

import com.bbva.devicelib.emv.outputData.enums.Pem.EPanMode
import com.bbva.devicelib.emv.outputData.enums.Pem.EPinMode
import com.bbva.utilitieslib.interfaces.IEmpty

private val DEFAULT_PAN_MODE = EPanMode.UNKNOW
private val DEFAULT_PIN_MODE = EPinMode.UNKNOW

class PemData(
    val panMode: EPanMode = DEFAULT_PAN_MODE,
    val pinMode: EPinMode = DEFAULT_PIN_MODE): IEmpty {

    override fun isEmpty() = (panMode == DEFAULT_PAN_MODE && pinMode == DEFAULT_PIN_MODE)
    override fun toString() = panMode.code + pinMode.code

    companion object{
        private const val PAN_MODE_POSITION = 0
        private const val PIN_MODE_POSITION = 2
        private const val PEM_LENGTH = 3

        fun parser(value: String): PemData {
            if (value.length != PEM_LENGTH)
                throw Exception("PosEntryMode.Length [${value.length}]!= POS_ENTRY_MODE_LENGTH[$PEM_LENGTH]")

            val panModeCode = value.substring(PAN_MODE_POSITION, PIN_MODE_POSITION)
            val panMode = EPanMode.find(panModeCode) ?: throw  Exception("Pan Mode not found $panModeCode")

            val pinModeCode = value.substring(PIN_MODE_POSITION)
            val pinMode = EPinMode.find(pinModeCode) ?: throw  Exception("Service not found $pinModeCode")

            return PemData(panMode, pinMode)
        }
    }
}