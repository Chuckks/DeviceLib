package com.bbva.devicelib

import android.content.Context
import com.bbva.devicelib.physical.IPrinter

interface IDeviceCenterCreator {

    fun create(context: Context): IDeviceCenter
}