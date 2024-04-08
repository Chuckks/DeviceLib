package com.bbva.devicelib.emv.outputData

import android.util.Log
import com.bbva.devicelib.Constant
import com.bbva.utilitieslib.interfaces.IEmpty

private const val PAN_MIN_LENGTH = 12
private const val DEFAULT_MASKED_CHAR = 'X'

private const val MASKED_LAST4 = 4
private const val MASKED_FIRST6 = 6

private const val DEFAULT_NUMBER = ""
private const val DEFAULT_SEQUENCE_NUMBER = ""

private val TAG: String = Constant.BBVA_PREFIX + PanData::class.java.simpleName

data class PanData(var number: String = DEFAULT_NUMBER, var sequenceNumber: String = DEFAULT_SEQUENCE_NUMBER): IEmpty {

    init {
        number = number.trimEnd('F')

        if (!number.isPan(DEFAULT_MASKED_CHAR))
            throw Exception("Format Pan is Wrong Only Numbers [$number]")
    }

    enum class EMask {
        LAST4,
        FIRST6_LAST4
    }

    override fun isEmpty() = number == DEFAULT_NUMBER

    fun getMaskedPan(type: EMask = EMask.FIRST6_LAST4, ch: Char = DEFAULT_MASKED_CHAR): String{
        if(number.length < PAN_MIN_LENGTH){
            Log.w(TAG, "number.length [${number.length}] < PAN_MIN_LENGTH [$PAN_MIN_LENGTH]")
            return ""
        }

        return when(type){
            EMask.LAST4 -> getMaskedPan(0, number.length - MASKED_LAST4, ch)
            EMask.FIRST6_LAST4 -> getMaskedPan(MASKED_FIRST6, number.length - (MASKED_LAST4 + MASKED_FIRST6), ch)
        }
    }

    private fun String.isPan(ch: Char) = this.all { it.isDigit() || it == ch }

    private fun getMaskedPan(starIndex: Int, count: Int, ch: Char): String{
        if(starIndex + count >= number.length)
            throw StringIndexOutOfBoundsException("Start [$starIndex] + count[$count] >= length [${number.length}]")

        return number.replaceRange(starIndex until starIndex + count, ch.toString().repeat(count))
    }
}

class PanDataException(message: String): Exception(message)