package com.hexaclean.arc.demo.app.garage.order.domain.command

import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderPosition

class UpdateGarageOrderCommand {

    var orderNumber: OrderNumber? = null
        private set
    var orderPositions: List<OrderPosition>? = null
        private set
    var licensePlate: String? = null
        private set

    constructor(orderNumber: OrderNumber, orderPositions: List<OrderPosition>?) {
        this.orderNumber = orderNumber
        this.orderPositions = orderPositions
    }

    constructor(orderNumber: OrderNumber, licensePlate: String) {
        this.orderNumber = orderNumber
        this.licensePlate = licensePlate
    }

    constructor(orderNumber: OrderNumber, orderPositions: List<OrderPosition>?, licensePlate: String) {
        this.orderNumber = orderNumber
        this.orderPositions = orderPositions
        this.licensePlate = licensePlate
    }
}