package com.hexaclean.arc.demo.app.vehicle.domain.model

data class Vin(val value: String) {
    init {
        check(Regex("(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}").matches(value)) {
            throw IllegalStateException("Vin is not valid")
        }
    }
}