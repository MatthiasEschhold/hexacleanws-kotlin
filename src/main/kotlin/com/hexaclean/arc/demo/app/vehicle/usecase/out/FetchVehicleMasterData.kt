package com.hexaclean.arc.demo.app.vehicle.usecase.out

import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin

interface FetchVehicleMasterData {
    fun fetch(vin: Vin): VehicleMasterData
}