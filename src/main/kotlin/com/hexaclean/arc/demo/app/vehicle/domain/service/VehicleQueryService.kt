package com.hexaclean.arc.demo.app.vehicle.domain.service

import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.FindVehicleByLicensePlate
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.VehicleQuery
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery
import org.springframework.stereotype.Service

@Service
class VehicleQueryService(
    val vehicleDbQuery: VehicleDbQuery,
    val fetchVehicleMasterData: FetchVehicleMasterData
) : VehicleQuery, FindVehicleByLicensePlate {

    override fun findByVin(vin: Vin): Vehicle {
        val vehicle: Vehicle = vehicleDbQuery.findVehicleByVin(vin)
        enrichWithVehicleMasterData(vehicle)
        return vehicle
    }

    override fun findByLicensePlate(licensePlate: LicensePlate): Vehicle {
        val vehicle: Vehicle = vehicleDbQuery.findVehicleByLicensePlate(licensePlate)
        enrichWithVehicleMasterData(vehicle)
        return vehicle
    }

    private fun enrichWithVehicleMasterData(vehicle: Vehicle) {
        vehicle.addVehicleMasterData(fetchVehicleMasterData.fetch(vehicle.vin))
    }

}