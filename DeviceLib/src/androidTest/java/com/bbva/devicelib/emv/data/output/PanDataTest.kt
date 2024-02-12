package com.bbva.devicelib.emv.data.output

import com.bbva.devicelib.emv.outputData.PanData
import org.junit.Assert
import org.junit.Test

class PanDataTest {

    private val panMaskedLast4 = "XXXXXXXXXXX2345"
    private val panMaskedFist6Last4 = "123456XXXXX2345"
    private val panMaskedEmpty = ""

    private val panOk = "123456789012345F"
    private val panCharacter = "Hola Mundo 123456"

    @Test
    fun getMaskedPanOkTest01() {
        val panMasked = PanData(panOk).getMaskedPan()
        Assert.assertEquals(panMaskedFist6Last4, panMasked)
    }

    @Test
    fun getMaskedPanOkTest02() {
        val panMasked = PanData(panOk).getMaskedPan(PanData.EMask.LAST4)
        Assert.assertEquals(panMasked, panMaskedLast4)
    }

    @Test
    fun getMaskedPanOkTest03() {
        val panMasked = PanData().getMaskedPan(PanData.EMask.LAST4)
        Assert.assertEquals(panMasked, panMaskedEmpty)
    }

    @Test
    fun getMaskedPanFailTest01() {
        val panMasked = PanData(panOk).getMaskedPan(ch = '-')
        Assert.assertNotEquals(panMasked, panMaskedFist6Last4)
    }

    @Test
    fun getMaskedPanFailTest02() {
        Assert.assertThrows(PanDataException::class.java) {
            PanData(panCharacter).getMaskedPan()
        }
    }
}
