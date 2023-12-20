package com.bbva.devicelib.physical

import com.bbva.devicelib.physical.data.CardConfig

interface ICard: IAvailable {
    enum class EType{
        UNKNOWN,
        MAGNETIC,
        ICC,
        CTLS
    }

    enum class EStep{
        INIT,
        READING,
        CANCEL,
        ERROR,
        FINISH
    }

    var step: EStep
    var type: EType
    var data: String

    fun checkCard(cardConfig: CardConfig): Boolean
    fun cancelCheckCard()

    fun cardOff()
    fun isPresent(): Boolean
}