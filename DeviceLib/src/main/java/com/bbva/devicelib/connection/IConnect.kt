package com.bbva.devicelib.connection

interface IConnect {

    fun isConnected(): Boolean
    fun connect(): Boolean
    fun disconnect(): Boolean

}