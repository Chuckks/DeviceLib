package com.bbva.devicelib.emv.outputData

import android.util.Log
import com.bbva.devicelib.Constant
import com.bbva.utilitieslib.extensions.format
import com.bbva.utilitieslib.interfaces.IEmpty
import java.text.SimpleDateFormat
import java.util.*

private const val DEFAULT_NAME = ""
private const val DEFAULT_EXPIRE = ""

private const val EXPIRATION_DATE_LEN = 4
private const val SERVICE_CODE_LEN = 3

private val TAG = Constant.EMV_PREFIX + CardData::class.simpleName

class CardData(
    var pan: PanData = PanData(),
    var cardHolderName: String = DEFAULT_NAME,
    var expire: String = DEFAULT_EXPIRE,
    var serviceCode: ServiceCode = ServiceCode(),
    var cardData: TrackData = TrackData()) : IEmpty {

    override fun isEmpty() = pan.isEmpty() && cardHolderName == DEFAULT_NAME
            && expire == DEFAULT_EXPIRE && serviceCode.isEmpty() && cardData.isEmpty()

    fun checkMagneticPermit() = (!serviceCode.isChipCard())
    fun checkExpirationDate() =(expire >= Date().format("yyMM"))
    fun checkDecideCard() = serviceCode.isPinRequired()

    companion object{

        private const val TRACK_ONE_START_SENTINEL = '%'
        private const val TRACKS_END_SENTINEL = "?"
        private const val TRACK_TWO_START_SENTINEL = ';'
        private const val TRACK_TWO_SEPARTOR = "="
        private const val FORMAT_CODE = 'B'
        private const val FIELD_SEPARATOR = "^"

        private fun Date.format(pattern: String) = SimpleDateFormat(pattern).format(this)

        fun parser(trackData: String): CardData{
            val trackParse = trackData.split(TRACKS_END_SENTINEL)

            var track1 = ""
            var track2 = ""

            trackParse.forEach{
                if(it.startsWith(TRACK_ONE_START_SENTINEL)){
                    track1 = it
                    Log.i(TAG, "Track 1 [$it]")
                }else{
                    if (it.startsWith(TRACK_TWO_START_SENTINEL)){
                        track2 = it
                        Log.i(TAG, "Track 2 [$it]")
                    }
                }
            }

            return if(track1.isNotEmpty())
                track1Parser(track1).apply {
                    cardData.track1 = track1
                    cardData.track2 = track2
                }
            else if (track2.isNotEmpty())
                    track2Parser(track2).apply {
                        cardData.track1 = track1
                        cardData.track2 = track2
                    }
            else
                CardData()
        }

        private fun track1Parser(track1: String): CardData {
            var startIndex = 0
            if (track1.isEmpty())
                throw Exception("Track 1 Parser data is Empty")

            val startSentinel = track1[startIndex++]
            if (startSentinel != TRACK_ONE_START_SENTINEL)
                throw Exception("Wrong Start Sentinel [$startSentinel]")

            //@FormatCode
            val formatCode = track1[startIndex++]
            if (formatCode != FORMAT_CODE)
                throw Exception("Wrong format Code [$formatCode]")

            //@Pan
            val (panIndex, pan) = track1.parser(startIndex, FIELD_SEPARATOR)
            if (panIndex < 0)
                throw Exception("Wrong format Pan Index [$panIndex] < 0")

            startIndex += panIndex

            //@CardHolder
            val (nameIndex, name) =track1.parser(--startIndex, FIELD_SEPARATOR)
            if (nameIndex < 0)
                throw Exception("Wrong format Name Index [$nameIndex] < 0")

            startIndex = nameIndex

            //@Expiration Date
            val expireDate = track1.substring(++startIndex, startIndex + EXPIRATION_DATE_LEN)
            startIndex += EXPIRATION_DATE_LEN

            val serviceCode = ServiceCode.parser(track1.substring(startIndex, startIndex + SERVICE_CODE_LEN))
            startIndex += SERVICE_CODE_LEN

            return CardData(PanData(pan), name, expireDate, serviceCode)
        }

        private fun track2Parser(track2: String): CardData {
            var startIndex = 0

            if (track2.isEmpty())
                throw Exception("trackIIParser data is Empty")

            val startSentinel = track2[startIndex++]
            if (startSentinel != TRACK_TWO_START_SENTINEL)
                throw Exception("Wrong Start Sentinel [$startSentinel]")

            //@Pan
            val (panIndex, pan) = track2.parser(startIndex, TRACK_TWO_SEPARTOR)
            if (panIndex < 0)
                throw Exception("Wrong format Pan Index [$panIndex] < 0")

            startIndex = panIndex

            //@Expiration Date
            val expireDate = track2.substring(startIndex, startIndex + EXPIRATION_DATE_LEN)
            startIndex += EXPIRATION_DATE_LEN

            //@Service Code
            val serviceCode = ServiceCode.parser(track2.substring(startIndex, startIndex + SERVICE_CODE_LEN))
            startIndex += SERVICE_CODE_LEN

            return CardData(pan = PanData(pan), expire = expireDate, serviceCode = serviceCode)
        }

        private fun String.parser(startIndex: Int, value: String): Pair<Int, String> {
            val tokenIndex = this.indexOf(value, startIndex)

            if (tokenIndex <= 0) {
                Log.e(TAG, "Bad Format -> [$this] value to Find [$value]")
                return Pair(-1, "")
            }

            return Pair(tokenIndex, this.substring(startIndex until tokenIndex))
        }
    }
}