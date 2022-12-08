package com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle

class VehicleToOriginVehicleMapper {
    fun mapOriginVehicleToVehicle(originVehicle: Vehicle): com.hexaclean.arc.demo.app.garage.order.domain.model.Vehicle {
        return com.hexaclean.arc.demo.app.garage.order.domain.model.Vehicle(
            originVehicle.vin.value,
            originVehicle.vehicleMotionData.mileage.value
        )
    }
}