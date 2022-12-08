package com.hexaclean.arc.demo.app.vehicle.adapter.`in`

import com.hexaclean.arc.demo.app.vehicle.adapter.`in`.resource.VehicleResource
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.VehicleQuery

//@RestController
//@RequestMapping("/vehicles")
class VehicleController(
    val vehicleQuery: VehicleQuery,
    val mapper: VehicleToVehicleResourceMapper
) {
     //@GetMapping("/{vin}")
    fun readVehicle(vin: String): VehicleResource {
        return mapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(Vin(vin)))
    }
}