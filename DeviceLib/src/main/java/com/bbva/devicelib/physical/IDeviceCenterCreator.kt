package com.bbva.devicelib.physical

import android.content.Context

interface IDeviceCenterCreator {

    fun create(context: Context): IDeviceCenter
}