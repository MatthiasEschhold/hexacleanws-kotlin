package com.hexaclean.arc.demo.app.vehicle.domain.model


data class Mileage(val value: Double) {

    init {
        if (value < 0) {
            throw IllegalStateException("Mileage should not be negative")
        }
    }
}