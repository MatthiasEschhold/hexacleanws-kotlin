package com.hexaclean.arc.demo.app.vehicle.usecase.out

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin

interface VehicleDbQuery {
    fun findVehicleByVin(vin: Vin): Vehicle
}