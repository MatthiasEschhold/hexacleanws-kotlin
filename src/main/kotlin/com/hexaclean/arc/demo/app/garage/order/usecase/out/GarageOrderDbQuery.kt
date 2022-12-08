package com.hexaclean.arc.demo.app.garage.order.usecase.out

import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber

interface GarageOrderDbQuery {
    fun findByOrderNumber(orderNumber: OrderNumber): GarageOrder
}