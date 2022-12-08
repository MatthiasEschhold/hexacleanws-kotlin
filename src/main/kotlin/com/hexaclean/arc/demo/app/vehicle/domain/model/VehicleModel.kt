package com.hexaclean.arc.demo.app.vehicle.domain.model

data class VehicleModel(val modelDescription: String, val modelType: String) {
    init {
        check(modelDescription.isBlank()) {
            throw IllegalStateException("Model description is not valid")
        }
        check(modelType.isBlank()) {
            throw IllegalStateException("Model type is not valid")
        }
    }
}