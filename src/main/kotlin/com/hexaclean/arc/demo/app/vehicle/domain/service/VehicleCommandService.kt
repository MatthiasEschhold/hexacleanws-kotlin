package com.hexaclean.arc.demo.app.vehicle.domain.service

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMotionData
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.VehicleCommand
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbCommand
import org.springframework.stereotype.Service

@Service
class VehicleCommandService(val dbCommand: VehicleDbCommand) : VehicleCommand {

    override fun create(vehicle: Vehicle): Vehicle {
        return dbCommand.saveVehicle(vehicle)
    }

    override fun update(vin: Vin, vehicleMotionData: VehicleMotionData): Vehicle {
        return dbCommand.saveVehicle(Vehicle(vin, vehicleMotionData))
    }
}