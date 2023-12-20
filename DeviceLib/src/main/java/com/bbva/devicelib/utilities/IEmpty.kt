package com.bbva.devicelib.utilities

interface IEmpty {
    fun isEmpty(): Boolean
    fun isNotEmpty() = !isEmpty()

}