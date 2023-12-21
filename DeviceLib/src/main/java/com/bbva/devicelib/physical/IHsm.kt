package com.bbva.devicelib.physical

import com.bbva.devicelib.utilities.IEmpty
import com.bbva.utilitieslib.extensions.toHexaString
import com.bbva.utilitieslib.security.KeyUtils
import com.bbva.utilitieslib.security.RSA
import javax.crypto.SecretKey

interface IHsm: IAvailable {
    enum class EKeyType{
        TMK,
        PIN,
        MAC,
        DATA,
        DUKPT_KEK,
        DUKPT_BDK,
        DUKPT_IPEK
    }

    enum class EAlgo{
        TDES,
        AES,
        RSA
    }

    data class CryptogramData(
        val keyType: EKeyType,
        var cryptogram: String = "",
        var kcv: String = ""
    ): IEmpty{
        override fun isEmpty() = (cryptogram.isEmpty() && kcv.isEmpty())
    }

    fun getKCV(storeIndex: Int): ByteArray

    fun injectClearKey(type: EKeyType, key: SecretKey, storeIndex: Int): Boolean
    fun injectEncryptedKey(type: EKeyType, encryptIndex: Int, key: SecretKey, storeIndex: Int): Boolean

    fun getCryptogramKey(keyType: EKeyType, publicKey: String) =
         CryptogramData(keyType = keyType).apply {
            val algo: KeyUtils.EAlgo = KeyUtils.EAlgo.TDES
            val keyLength = 24

            val secretKey = KeyUtils.keyGenerator(algo, keyLength)
            cryptogram = RSA().encrypt(secretKey.encoded).toHexaString()

            injectClearKey(keyType, secretKey, keyType.ordinal)
            kcv = getKCV(keyType.ordinal).toHexaString()
        }

    enum class EEncryptMode{
        ECB,
        CBC
    }

    fun encrypt(keyIndex: Int, mode: EEncryptMode = EEncryptMode.ECB, data: ByteArray, iv: ByteArray = byteArrayOf())
    fun decrypt(keyIndex: Int, mode: EEncryptMode = EEncryptMode.ECB, data: ByteArray, iv: ByteArray = byteArrayOf())
}