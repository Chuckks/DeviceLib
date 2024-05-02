package com.bbva.devicelib.emv

import com.bbva.devicelib.emv.inputData.HostResponseData
import com.bbva.devicelib.emv.outputData.OutputData
import com.bbva.devicelib.emv.outputData.PanData
import com.bbva.devicelib.physical.ICard
import java.io.Serializable

interface IEmvProcessView : Serializable {

    fun displaySupportedCards(cardsAvailable: Set<ICard.EType>)
    fun displayDetectedCard(cardType: ICard.EType)

    fun promptUserToSelectApp(appNames: List<String>)
    fun promptUserToConfirmCardNumber(pan: PanData)

    fun captureUserSignature()
    fun promptUserForPin()

    fun sendTransactionRequest(outputData: OutputData): HostResponseData
    fun displaySuccessTransaction()

    fun displayFailedTransaction()
    fun displayTransactionError(errorCode: IEmvProcess.EError)

    fun promptUserToRemoveCard()
}