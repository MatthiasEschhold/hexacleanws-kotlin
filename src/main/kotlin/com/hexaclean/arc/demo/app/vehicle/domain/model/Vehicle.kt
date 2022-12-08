package com.hexaclean.arc.demo.app.vehicle.domain.model

class Vehicle(val vin: Vin) {

    init {
        if(vin == null) {
            throw IllegalStateException("Vin is null!")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vehicle

        if (vin != other.vin) return false

        return true
    }

    override fun hashCode(): Int {
        return vin.hashCode()
    }

}