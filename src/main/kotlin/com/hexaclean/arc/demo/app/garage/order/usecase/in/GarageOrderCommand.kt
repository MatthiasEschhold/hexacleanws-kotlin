package com.hexaclean.arc.demo.app.garage.order.usecase.`in`

import com.hexaclean.arc.demo.app.garage.order.domain.command.CreateGarageOrderCommand
import com.hexaclean.arc.demo.app.garage.order.domain.command.UpdateGarageOrderCommand
import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder

interface GarageOrderCommand {
    fun create(createGarageOrderCommand: CreateGarageOrderCommand): GarageOrder
    fun update(updateGarageOrderCommand: UpdateGarageOrderCommand): GarageOrder
}