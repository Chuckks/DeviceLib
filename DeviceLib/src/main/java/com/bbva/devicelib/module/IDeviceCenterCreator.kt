package com.bbva.devicelib.module

import android.content.Context

interface IDeviceCenterCreator {

    fun create(context: Context): IDeviceCenter
}