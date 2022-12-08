package com.hexaclean.arc.demo.app.garage.order.usecase.out

import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder

interface GarageOrderDbCommand {
    fun save(garageOrder: GarageOrder): GarageOrder
}