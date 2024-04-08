package com.bbva.devicelib.emv.configData

import com.bbva.devicelib.Constant
import com.bbva.utilitieslib.extensions.toHexaByte
import com.bbva.utilitieslib.extensions.toHexaString
import com.bbva.utilitieslib.interfaces.IEmpty

const val FIRST_MASK = "81"
const val SECOND_MASK = "82"
const val CHARS_SIZE = 2

const val FIRST_MAX_LENGTH = 127
const val SECOND_MAX_LENGTH = 255
const val MAX_LENGTH_SIZE = 6

private val TAG = Constant.DEV_PREFIX + Tlv::class.java.simpleName
private const val DEFAULT_PAD_CHAR = '0'


enum class EFmtType{
    BIN,
    ASCII
}

data class Tlv(var tag: String = "", var value: String = ""): IEmpty {
    constructor(tagData: TagData, char: Char = DEFAULT_PAD_CHAR): this(tagData.code, fillDefaultData(tagData, char))
    constructor(tag: String, value: ByteArray): this(tag, convert(value))
    constructor(tagData: TagData, value: ByteArray): this(tagData.code, value)
    constructor(tagData: TagData, value: String): this(tagData.code, convert(tagData, value))
    constructor(tagData: TagData, value: Int): this(tagData.code, convertToNumeric(tagData, value))

    fun setValue(value: ByteArray) {
        this.value = value.toHexaString()
    }

    override fun isEmpty() = value.isEmpty()

    fun pack(format: EFmtType = EFmtType.BIN) = StringBuilder()
        .append(tag)
        .append(calculateLength(if (format == EFmtType.ASCII) value.length else value.length / 2))
        .append(value).toString()

    companion object {

        private fun fillDefaultData(tagData: TagData, char: Char) =
            String().padStart(tagData.maxLength * 2, char)

        fun parser(tlv: String, format: EFmtType): Tlv = parser(tlv, 0, format).first

        fun parser(tlv: String, startIndex: Int, format: EFmtType) : Pair<Tlv, Int>{
            var index = startIndex

            val (tagAux, tagSize) = unpackTag(tlv, index)
            index += tagSize

            val (valueAux, valueSize) = unpackValue(tlv, index, format)
            index += valueSize

            return Pair(Tlv(tagAux, valueAux), index - startIndex)
        }

        fun convertToNumeric(tagData: TagData, value: Int): String {
            return if (tagData.format == EFormat.NUMERIC)
                convert(tagData, value.toString())
            else
                throw NumberFormatException("$TAG -> Tag format wrong [$tagData.format]")
        }

        fun convert(tagData: TagData, value: String): String {
            return when (tagData.format) {
                EFormat.NUMERIC -> value.padStart(tagData.maxLength * 2, DEFAULT_PAD_CHAR)
                else            -> value
            }
        }

        fun convert(value: ByteArray) = value.toHexaString()

        private fun calculateLength(valueLength: Int): String {
            var fillLengthSize = 2
            val lengthBuilder = StringBuilder(MAX_LENGTH_SIZE)

            when {
                valueLength > SECOND_MAX_LENGTH -> {
                    lengthBuilder.append(SECOND_MASK)
                    fillLengthSize = 4
                }

                valueLength > FIRST_MAX_LENGTH  -> {
                    lengthBuilder.append(FIRST_MASK)

                }
            }

            lengthBuilder.append(String.format("%0${fillLengthSize}x", valueLength))
            return lengthBuilder.toString()
        }

        private fun unpackLength(data: String, startIndex: Int, format: EFmtType): Pair<Int, Int> {
            var index: Int = startIndex
            var length = data.substring(index, index + CHARS_SIZE)
            index += CHARS_SIZE

            if (length == FIRST_MASK) {
                length = data.substring(index, index + CHARS_SIZE)
                index += CHARS_SIZE
            }
            else if (length == SECOND_MASK) {
                length = data.substring(index, index + CHARS_SIZE * 2)
                index += CHARS_SIZE * 2
            }

            val size = if(format == EFmtType.BIN) length.toInt(16) * CHARS_SIZE else length.toInt(16)

            return Pair(size, index - startIndex)
        }


        private fun unpackTag(data: String, startIndex: Int): Pair<String, Int> {
            var index: Int = startIndex
            val readMaxTags = 3
            val tagSequence = java.lang.StringBuilder(4)

            var tag = data.substring(index, index + CHARS_SIZE)
            index += CHARS_SIZE
            tagSequence.append(tag)

            if ((tag.toHexaByte().toInt() and 0x1F) == 0x1F) {
                for (point in 0 until readMaxTags) {
                    val tagContinue = data.substring(index, index + CHARS_SIZE)
                    index += CHARS_SIZE
                    if ((tagContinue.toHexaByte().toInt() and 0x80) != 0x80) {
                        tagSequence.append(tagContinue)
                        break
                    }
                    tagSequence.append(tagContinue)
                }
            }
            return Pair(tagSequence.toString(), index - startIndex)
        }

        private fun unpackValue(data: String, startIndex: Int, format: EFmtType): Pair<String, Int> {
            val (length, size) = unpackLength(data, startIndex, format)
            val index = startIndex + size
            return Pair(data.substring(index, index + length), length + size)
        }
    }
}

