package com.bbva.devicelib.emv

import com.bbva.devicelib.physical.IAvailable
import com.bbva.devicelib.utilities.IEmpty

interface IEmvConfig: IEmpty, IAvailable {

    fun isCapksLoaded(): Boolean
    fun isAidsLoaded(): Boolean
    //TODO crear clases de TerminalParam, AidData y CapkData
    fun setConfig(terminalParams: String, aids: List<String>, capks: List<String>): Boolean
    fun clean(): Boolean

    //@SPECIFIC
    enum class EType {

        ICC,
        PAYPASS,
        PAYWAVE,
        EXPRESSPAY
    }

    //TODO Crear clase para el parser de una lista de TLVs (TlvList)
    fun setSpecificConfig(type: EType, tlvList: List<Int>)
    fun setSpecificConfig(config: HashMap<EType, Int/*TlvList*/>)

    //TODO Revisar configuraciones de los DRL
    //fun setDrlsLimit(drls: List<DrlData>)
}