package com.hexaclean.arc.demo.app.vehicle.domain.model

data class MileageUnit(val value: MileageUnitValue) {

    init {
        check(value == null) {
            throw IllegalStateException("Mileage unit is null")
        }
    }
}