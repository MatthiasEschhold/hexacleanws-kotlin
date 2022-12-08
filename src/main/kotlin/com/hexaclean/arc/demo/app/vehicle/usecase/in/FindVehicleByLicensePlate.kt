package com.hexaclean.arc.demo.app.vehicle.usecase.`in`

import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle

interface FindVehicleByLicensePlate {
    fun findByLicensePlate(licensePlate: LicensePlate): Vehicle
}