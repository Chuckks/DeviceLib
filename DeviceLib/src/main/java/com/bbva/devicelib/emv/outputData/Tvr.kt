package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.extensions.toHexaByte
import com.bbva.utilitieslib.interfaces.IEmpty
import kotlin.experimental.and

private const val TVR_LENGTH = 10
private const val BYTE_LENGTH = 2
private const val BIT_LENGTH = 8

class Tvr(val tvrData: TvrData = TvrData()): IEmpty {

    override fun isEmpty() = tvrData.isEmpty()
    override fun toString() = tvrData.getAllEnables().map { it.descriptor.value + " " }.toString()

    companion object {

        fun parser(tvr: String): Tvr {
            val length = tvr.length

            if (length != TVR_LENGTH)
                throw Exception("tvr.length $length != TVR_LENGTH $TVR_LENGTH")

            val tvrData = TvrData()

            for ((position, index) in (0 until length step BYTE_LENGTH).withIndex()) {
                unpackByte(tvrData.bytes[position], tvr.substring(index, index + BYTE_LENGTH).toHexaByte())
            }
            return Tvr(tvrData)
        }

        private fun unpackByte(dataBites: TvrDataByte, byte: Byte) {
            for (i in 1..BIT_LENGTH) {
                val position = (1 shl (BIT_LENGTH - i)).toByte()
                dataBites.bits[i - 1].value = ((byte and position).toInt() != 0)
            }
        }
    }
}