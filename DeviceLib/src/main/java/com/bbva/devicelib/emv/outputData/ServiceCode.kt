package com.bbva.devicelib.emv.outputData

import com.bbva.devicelib.emv.outputData.enums.serviceCode.EAuthorization
import com.bbva.devicelib.emv.outputData.enums.serviceCode.EInterchange
import com.bbva.devicelib.emv.outputData.enums.serviceCode.EService
import com.bbva.utilitieslib.extensions.toHexa
import com.bbva.utilitieslib.interfaces.IEmpty

private val DEFAULT_INTERCHANGE = EInterchange.NONE
private val DEFAULT_SERVICE = EService.NO_RESTRICTIONS
private val DEFAULT_AUTHORIZATION = EAuthorization.NORMAL

data class ServiceCode(
    var interchange: EInterchange = DEFAULT_INTERCHANGE,
    val service: EService = DEFAULT_SERVICE,
    val authorization: EAuthorization = DEFAULT_AUTHORIZATION,
) : IEmpty{

    override fun isEmpty() = (interchange == DEFAULT_INTERCHANGE && authorization == DEFAULT_AUTHORIZATION && service == DEFAULT_SERVICE)

    override fun toString() = "${interchange.code}${authorization.code}${service.code}"

    fun isPinRequired() =
        when(service){
            EService.NO_RESTRICTIONS_WITH_PIN,
            EService.ATM_ONLY_WITH_PIN,
            EService.GOODS_AND_SERVICE_WITH_PIN,
            EService.NO_RESTRICTIONS_WITH_PIN1,
            EService.GOODS_AND_SERVICE_WITH_PIN1    -> true
            else                                    -> false
        }

    fun isChipCard() =
        when(interchange){
            EInterchange.INTERNATIONAL_WITH_ICC,
            EInterchange.NATIONAL_WITH_ICC  -> true
            else                            -> false
        }

    fun isInternationalAvailable() =
        when (interchange) {
            EInterchange.INTERNATIONAL,
            EInterchange.INTERNATIONAL_WITH_ICC -> true
            else                                -> false
    }

    fun isNationalAvailable() =
        when (interchange) {
            EInterchange.NATIONAL_WITH_ICC,
            EInterchange.NATIONAL           -> true
            else                            -> false
    }

    companion object{

        private const val SERVICE_CODE_LENGTH = 3
        private const val INTERCHANGE_POSITION = 0
        private const val AUTHORIZATION_POSITION = 1
        private const val SERVICE_POSITION = 3

        fun parser(serviceCode: String): ServiceCode{
            if (serviceCode.length != SERVICE_CODE_LENGTH)
                throw Exception("ServiceCode.Length [${serviceCode.length}] != SERVICE_CODE_LENGTH[$SERVICE_CODE_LENGTH]")

            val interchangeCode = serviceCode[INTERCHANGE_POSITION].toHexa()
            val interchance = EInterchange.find(interchangeCode) ?: throw  Exception("Interchange not found $interchangeCode")

            val authorizationCode = serviceCode[AUTHORIZATION_POSITION].toHexa()
            val authorization = EAuthorization.find(authorizationCode) ?: throw  Exception("AutorizationCode not found $authorizationCode")

            val srvCode = serviceCode[SERVICE_POSITION].toHexa()
            val service = EService.find(srvCode) ?: throw  Exception("AutorizationCode not found $authorizationCode")

            return ServiceCode(interchance, service, authorization)
        }
    }
}