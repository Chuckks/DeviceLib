package com.bbva.devicelib.emv.configData

import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_DATA = ""

data class SpecificData(
    var name: String = DEFAULT_DATA,
    var tag: String = DEFAULT_DATA,
    var value: String = DEFAULT_DATA
): IEmpty {

    override fun isEmpty() = (name == DEFAULT_DATA && tag == DEFAULT_DATA && value == DEFAULT_DATA)
}
