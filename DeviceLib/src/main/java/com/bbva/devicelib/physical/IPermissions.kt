package com.bbva.devicelib.physical

interface IPermissions {
    fun getAllPermissions(): Map<String, Boolean>
}