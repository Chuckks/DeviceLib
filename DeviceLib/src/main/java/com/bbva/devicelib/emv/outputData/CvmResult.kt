package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.interfaces.IEmpty

//TODO crear Enum EPerformed para ver si es ,PLAINTEXT_PIN, ENCYPHERED_PIN_ONLINE, PLAINTEXT_PIN_SIGNATURE...
//TODO crear Enum EResult patra saber si es FAILED, SUCCESSFUL

private const val DEFAULT_PERFORMED = ""
private const val DEFAULT_RESULT = ""

data class CvmResult(val performed: String = DEFAULT_PERFORMED, val result: String = DEFAULT_RESULT):
    IEmpty {
    override fun isEmpty() = (performed == DEFAULT_PERFORMED && result == DEFAULT_RESULT)
}