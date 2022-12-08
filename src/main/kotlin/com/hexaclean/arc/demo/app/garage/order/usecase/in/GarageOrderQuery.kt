package com.hexaclean.arc.demo.app.garage.order.usecase.`in`

import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber

interface GarageOrderQuery {
    fun read(orderNumber: OrderNumber?): GarageOrder?
}