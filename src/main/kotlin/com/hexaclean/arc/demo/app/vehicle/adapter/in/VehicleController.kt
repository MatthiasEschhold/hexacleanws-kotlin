package com.hexaclean.arc.demo.app.vehicle.adapter.`in`

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.VehicleQuery

//@RestController
//@RequestMapping("/vehicles")
class VehicleController(
    val vehicleQuery: VehicleQuery
) {
     //@GetMapping("/{vin}")
    fun readVehicle(vin: String): Vehicle? {
        return vehicleQuery.findByVin(Vin(vin))
    }
}