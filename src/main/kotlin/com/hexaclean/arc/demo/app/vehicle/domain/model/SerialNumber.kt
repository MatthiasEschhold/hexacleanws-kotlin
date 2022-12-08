package com.hexaclean.arc.demo.app.vehicle.domain.model

data class SerialNumber(val value: String) {
    init {
        check(!Regex("[0-9]{10}").matches(value)) {
            throw IllegalArgumentException("Serial Number is not valid")
        }
    }
}