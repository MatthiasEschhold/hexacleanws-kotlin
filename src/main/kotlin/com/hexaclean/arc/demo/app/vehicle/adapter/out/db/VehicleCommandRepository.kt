package com.hexaclean.arc.demo.app.vehicle.adapter.out.db

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbCommand
import org.springframework.stereotype.Component

@Component
class VehicleCommandRepository(private val mapper: VehicleToVehicleDbEntityMapper) : VehicleDbCommand {

    override fun saveVehicle(vehicle: Vehicle): Vehicle {
        val savedVehicle: VehicleDbEntity = technicalSaveWithSqlStuff(vehicle)
        return mapper.mapVehicleDbEntityToVehicle(savedVehicle)
    }

    private fun technicalSaveWithSqlStuff(vehicle: Vehicle): VehicleDbEntity {
        //INSERT INTO ...
        // UPDATE ...
        // jdbcRepository.save(mapper.mapVehicleToVehicleDbEntity(vehicle));
        val dbEntity = VehicleDbEntity()
        dbEntity.vin = VIN
        dbEntity.licensePlate = LICENSE_PLATE_TEST_VALUE
        dbEntity.milage = MILEAGE_TEST_VALUE
        return dbEntity
    }

    companion object {
        private const val VIN = "WP0ZZZ99ZTS392155"
        private const val LICENSE_PLATE_TEST_VALUE = "ES-EM 385"
        private const val MILEAGE_TEST_VALUE = 100000.0
    }
}