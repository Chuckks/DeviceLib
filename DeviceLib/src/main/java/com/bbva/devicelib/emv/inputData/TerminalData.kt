package com.bbva.devicelib.emv.inputData

data class TerminalData(
    var terminalId: String = "",
    var merchantId: String = "",
    var currencyCode: String = "",
    //var transType: ETrans = ETrans.GOODS_SERVICE //TODO Crear Enum ETrans para el tipo de transacción
)