package com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle

import com.hexaclean.arc.demo.app.garage.order.domain.model.Vehicle
import com.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.FindVehicleByLicensePlate

class VehicleModuleClient(val findByLicensePlate: FindVehicleByLicensePlate, val mapper: VehicleToOriginVehicleMapper) :
    FetchVehicle {

    override fun fetch(licensePlate: String): Vehicle {
        return mapper.mapOriginVehicleToVehicle(
            findByLicensePlate.findByLicensePlate(LicensePlate(licensePlate))
        )
    }
}