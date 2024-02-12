package com.bbva.devicelib.emv.inputData

import com.bbva.devicelib.emv.inputData.enums.EFlowType
import com.bbva.devicelib.emv.inputData.enums.EPinOption
import com.bbva.devicelib.physical.data.CardConfig
import com.bbva.utilitieslib.utils.TimeSpan

data class InputData (
    var amountData: AmountData = AmountData(),
    var terminalData: TerminalData = TerminalData(),
    var cardConfig: CardConfig = CardConfig(),

    var pinpadConfig: PinpadConfig = PinpadConfig(),
    var cvmOptions: CvmOptions = CvmOptions(),
    var pinOptions: EPinOption = EPinOption.DECIDE_CARD,

    var flowType: EFlowType = EFlowType.FULL_GRADE,
    var bankTagList: List<String> = emptyList(),
    var onlineTime: TimeSpan = TimeSpan(50000)
)