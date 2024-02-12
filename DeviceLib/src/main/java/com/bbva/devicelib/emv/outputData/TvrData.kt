package com.bbva.devicelib.emv.outputData

import com.bbva.devicelib.emv.outputData.enums.tvr.ETvrDescriptor
import com.bbva.utilitieslib.interfaces.IEmpty

private const val BYTES_TVR_LENGTH = 5
private const val BIT_LENGTH = 8

class TvrData: IEmpty {

    val bytes = List(BYTES_TVR_LENGTH) {
        TvrDataByte(it)
    }

    override fun isEmpty() = bytes.all { it.isEmpty() }

    fun getEnables(nByte: Int) = bytes[nByte].getEnables()

    fun getAllEnables(): List<TvrDataBit> {

        val listAll = ArrayList<TvrDataBit>()

        for (i in 0 until BYTES_TVR_LENGTH)
            listAll.addAll(getEnables(i))

        return listAll
    }
}

class TvrDataByte(number: Int): IEmpty {

    val bits = List(BIT_LENGTH) {
        TvrDataBit(ETvrDescriptor.values()[(number * BIT_LENGTH) + it], false)
    }

    override fun isEmpty() = bits.all { !it.value }
    fun getEnables() = bits.filter { it.value }
}

data class TvrDataBit(val descriptor: ETvrDescriptor, var value: Boolean) {

    override fun toString() = "Position [${descriptor.name}] - Value [$value] - Name [${descriptor.value}"
}
