package com.bbva.devicelib.connection

import android.content.Context

interface ISdkConnect {

    fun isConnected(): Boolean
    fun connect(context: Context): Boolean
    fun disconnect(context: Context): Boolean
}