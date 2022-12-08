package com.hexaclean.arc.demo.app.vehicle.domain.model

class EquipmentCode(val value: String) {
    init {
        check(Regex("[A-Z]{2}[0-9]{3}").matches(value)) {
            throw IllegalStateException("Equipment code is not valid")
        }
    }
}