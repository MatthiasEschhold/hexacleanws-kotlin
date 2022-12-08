package com.hexaclean.arc.demo.app.vehicle.adapter.out.db

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity
import com.hexaclean.arc.demo.app.vehicle.domain.model.*
import org.springframework.stereotype.Component

@Component
class VehicleToVehicleDbEntityMapper {

    fun mapVehicleDbEntityToVehicle(dbEntity: VehicleDbEntity): Vehicle {
        return Vehicle(
            Vin(dbEntity.vin!!),
            VehicleMotionData(
                LicensePlate(dbEntity.licensePlate!!),
                Mileage(dbEntity.milage!!)
            )
        )
    }

    fun mapVehicleToVehicleDbEntity(vehicle: Vehicle): VehicleDbEntity {
        val vehicleDbEntity = VehicleDbEntity()
        vehicleDbEntity.vin = vehicle.vin.value
        vehicleDbEntity.milage = vehicle.vehicleMotionData.mileage.value
        vehicleDbEntity.licensePlate = vehicle.vehicleMotionData.licensePlate.value
        return vehicleDbEntity
    }
}