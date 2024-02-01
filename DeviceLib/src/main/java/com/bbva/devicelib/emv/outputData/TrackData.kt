package com.bbva.devicelib.emv.outputData

import com.bbva.utilitieslib.interfaces.IEmpty

private const val DEFAULT_TRACKS = ""
private const val DEFAULT_PAN = ""
private const val DEFAULT_ENCRYPTED = false

data class TrackData(
    var pan: String = DEFAULT_PAN,
    var track1: String = DEFAULT_TRACKS,
    var track2: String = DEFAULT_TRACKS,
    var encrypted: Boolean = DEFAULT_ENCRYPTED //@encrypt track 1, 2 & pan
): IEmpty {

    override fun isEmpty() = pan == DEFAULT_PAN && track1 == DEFAULT_TRACKS && track2 == DEFAULT_TRACKS && encrypted == DEFAULT_ENCRYPTED
}