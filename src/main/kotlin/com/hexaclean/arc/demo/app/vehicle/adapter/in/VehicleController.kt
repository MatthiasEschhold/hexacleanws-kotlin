package com.hexaclean.arc.demo.app.vehicle.adapter.`in`

import com.hexaclean.arc.demo.app.vehicle.adapter.`in`.resource.VehicleMotionDataResource
import com.hexaclean.arc.demo.app.vehicle.adapter.`in`.resource.VehicleResource
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMotionData
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.VehicleCommand
import com.hexaclean.arc.demo.app.vehicle.usecase.`in`.VehicleQuery

//@RestController
//@RequestMapping("/vehicles")
class VehicleController(
    val vehicleQuery: VehicleQuery,
    val mapper: VehicleToVehicleResourceMapper,
    val vehicleCommand: VehicleCommand
) {
     //@GetMapping("/{vin}")
    fun readVehicle(vin: String): VehicleResource? {
        return mapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(Vin(vin)))
    }

    //@PutMapping("/{vin}")
    fun updateVehicle(vin: String, resource: VehicleMotionDataResource): VehicleResource {
        val vehicleMotionData: VehicleMotionData = mapper.mapVehicleResourceToVehicleMotionData(resource)
        val updatedVehicle: Vehicle = vehicleCommand.update(Vin(vin), vehicleMotionData)
        return mapper.mapVehicleToVehicleResource(updatedVehicle)
    }

    //@PostMapping
    fun createVehicle(resource: VehicleResource): VehicleResource {
        val createdVehice: Vehicle = vehicleCommand.create(mapper.mapVehicleResourceToVehicle(resource))
        return mapper.mapVehicleToVehicleResource(createdVehice)
    }
}