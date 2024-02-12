package com.bbva.devicelib.emv.data.output

import com.bbva.devicelib.emv.outputData.CvmResult
import com.bbva.devicelib.emv.outputData.enums.cvmResult.EPerformed
import com.bbva.devicelib.emv.outputData.enums.cvmResult.EResult
import org.junit.Assert
import org.junit.Test

class CvmResultTest {

    private val plainTextSuccess = CvmResult(
            EPerformed.PLAINTEXT_PIN,
            EResult.SUCCESSFUL
                                            )

    private val signatureSuccess = CvmResult(
            EPerformed.SIGNATURE,
            EResult.SUCCESSFUL
                                            )

    @Test
    fun parserOkTest01() {
        val cvm = "010002"

        Assert.assertEquals(plainTextSuccess, CvmResult.parser(cvm))
    }

    @Test
    fun parserOkTest02() {
        val cvm = "410002"
        Assert.assertEquals(plainTextSuccess, CvmResult.parser(cvm))
    }

    @Test
    fun parserOkTest03() {
        val cvm = "1E0002"
        Assert.assertEquals(signatureSuccess, CvmResult.parser(cvm))
    }

    @Test
    fun parserOkTest04() {
        val cvm = "5E0002"
        Assert.assertEquals(signatureSuccess, CvmResult.parser(cvm))
    }

    @Test
    fun parserKoTest01() {
        val cvm = "010001"

        Assert.assertNotEquals(plainTextSuccess, CvmResult.parser(cvm))
    }

    @Test
    fun parserFailTest02() {
        val cvm = "410001"

        Assert.assertNotEquals(plainTextSuccess, CvmResult.parser(cvm))
    }

    @Test
    fun parserFailTest03() {
        val cvm = "1E0001"
        Assert.assertEquals(signatureSuccess, CvmResult.parser(cvm))
    }

    @Test
    fun parserFailTest04() {
        val cvm = "5E0001"
        Assert.assertEquals(signatureSuccess, CvmResult.parser(cvm))
    }

    @Test
    fun parserExceptionTest01() {
        val cvm = "060002"

        Assert.assertThrows(Exception::class.java) {
            CvmResult.parser(cvm)
        }
    }

    @Test
    fun parserExceptionTest02() {
        val cvm = "Hola Mundo"

        Assert.assertThrows(Exception::class.java) {
            CvmResult.parser(cvm)
        }
    }

    @Test
    fun parserExceptionTest03() {
        val cvm = "FF0002"

        Assert.assertThrows(Exception::class.java) {
            CvmResult.parser(cvm)
        }
    }
}
