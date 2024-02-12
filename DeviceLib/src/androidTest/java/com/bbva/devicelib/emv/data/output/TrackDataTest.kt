package com.bbva.devicelib.emv.data.output

import com.bbva.devicelib.emv.outputData.CardData
import com.bbva.devicelib.emv.outputData.PanData
import com.bbva.devicelib.emv.outputData.ServiceCode
import com.bbva.devicelib.emv.outputData.enums.serviceCode.EInterchange
import com.bbva.devicelib.emv.outputData.enums.serviceCode.EService
import org.junit.Assert
import org.junit.Test


class TrackDataTest {

    private val trackDataSuccessCheck = CardData(
            pan = PanData("5579100113521692"),
            cardHolderName = "NEFER/ROMERO GONZALEZ     ",
            expire = "1909",
            serviceCode = ServiceCode(EInterchange.INTERNATIONAL_WITH_ICC, EService.NO_RESTRICTIONS)
                                                )

    private val withOutTrackICheck = CardData(
            pan = PanData("5579100113521692"),
            cardHolderName = "",
            expire = "1909",
            serviceCode = ServiceCode(EInterchange.INTERNATIONAL_WITH_ICC, EService.NO_RESTRICTIONS)
                                             )

    private val trackDataFailCheck = CardData()

    @Test
    fun parserOkTest01() {

        val data = "%B5579100113521692^NEFER/ROMERO GONZALEZ     ^190920100174000000   ?;5579100113521692=1909201174?"

        Assert.assertEquals(trackDataSuccessCheck, CardData.parser(data))

    }

    @Test
    fun parserNoTrackITest03() {
        val data = ";5579100113521692=1909201174?"

        Assert.assertEquals(withOutTrackICheck, CardData.parser(data))
    }

    @Test
    fun parserNoTrackIITest04() {
        val data = "%B5579100113521692^NEFER/ROMERO GONZALEZ     ^190920100174000000   ?"

        Assert.assertEquals(trackDataSuccessCheck, CardData.parser(data))
    }


    @Test
    fun parserEmptyDataTest06() {
        val data = ""

        Assert.assertEquals(trackDataFailCheck, CardData.parser(data))
    }

    @Test
    fun parserWithOutNameTest01() {

        val data = "%B5579100113521692^^190920100174000000   ?;5579100113521692=1909201174?"

        Assert.assertEquals(withOutTrackICheck, CardData.parser(data))

    }

    @Test
    fun parserFailBadFormatTest05() {
        val data = "5579100113521692^NEFER/ROMERO GONZALEZ     190920100174000000   5579100113521692=1909201174?"

        Assert.assertEquals(trackDataFailCheck, CardData.parser(data))
    }

    @Test
    fun parserFailNoSentinelTest02() {

        var data = "B5579100113521692^NEFER/ROMERO GONZALEZ     ^190920100174000000   ? 5579100113521692=1909201174?"
        Assert.assertEquals(trackDataFailCheck, CardData.parser(data))

        data = "%B5579100113521692NEFER/ROMERO GONZALEZ     190920100174000000   ?;5579100113521692=1909201174?"
        Assert.assertThrows(Exception::class.java) {
            CardData.parser(data)
        }

        data = "%B5579100113521692^NEFER/ROMERO GONZALEZ     ^190920100174000000   ?;5579100113521692 1909201174?"
        Assert.assertEquals(trackDataSuccessCheck, CardData.parser(data))

        data = "%B5579100113521692^NEFER/ROMERO GONZALEZ     ^190920100174000000   5579100113521692 1909201174"
        Assert.assertEquals(trackDataSuccessCheck, CardData.parser(data))

        data = ";5579100113521692 1909201174?"
        Assert.assertThrows(Exception::class.java) {
            CardData.parser(data)
        }

    }

}
