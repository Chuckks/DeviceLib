package com.bbva.devicelib.emv.data.output

import com.bbva.devicelib.emv.outputData.Tvr
import com.bbva.devicelib.emv.outputData.TvrDataBit
import com.bbva.devicelib.emv.outputData.enums.tvr.ETvrDescriptor.*
import org.junit.Assert
import org.junit.Test

class TvrTest {

    @Test
    fun tvrTest01() {

        val tvr = "5281258013"

        val byte0 = listOf(
                TvrDataBit(B1_b7, true),
                TvrDataBit(B1_b5, true),
                TvrDataBit(B1_b2, true),
                          )
        val byte1 = listOf(
                TvrDataBit(B2_b8, true),
                TvrDataBit(B2_b1, true)
                          )
        val byte2 = listOf(
                TvrDataBit(B3_b6, true),
                TvrDataBit(B3_b3, true),
                TvrDataBit(B3_b1, true)
                          )
        val byte3 = listOf(
                TvrDataBit(B4_b8, true)
                          )

        val byte4 = listOf(
                TvrDataBit(B5_b5, true),
                TvrDataBit(B5_b2, true),
                TvrDataBit(B5_b1, true)

                          )

        val tvrResult = Tvr.parser(tvr)

        val listAllEnables = byte0 + byte1 + byte2 + byte3 + byte4
        Assert.assertEquals(listAllEnables, tvrResult.tvrData.getAllEnables())

        Assert.assertEquals(byte0, tvrResult.tvrData.getEnables(0))
        Assert.assertEquals(byte1, tvrResult.tvrData.getEnables(1))
        Assert.assertEquals(byte2, tvrResult.tvrData.getEnables(2))
        Assert.assertEquals(byte3, tvrResult.tvrData.getEnables(3))
        Assert.assertEquals(byte4, tvrResult.tvrData.getEnables(4))

    }


    @Test
    fun tvrTest02() {
        val tvr = "4236253103"

        val byte0 = listOf(
                TvrDataBit(B1_b7, true),
                TvrDataBit(B1_b2, true)
                          )
        val byte1 = listOf(
                TvrDataBit(B2_b6, true),
                TvrDataBit(B2_b5, true),
                TvrDataBit(B2_b3, true),
                TvrDataBit(B2_b2, true)
                          )
        val byte2 = listOf(
                TvrDataBit(B3_b6, true),
                TvrDataBit(B3_b3, true),
                TvrDataBit(B3_b1, true)
                          )
        val byte3 = listOf(
                TvrDataBit(B4_b6, true),
                TvrDataBit(B4_b5, true),
                TvrDataBit(B4_b1, true)
                          )

        val byte4 = listOf(
                TvrDataBit(B5_b2, true),
                TvrDataBit(B5_b1, true)
                          )

        val tvrResult = Tvr.parser(tvr)

        val listAllEnables = byte0 + byte1 + byte2 + byte3 + byte4
        Assert.assertEquals(listAllEnables, tvrResult.tvrData.getAllEnables())

        Assert.assertEquals(byte0, tvrResult.tvrData.getEnables(0))
        Assert.assertEquals(byte1, tvrResult.tvrData.getEnables(1))
        Assert.assertEquals(byte2, tvrResult.tvrData.getEnables(2))
        Assert.assertEquals(byte3, tvrResult.tvrData.getEnables(3))
        Assert.assertEquals(byte4, tvrResult.tvrData.getEnables(4))
    }

    @Test
    fun tvrTest03() {
        val tvr = "FFFFFFFFFF"

        val byte0 = listOf(
                TvrDataBit(B1_b8, true),
                TvrDataBit(B1_b7, true),
                TvrDataBit(B1_b6, true),
                TvrDataBit(B1_b5, true),
                TvrDataBit(B1_b4, true),
                TvrDataBit(B1_b3, true),
                TvrDataBit(B1_b2, true),
                TvrDataBit(B1_b1, true)
                          )
        val byte1 = listOf(
                TvrDataBit(B2_b8, true),
                TvrDataBit(B2_b7, true),
                TvrDataBit(B2_b6, true),
                TvrDataBit(B2_b5, true),
                TvrDataBit(B2_b4, true),
                TvrDataBit(B2_b3, true),
                TvrDataBit(B2_b2, true),
                TvrDataBit(B2_b1, true)
                          )
        val byte2 = listOf(
                TvrDataBit(B3_b8, true),
                TvrDataBit(B3_b7, true),
                TvrDataBit(B3_b6, true),
                TvrDataBit(B3_b5, true),
                TvrDataBit(B3_b4, true),
                TvrDataBit(B3_b3, true),
                TvrDataBit(B3_b2, true),
                TvrDataBit(B3_b1, true)
                          )
        val byte3 = listOf(
                TvrDataBit(B4_b8, true),
                TvrDataBit(B4_b7, true),
                TvrDataBit(B4_b6, true),
                TvrDataBit(B4_b5, true),
                TvrDataBit(B4_b4, true),
                TvrDataBit(B4_b3, true),
                TvrDataBit(B4_b2, true),
                TvrDataBit(B4_b1, true)
                          )

        val byte4 = listOf(
                TvrDataBit(B5_b8, true),
                TvrDataBit(B5_b7, true),
                TvrDataBit(B5_b6, true),
                TvrDataBit(B5_b5, true),
                TvrDataBit(B5_b4, true),
                TvrDataBit(B5_b3, true),
                TvrDataBit(B5_b2, true),
                TvrDataBit(B5_b1, true)
                          )

        val tvrResult = Tvr.parser(tvr)

        val listAllEnables = byte0 + byte1 + byte2 + byte3 + byte4
        Assert.assertEquals(listAllEnables, tvrResult.tvrData.getAllEnables())

        Assert.assertEquals(byte0, tvrResult.tvrData.getEnables(0))
        Assert.assertEquals(byte1, tvrResult.tvrData.getEnables(1))
        Assert.assertEquals(byte2, tvrResult.tvrData.getEnables(2))
        Assert.assertEquals(byte3, tvrResult.tvrData.getEnables(3))
        Assert.assertEquals(byte4, tvrResult.tvrData.getEnables(4))
    }

    @Test
    fun tvrTest04() {
        val tvr = "0000000000"

        val tvrResult = Tvr.parser(tvr)

        Assert.assertEquals(true, tvrResult.tvrData.getAllEnables().isEmpty())
        Assert.assertEquals(true, tvrResult.tvrData.getEnables(0).isEmpty())
        Assert.assertEquals(true, tvrResult.tvrData.getEnables(1).isEmpty())
        Assert.assertEquals(true, tvrResult.tvrData.getEnables(2).isEmpty())
        Assert.assertEquals(true, tvrResult.tvrData.getEnables(3).isEmpty())
        Assert.assertEquals(true, tvrResult.tvrData.getEnables(4).isEmpty())
    }
}


