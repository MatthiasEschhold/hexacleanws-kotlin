package com.hexaclean.arc.demo.app.vehicle.adapter.out.db

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity
import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery
import org.springframework.stereotype.Component

@Component
class VehicleQueryRepository(private val mapper: VehicleToVehicleDbEntityMapper) : VehicleDbQuery {

    override fun findVehicleByVin(vin: Vin): Vehicle {
        val vehicleDbEntity: VehicleDbEntity = findVehicleDbEntity(vin)
        return mapper.mapVehicleDbEntityToVehicle(vehicleDbEntity)
    }

    override fun findVehicleByLicensePlate(licensePlate: LicensePlate): Vehicle {
        return mapper.mapVehicleDbEntityToVehicle(createDbEntity())
    }


    private fun createDbEntity(): VehicleDbEntity {
        val dbEntity = VehicleDbEntity()
        dbEntity.vin  = VIN
        dbEntity.licensePlate = LICENSE_PLATE_TEST_VALUE
        dbEntity.milage = MILEAGE_TEST_VALUE
        return dbEntity
    }

    private fun findVehicleDbEntity(vin: Vin): VehicleDbEntity {
        return createDbEntity()
    }

    companion object {
        private const val VIN = "WP0ZZZ99ZTS392155"
        private const val LICENSE_PLATE_TEST_VALUE = "ES-EM 385"
        private const val MILEAGE_TEST_VALUE = 100000.0
    }
}