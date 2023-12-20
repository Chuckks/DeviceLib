package com.bbva.devicelib.physical.data

import com.bbva.devicelib.physical.ICard
import com.bbva.devicelib.utilities.IEmpty
import com.bbva.utilitieslib.utils.TimeSpan

private val DEFAULT_FALLBACK: Boolean = false
private val DEFAULT_TIMEOUT: TimeSpan = TimeSpan(60000)
private val DEFAULT_SET = emptySet<ICard.EType>()

data class CardConfig(
    var cardSupported: Set<ICard.EType> = DEFAULT_SET,
    var detectedCardTimeout: TimeSpan = DEFAULT_TIMEOUT,
    var fallBack: Boolean = DEFAULT_FALLBACK
): IEmpty {
    override fun isEmpty() = ( cardSupported == DEFAULT_SET && detectedCardTimeout == DEFAULT_TIMEOUT && fallBack == DEFAULT_FALLBACK)

}
