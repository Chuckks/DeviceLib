package com.bbva.devicelib.emv.outputData

import com.bbva.devicelib.emv.outputData.enums.tsi.ETsiDescriptor
import com.bbva.utilitieslib.interfaces.IEmpty

private const val BYTES_TSI_LENGTH = 2
private const val BIT_LENGTH = 8

class TsiData: IEmpty {

    val bytes = List(BYTES_TSI_LENGTH) {
        TsiDataByte(it)
    }

    override fun isEmpty() = false
    fun getEnables(nByte: Int) = bytes[nByte].getEnables()

    fun getAllEnables(): List<TsiDataBit>{
        val list = ArrayList<TsiDataBit>()

        for(index in 0 until BYTES_TSI_LENGTH){
            list.addAll(getEnables(index))
        }

        return list
    }
}

class TsiDataByte(number: Int): IEmpty{
    val bits = List(BIT_LENGTH) {
        TsiDataBit(ETsiDescriptor.values()[(number * BIT_LENGTH) + it], false)
    }

    override fun isEmpty() = bits.all { !it.value }
    fun getEnables() = bits.filter { it.value }
}

data class TsiDataBit(val descriptor: ETsiDescriptor, var value: Boolean) {
    override fun toString() = "Position [${descriptor.name}] - Value [$value] - Name [${descriptor.value}"
}