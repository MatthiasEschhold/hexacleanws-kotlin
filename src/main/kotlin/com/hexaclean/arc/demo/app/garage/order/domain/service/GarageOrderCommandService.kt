package com.hexaclean.arc.demo.app.garage.order.domain.service

import com.hexaclean.arc.demo.app.garage.order.domain.command.CreateGarageOrderCommand
import com.hexaclean.arc.demo.app.garage.order.domain.command.UpdateGarageOrderCommand
import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber
import com.hexaclean.arc.demo.app.garage.order.usecase.`in`.GarageOrderCommand
import com.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbCommand
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery

class GarageOrderCommandService(
    val dbCommand: GarageOrderDbCommand,
    val dbQuery: GarageOrderDbQuery,
    val fetchVehicle: FetchVehicle
) : GarageOrderCommand {

    override fun create(createGarageOrderCommand: CreateGarageOrderCommand): GarageOrder {
        val orderNumber = createOrderNumber()
        val garageOrder: GarageOrder = createGarageOrder(createGarageOrderCommand, orderNumber)
        return dbCommand.save(garageOrder)
    }

    private fun createGarageOrder(
        createGarageOrderCommand: CreateGarageOrderCommand,
        orderNumber: OrderNumber
    ): GarageOrder {
        return GarageOrder(
            createGarageOrderCommand.vehicle,
            orderNumber,
            createGarageOrderCommand.orderPositions
        )
    }

    private fun createOrderNumber(): OrderNumber {
        //some complicated determination or
        return OrderNumber("GO-123-01.03.2023-557896332689")
    }

    override fun update(updateGarageOrderCommand: UpdateGarageOrderCommand): GarageOrder {

        val orderNumber: OrderNumber? = updateGarageOrderCommand.orderNumber

        if(orderNumber != null) {
            val garageOrder: GarageOrder = dbQuery.findByOrderNumber(orderNumber)
            optionalAddOrderPositions(updateGarageOrderCommand, garageOrder)
            optionalChangeVehicle(updateGarageOrderCommand, garageOrder)
            return dbCommand.save(garageOrder)
        }
        throw IllegalStateException("Order number is mandatory but it is null!")
    }

    private fun optionalChangeVehicle(updateGarageOrderCommand: UpdateGarageOrderCommand, garageOrder: GarageOrder?) {
        if (updateGarageOrderCommand.licensePlate != null) {
            garageOrder?.changeVehicle(fetchVehicle.fetch(updateGarageOrderCommand.licensePlate!!))
        }
    }

    private fun optionalAddOrderPositions(
        updateGarageOrderCommand: UpdateGarageOrderCommand,
        garageOrder: GarageOrder
    ) {
        if (updateGarageOrderCommand.orderPositions != null) {
            garageOrder.addOrderPosition(updateGarageOrderCommand.orderPositions)
        }
    }
}