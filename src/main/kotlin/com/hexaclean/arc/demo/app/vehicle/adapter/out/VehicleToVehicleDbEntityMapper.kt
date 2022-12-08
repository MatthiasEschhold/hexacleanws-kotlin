package com.hexaclean.arc.demo.app.vehicle.adapter.out

import com.hexaclean.arc.demo.app.vehicle.domain.model.*
import org.springframework.stereotype.Component

@Component
class VehicleToVehicleDbEntityMapper {

    fun mapVehicleDbEntityToVehicle(dbEntity: VehicleDbEntity): Vehicle {
        return Vehicle(
            Vin(dbEntity.vin!!)
        )
    }

    fun mapVehicleToVehicleDbEntity(vehicle: Vehicle): VehicleDbEntity {
        val vehicleDbEntity = VehicleDbEntity()
        vehicleDbEntity.vin = vehicle.vin.value
        return vehicleDbEntity
    }
}