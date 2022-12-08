package com.hexaclean.arc.demo.app.vehicle.domain.service

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.VehicleQuery
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery
import org.springframework.stereotype.Service

@Service
class VehicleService(
    val vehicleDbQuery: VehicleDbQuery
) : VehicleQuery {

    override fun findByVin(vin: Vin): Vehicle {
        val vehicle: Vehicle = vehicleDbQuery.findVehicleByVin(vin)
        return vehicle
    }

}