package com.hexaclean.arc.demo.app.vehicle.usecase.`in`

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMotionData
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin

interface VehicleCommand {
    fun create(vehicle: Vehicle): Vehicle
    fun update(vin: Vin, vehicleMotionData: VehicleMotionData): Vehicle
}