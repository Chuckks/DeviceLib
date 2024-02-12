package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.extensions.toHexaByte
import com.bbva.utilitieslib.interfaces.IEmpty
import kotlin.experimental.and

private const val TSI_LENGTH = 4
private const val BYTE_LENGTH = 2
private const val BIT_LENGTH = 8

class Tsi(val tsiData: TsiData = TsiData()): IEmpty {
    override fun isEmpty() = tsiData.isEmpty()
    override fun toString() = tsiData.getAllEnables().map { it.descriptor.value + " " }.toString()

    companion object{

        fun parser(tsi: String): Tsi{
            val length = tsi.length
            if(length != TSI_LENGTH)
                throw Exception("tsi.length $length != TSI_LENGTH $TSI_LENGTH")

            val tsiData =  TsiData()
            for ((position, index) in (0 until length step BYTE_LENGTH).withIndex()){
                unpackByte(tsiData.bytes[position], tsi.substring(index, index + BYTE_LENGTH).toHexaByte())
            }
            return Tsi(tsiData)
        }

        private fun unpackByte(dataBites: TsiDataByte, byte: Byte) {
            for (index in 1..BIT_LENGTH) {
                val position = (1 shl (BIT_LENGTH - index)).toByte()
                dataBites.bits[index - 1].value = ((byte and position).toInt() != 0)
            }
        }
    }
}