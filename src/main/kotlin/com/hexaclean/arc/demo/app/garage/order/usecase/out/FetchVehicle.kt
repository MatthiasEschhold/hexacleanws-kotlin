package com.hexaclean.arc.demo.app.garage.order.usecase.out

import com.hexaclean.arc.demo.app.garage.order.domain.model.Vehicle

interface FetchVehicle {
    fun fetch(licensePlate: String): Vehicle
}