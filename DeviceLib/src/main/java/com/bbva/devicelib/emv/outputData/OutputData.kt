package com.bbva.devicelib.emv.outputData

import com.bbva.devicelib.physical.ICard
import com.bbva.utilitieslib.interfaces.IEmpty

private val DEFAULT_CARD_TYPE = ICard.EType.UNKNOWN
private const val DEFAULT_PIN_BLOCK = ""

data class OutputData (
    var cardType: ICard.EType = DEFAULT_CARD_TYPE,
    var cardData: CardData = CardData(),
    var iccData: IccData = IccData(),
    var pemData: PemData = PemData(),
    var pinBlock: String = DEFAULT_PIN_BLOCK): IEmpty{

    override fun isEmpty() = (cardType == DEFAULT_CARD_TYPE && cardData.isEmpty()
            && pinBlock == DEFAULT_PIN_BLOCK)

}