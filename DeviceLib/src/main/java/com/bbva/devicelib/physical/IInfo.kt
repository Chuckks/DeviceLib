package com.bbva.devicelib.physical

interface IInfo {
    enum class EType {
        SDK_VERSION,
        HARDWARE_VERSION,
        FIRMWARE_VERSION,
        SERIAL_NUMBER,
        DEVICE_CODE,
        DEVICE_MODEL,
        EMV_VERSION,
        EMV_KERNEL_CHECKSUM,
        IS_CHARGING,
        IS_KEYBOARD_AVAILABLE,
        IS_PRINTER_AVAILABLE,
        BATTERY_PERCENTAGE,
        MANUFACTURE,
        MAC_ADDRESS,
        POS_ID,
        LEVEL_BATTERY
    }

    fun getInfo(type: EType): String
}