package com.bbva.devicelib.emv.configData

import com.bbva.utilitieslib.interfaces.IEmpty

data class Tlv(var tag: String = "", var value: String = "") : IEmpty{

    override fun isEmpty() = value.isEmpty()
}
