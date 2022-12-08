package com.hexaclean.arc.demo.app.garage.order.domain.model


class GarageOrder(var vehicle: Vehicle, val orderNumber: OrderNumber, val positions: MutableList<OrderPosition>) {

    open fun addOrderPosition(orderPositions: List<OrderPosition>?) {
        //some validation logic
        positions.addAll(orderPositions!!)
    }

    open fun changeVehicle(vehicle: Vehicle) {
        this.vehicle = vehicle
    }
}