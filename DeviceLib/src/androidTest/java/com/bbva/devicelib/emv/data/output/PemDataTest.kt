package com.bbva.devicelib.emv.data.output

import com.bbva.devicelib.emv.outputData.PemData
import com.bbva.devicelib.emv.outputData.enums.Pem.EPanMode
import com.bbva.devicelib.emv.outputData.enums.Pem.EPinMode
import org.junit.Assert
import org.junit.Test

class PemDataTest {


    private val pemDataSuccessCheck: PemData = PemData(EPanMode.CHIP, EPinMode.PIN_ENABLE)
    private val pemDataSuccessCheck2: PemData = PemData(EPanMode.CTLS_MAG, EPinMode.PIN_ENABLE)

    @Test
    fun parserOkTest01() {
        val data = "051"
        Assert.assertEquals(pemDataSuccessCheck.toString(), PemData.parser(data).toString())
    }

    @Test
    fun parserOkTest02() {
        val data = "911"
        Assert.assertEquals(pemDataSuccessCheck2.toString(), PemData.parser(data).toString())
    }

    @Test
    fun parserFailWrongLengthTest03() {
        val data = "91"
        Assert.assertThrows(Exception::class.java) {
            PemData.parser(data)
        }
    }

    @Test
    fun parserFailWrongDataTest03() {
        val data = "999"
        Assert.assertThrows(Exception::class.java) {
            PemData.parser(data)
        }
    }
}
