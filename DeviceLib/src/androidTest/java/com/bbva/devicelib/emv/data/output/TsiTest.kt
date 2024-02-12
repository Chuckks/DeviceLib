package com.bbva.devicelib.emv.data.output

import com.bbva.devicelib.emv.outputData.Tsi
import com.bbva.devicelib.emv.outputData.TsiDataBit
import com.bbva.devicelib.emv.outputData.enums.tsi.ETsiDescriptor.*
import org.junit.Assert
import org.junit.Test

class TsiTest {

    @Test
    fun tsiTest01() {

        val tsi = "5281"

        val byte0 = listOf(
                TsiDataBit(B1_b7, true),
                TsiDataBit(B1_b5, true),
                TsiDataBit(B1_b2, true),
                          )
        val byte1 = listOf(
                TsiDataBit(B2_b8, true),
                TsiDataBit(B2_b1, true)
                          )

        val listAllEnables = listOf(
                TsiDataBit(B1_b7, true),
                TsiDataBit(B1_b5, true),
                TsiDataBit(B1_b2, true),
                TsiDataBit(B2_b8, true),
                TsiDataBit(B2_b1, true)
                                   )

        val tsiResult = Tsi.parser(tsi)
        Assert.assertEquals(listAllEnables, tsiResult.tsiData.getAllEnables())

        Assert.assertEquals(byte0, tsiResult.tsiData.getEnables(0))
        Assert.assertEquals(byte1, tsiResult.tsiData.getEnables(1))
    }

    @Test
    fun tsiTest02() {

        val tsi = "FF00"

        val byte0 = listOf(
                TsiDataBit(B1_b8, true),
                TsiDataBit(B1_b7, true),
                TsiDataBit(B1_b6, true),
                TsiDataBit(B1_b5, true),
                TsiDataBit(B1_b4, true),
                TsiDataBit(B1_b3, true),
                TsiDataBit(B1_b2, true),
                TsiDataBit(B1_b1, true),
                          )

        val tsiResult = Tsi.parser(tsi)
        Assert.assertEquals(byte0, tsiResult.tsiData.getEnables(0))
        Assert.assertEquals(true, tsiResult.tsiData.getEnables(1).isEmpty())
    }


    @Test
    fun tsiTest03() {

        val tsi = "00FF"

        val byte1 = listOf(
                TsiDataBit(B2_b8, true),
                TsiDataBit(B2_b7, true),
                TsiDataBit(B2_b6, true),
                TsiDataBit(B2_b5, true),
                TsiDataBit(B2_b4, true),
                TsiDataBit(B2_b3, true),
                TsiDataBit(B2_b2, true),
                TsiDataBit(B2_b1, true),
                          )

        val tsiResult = Tsi.parser(tsi)
        Assert.assertEquals(true, tsiResult.tsiData.getEnables(0).isEmpty())
        Assert.assertEquals(byte1, tsiResult.tsiData.getEnables(1))
    }
}
