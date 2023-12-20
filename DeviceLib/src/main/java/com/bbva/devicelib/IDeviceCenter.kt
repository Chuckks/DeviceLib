package com.bbva.devicelib

import com.bbva.devicelib.connection.IConnect
import com.bbva.devicelib.physical.IAvailable
import com.bbva.devicelib.physical.IPrinter

interface IDeviceCenter: IConnect {

    val printer: IPrinter

    enum class EDevice{
        LED,
        SCAN,
        PRINTER,
        PINPAD,
        HSM,
        CARD,
        EMV,
        SOUND,
        EXTERNAL
    }

    private fun isAvailable(value: IAvailable) = value.isAvailable()
    fun isAvailable(device: EDevice) = isAvailable( getDevice(device) )

    private fun getDevice(device: EDevice) =
        when(device){
            EDevice.LED -> TODO()
            EDevice.SCAN -> TODO()
            EDevice.PRINTER -> printer
            EDevice.PINPAD -> TODO()
            EDevice.HSM -> TODO()
            EDevice.CARD -> TODO()
            EDevice.EMV -> TODO()
            EDevice.SOUND -> TODO()
            EDevice.EXTERNAL -> TODO()
        }
}