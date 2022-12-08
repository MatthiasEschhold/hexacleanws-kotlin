package com.hexaclean.arc.demo.app.garage.order.domain.service

import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber
import com.hexaclean.arc.demo.app.garage.order.usecase.`in`.GarageOrderQuery
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery

class GarageOrderQueryService(private val dbQuery: GarageOrderDbQuery) : GarageOrderQuery {
    override fun read(orderNumber: OrderNumber?): GarageOrder? {
        return orderNumber?.let { dbQuery.findByOrderNumber(it) }
    }
}