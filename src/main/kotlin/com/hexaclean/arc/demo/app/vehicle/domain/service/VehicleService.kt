package com.hexaclean.arc.demo.app.vehicle.domain.service

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import org.springframework.stereotype.Service

@Service
class VehicleService() {

    fun findByVin(vin: Vin): Vehicle {
        return Vehicle(Vin("WP0ZZZ99ZTS392155"));
    }

}