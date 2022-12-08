package com.hexaclean.arc.demo.app.vehicle.adapter.`in`

import com.hexaclean.arc.demo.app.vehicle.adapter.`in`.resource.VehicleResource
import com.hexaclean.arc.demo.app.vehicle.domain.model.*
import org.mapstruct.Mapping

//@Mapper
interface VehicleToVehicleResourceMapper {

    @Mapping(source = "vin", target = "vin.value")
    fun mapVehicleResourceToVehicle(resource: VehicleResource): Vehicle

    @Mapping(target = "vin", source = "vin.value")
    fun mapVehicleToVehicleResource(entity: Vehicle): VehicleResource

}