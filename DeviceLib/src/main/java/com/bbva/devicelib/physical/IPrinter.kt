package com.bbva.devicelib.physical

import android.graphics.Bitmap


interface IPrinter: IAvailable {

    var bold: Boolean
    var underline: Boolean

    enum class EAlign {
        LEFT,
        CENTER,
        RIGHT
    }

    var align: EAlign

    enum class EFont {
        SMALL,
        NORMAL,
        MEDIUM,
        BIG
    }

    var font: EFont

    fun command(data: ByteArray)

    fun init()
    fun reset()

    fun lineFeed(num: Int)

    fun text(text: String)
    fun textLine(text: String)

    fun format(font: EFont, bold: Boolean, align: EAlign)

    enum class EBarCode{
        UPC_A,
        UPC_E,
        EAN13,
        EAN8,
        CODE39,
        ITF,
        CODEBAR,
        CODE93,
        CODE12
    }

    fun barCode(data: String, typeBarcode: EBarCode, height: Int, width: Int, showText: Boolean)
    fun qrCode(data: String, size: Int)

    fun image(value: ByteArray)
    fun image(bitmap: Bitmap)
}