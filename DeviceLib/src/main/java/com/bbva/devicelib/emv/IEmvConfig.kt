package com.bbva.devicelib.emv

import com.bbva.devicelib.emv.configData.AidData
import com.bbva.devicelib.emv.configData.CapkData
import com.bbva.devicelib.emv.configData.TerminalParam
import com.bbva.devicelib.emv.configData.TlvList
import com.bbva.devicelib.physical.IAvailable
import com.bbva.utilitieslib.interfaces.IEmpty

interface IEmvConfig: IEmpty, IAvailable {

    fun isCapksLoaded(): Boolean
    fun isAidsLoaded(): Boolean

    fun setConfig(terminalParams: TerminalParam, aids: List<AidData>, capks: List<CapkData>): Boolean
    fun clean(): Boolean

    //@SPECIFIC
    enum class EType {

        ICC,
        PAYPASS,
        PAYWAVE,
        EXPRESSPAY
    }

    fun setSpecificConfig(type: EType, tlvList: TlvList)
    fun setSpecificConfig(config: HashMap<EType, TlvList>)

    //TODO Revisar configuraciones de los DRL
    //fun setDrlsLimit(drls: List<DrlData>)
}