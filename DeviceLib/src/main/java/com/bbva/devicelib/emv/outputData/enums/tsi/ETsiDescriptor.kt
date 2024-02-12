package com.bbva.devicelib.emv.outputData.enums.tsi

enum class ETsiDescriptor(val value: String) {
    B1_b8("Offline Data Authenticacion"),
    B1_b7("Cardholder Verificacion"),
    B1_b6("Card Risk Management "),
    B1_b5("Issuer Authentication"),
    B1_b4("Terminal Risk"),
    B1_b3("Script Proccesing"),
    B1_b2("Error TSI Byte1 Bit2 (RFU)"),
    B1_b1("Error TSI Byte1 bit1 (RFU)"),

    B2_b8("Error TSI Byte2 bit8 (RFU)"),
    B2_b7("Error TSI Byte2 bit7 (RFU)"),
    B2_b6("Error TSI Byte2 bit6 (RFU)"),
    B2_b5("Error TSI Byte2 bit5 (RFU)"),
    B2_b4("Error TSI Byte2 bit4 (RFU)"),
    B2_b3("Error TSI Byte2 bit3 (RFU)"),
    B2_b2("Error TSI Byte2 bit2 (RFU)"),
    B2_b1("Error TSI Byte2 bit1 (RFU)")
}