package com.hexaclean.arc.demo.app.vehicle.adapter.out

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery
import org.springframework.stereotype.Component

@Component
class VehicleRepository() : VehicleDbQuery {

    override fun findVehicleByVin(vin: Vin): Vehicle {
        return Vehicle(Vin(VIN));
    }

    companion object {
        private const val VIN = "WP0ZZZ99ZTS392155"
        private const val LICENSE_PLATE_TEST_VALUE = "ES-EM 385"
        private const val MILEAGE_TEST_VALUE = 100000.0
    }
}