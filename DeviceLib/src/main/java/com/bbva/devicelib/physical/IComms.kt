package com.bbva.devicelib.physical

import android.os.Bundle
import com.bbva.utilitieslib.utils.TimeSpan

interface IComms {

    var readTimeout: TimeSpan
    var maxSize: Int
    var params: Bundle

    fun open(): Boolean
    fun close(): Boolean

    fun flush()
    fun isOpened(): Boolean

    fun write(ch: Byte): Boolean
    fun write(data: String): Boolean
    fun write(data: ByteArray): Boolean

    fun readByte(): Byte
    fun readString(): String
    fun readByteArray(): ByteArray
}
