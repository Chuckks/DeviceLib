package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_APP_ID = ""
private const val DEFAULT_APP_NAME = ""

data class Application(
    var id: String = DEFAULT_APP_ID,
    var name: String = DEFAULT_APP_NAME,
    var label: String = DEFAULT_APP_NAME,
    var preferredName: String = DEFAULT_APP_NAME,
): IEmpty {

    override fun isEmpty() =
        id == DEFAULT_APP_ID && name == DEFAULT_APP_NAME && preferredName == DEFAULT_APP_NAME && label == DEFAULT_APP_NAME
}
