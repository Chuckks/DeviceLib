package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.interfaces.IEmpty

class Tsi(val tsiData: TsiData = TsiData()): IEmpty {
    override fun isEmpty() = tsiData.isEmpty()
}