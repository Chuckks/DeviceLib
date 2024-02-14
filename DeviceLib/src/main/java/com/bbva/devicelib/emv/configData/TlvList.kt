package com.bbva.devicelib.emv.configData

import com.bbva.utilitieslib.extensions.toHexaString


class TlvList(value: List<Tlv> = listOf()) {

    private val list: MutableList<Tlv> = value.toMutableList()

    fun add(value: Tlv) = list.add(value)
    fun remove(value: Tlv) = list.remove(value)

    fun find(tagData: TagData) = list.find { it.tag == tagData.code }
    fun forEach(action: (Tlv) -> Unit) = list.forEach(action)

    fun map(transform: (Tlv) -> String) = list.map(transform)

    fun get(index: Int) = list[index]
    fun set(index: Int, value: Tlv) = list.set(index, value)

    operator fun plus(other: TlvList): TlvList = TlvList(list + other.list)

    fun pack(): String {
        val builder = StringBuilder()

        list.forEach { tlv -> builder.append(tlv.pack()) }
        return builder.toString()
    }

    companion object {

        fun parser(tlvList: ByteArray) = parser( tlvList.toHexaString() )

        fun parser(tlvList: String) = TlvList().apply {
            var index = 0

            while (index < tlvList.length) {
                val pair = Tlv.parser(tlvList, index)
                index += pair.second
                list.add(pair.first)
            }
        }
    }
}