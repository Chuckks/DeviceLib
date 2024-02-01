package com.bbva.devicelib.module

import com.bbva.devicelib.connection.IConnect
import com.bbva.devicelib.emv.IEmvConfig
import com.bbva.devicelib.emv.IEmvProcess
import com.bbva.devicelib.physical.IAvailable
import com.bbva.devicelib.physical.*
import com.bbva.devicelib.physical.IPrinter

interface IDeviceCenter: IConnect {

    val led: ILed
    val info: IInfo
    val power: IPower
    val scan: IScan
    val printer: IPrinter
    val screen: IScreen
    val pinpad: IPinpad
    val sound: ISound
    val card: ICard
    val hsm: IHsm
    val comm: IComms
    val emvConfig: IEmvConfig
    val emvProcess: IEmvProcess
    val permissions: IPermissions
    val softwareInstall: ISoftwareInstall

    enum class EDevice {
        LED,
        SCAN,
        PRINTER,
        PINPAD,
        HSM,
        CARD,
        EMV,
        SOUND
    }

    private fun isAvailable(value: IAvailable) = value.isAvailable()
    fun isAvailable(device: EDevice) = isAvailable(getDevice(device))

    private fun getDevice(device: EDevice): IAvailable =
        when (device) {
            EDevice.LED      -> led
            EDevice.SCAN     -> scan
            EDevice.PRINTER  -> printer
            EDevice.PINPAD   -> pinpad
            EDevice.HSM      -> hsm
            EDevice.CARD     -> card
            EDevice.EMV      -> emvProcess
            EDevice.SOUND    -> sound
        }
}