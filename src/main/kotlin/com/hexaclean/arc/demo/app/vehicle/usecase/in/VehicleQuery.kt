package com.hexaclean.arc.demo.app.vehicle.usecase.`in`

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin

interface VehicleQuery {

    fun findByVin(vin: Vin): Vehicle

    //List<Vehicle> findAllByCustomerId(CustomerId customerId)
    //List<Vehicle> findAll(Vin... vins);
}