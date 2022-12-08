package com.hexaclean.arc.demo.app.vehicle.domain.model

class Equipment(val code: EquipmentCode, val description: String) {
    init {
        checkNotNull(code) {
            throw IllegalStateException("Equipment code should not be null")
        }
        checkNotNull(description) {
            throw IllegalStateException("Equipment description should not be null!")
        }
        if (description.isBlank()) {
            throw IllegalStateException("Equipment description should not be blank!")
        }
    }
}