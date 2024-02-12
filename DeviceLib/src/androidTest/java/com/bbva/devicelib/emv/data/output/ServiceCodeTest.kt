package com.bbva.devicelib.emv.data.output

import com.bbva.devicelib.emv.outputData.ServiceCode
import org.junit.Assert
import org.junit.Test

class ServiceCodeTest {

    @Test
    fun ServicecodeTest01() {
        val serviceCode = "121" //International mag Autorization by Issuer online

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(false, serviceResult.isPinRequired())
        Assert.assertEquals(false, serviceResult.isChipCard())
        Assert.assertEquals(true, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest02() {
        val serviceCode = "201" //International Chip Normal Autorization

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(false, serviceResult.isPinRequired())
        Assert.assertEquals(true, serviceResult.isChipCard())
        Assert.assertEquals(true, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest03() {
        val serviceCode = "206" //International Chip Normal Autorization Terminal must prompt for PIN if PIN pad present

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(true, serviceResult.isPinRequired())
        Assert.assertEquals(true, serviceResult.isChipCard())
        Assert.assertEquals(true, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest04() {
        val serviceCode = "220" //International Chip Normal Authorization by issuer online  PIN required

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(true, serviceResult.isPinRequired())
        Assert.assertEquals(true, serviceResult.isChipCard())
        Assert.assertEquals(true, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest05() {
        val serviceCode = "221" //International Chip  Authorization by issuer online

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(false, serviceResult.isPinRequired())
        Assert.assertEquals(true, serviceResult.isChipCard())
        Assert.assertEquals(true, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest06() {
        val serviceCode = "521" //national Chip (domestic only) Authorization by issuer online

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(false, serviceResult.isPinRequired())
        Assert.assertEquals(false, serviceResult.isChipCard())
        Assert.assertEquals(false, serviceResult.isInternationalAvailable())
        Assert.assertEquals(true, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest07() {
        val serviceCode = "702" //private Goods and Services only   Prompt for PIN if PED present

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(false, serviceResult.isPinRequired())
        Assert.assertEquals(false, serviceResult.isChipCard())
        Assert.assertEquals(false, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest08() {
        val serviceCode = "000" //International No restrictions

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(true, serviceResult.isPinRequired())
        Assert.assertEquals(false, serviceResult.isChipCard())
        Assert.assertEquals(false, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest09() {
        val serviceCode = "101" //International No restrictions

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(false, serviceResult.isPinRequired())
        Assert.assertEquals(false, serviceResult.isChipCard())
        Assert.assertEquals(true, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest10() {
        val serviceCode = "222" //International integrate card By issuer online, goods and services only

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(false, serviceResult.isPinRequired())
        Assert.assertEquals(true, serviceResult.isChipCard())
        Assert.assertEquals(true, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }

    @Test
    fun ServicecodeTest11() {
        val serviceCode = "003" //ATM only PIN Required

        val serviceResult = ServiceCode.parser(serviceCode)
        Assert.assertEquals(serviceCode, serviceResult.toString())

        Assert.assertEquals(true, serviceResult.isPinRequired())
        Assert.assertEquals(false, serviceResult.isChipCard())
        Assert.assertEquals(false, serviceResult.isInternationalAvailable())
        Assert.assertEquals(false, serviceResult.isNationalAvailable())
    }


}
