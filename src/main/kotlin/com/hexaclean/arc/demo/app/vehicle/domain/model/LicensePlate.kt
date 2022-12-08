package com.hexaclean.arc.demo.app.vehicle.domain.model

data class LicensePlate(val value: String) {
    init {
        check(!Regex("[A-ZÖÜÄ]{1,3}-[A-ZÖÜÄ]{1,2} [1-9]{1}[0-9]{1,3}").matches(value)) {
            throw IllegalStateException("License plate is not valid");
        }
    }
}