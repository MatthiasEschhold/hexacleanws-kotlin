package com.hexaclean.arc.demo.app.vehicle.usecase.out

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle

interface VehicleDbCommand {
    fun saveVehicle(vehicle: Vehicle): Vehicle
}