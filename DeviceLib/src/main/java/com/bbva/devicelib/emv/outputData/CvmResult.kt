package com.bbva.devicelib.emv.outputData

import com.bbva.devicelib.emv.outputData.enums.cvmResult.EPerformed
import com.bbva.devicelib.emv.outputData.enums.cvmResult.EResult
import com.bbva.utilitieslib.extensions.toHexString
import com.bbva.utilitieslib.extensions.toHexaByte
import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_CVM_CONDITION = "00"
private val DEFAULT_PERFORMED = EPerformed.UNKNOWN
private val DEFAULT_RESULT = EResult.UNKNOWN

data class CvmResult(val performed: EPerformed = DEFAULT_PERFORMED, val result: EResult = DEFAULT_RESULT): IEmpty {

    override fun isEmpty() = (performed == DEFAULT_PERFORMED && result == DEFAULT_RESULT)
    override fun toString() = "${performed.code}$DEFAULT_CVM_CONDITION${result.code}"

    fun isNotCvmRequired() = (performed == EPerformed.NOCVM_REQUIRED)

    fun isSignRequired() =
        when(performed){
            EPerformed.UNKNOWN,
            EPerformed.PLAINTEXT_PIN_SIGNATURE,
            EPerformed.ENCYPHERED_PIN_SIGNATURE,
            EPerformed.SIGNATURE                -> true
            else                                -> false
        }

    fun isPinRequired() =
        when(performed){
            EPerformed.PLAINTEXT_PIN,
            EPerformed.ENCYPHERED_PIN_ONLINE,
            EPerformed.PLAINTEXT_PIN_SIGNATURE,
            EPerformed.ENCYPHERED_PIN_OFFLINE,
            EPerformed.ENCYPHERED_PIN_SIGNATURE -> true
            else                                -> false
        }

    companion object{

        private const val PERFORMED_POSITION = 0
        private const val CONDITION_POSITION = 2
        private const val RESULT_POSITION = 4
        private const val CVM_RESULT_LENGTH = 6
        private const val VERIFICATION_CVM = 0x40

        fun parser(cvmResult: String): CvmResult {
            if (cvmResult.length != CVM_RESULT_LENGTH)
                throw Exception("CvmResult.Length[${cvmResult.length}] != CVM_RESULT_LENGTH[${CVM_RESULT_LENGTH}]")

            val performedCode = cvmResult.substring(PERFORMED_POSITION, CONDITION_POSITION)
            val performed = EPerformed.find(getPerformedCode(performedCode)) ?: throw Exception("Performed not found $performedCode")

            val resultCode = cvmResult.substring(RESULT_POSITION)
            val result = EResult.find(resultCode) ?: throw Exception("Result not found $resultCode")

            return CvmResult(performed, result)
        }

        private fun getPerformedCode(performedCode: String): String {
            val performed = performedCode.toHexaByte() - VERIFICATION_CVM
            return if (performed < 0)
                performedCode
            else
                performed.toHexString().uppercase()
        }
    }

}