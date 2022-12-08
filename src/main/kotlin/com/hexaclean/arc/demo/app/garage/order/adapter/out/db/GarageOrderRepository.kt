package com.hexaclean.arc.demo.app.garage.order.adapter.out.db

import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber
import com.hexaclean.arc.demo.app.garage.order.domain.model.Vehicle
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbCommand
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery

class GarageOrderRepository : GarageOrderDbCommand, GarageOrderDbQuery {

    override fun save(garageOrder: GarageOrder): GarageOrder {
        return garageOrder
    }

    override fun findByOrderNumber(orderNumber: OrderNumber): GarageOrder {
        return GarageOrder(Vehicle("ES-EM  385", 105000.00), orderNumber, ArrayList())
    }
}