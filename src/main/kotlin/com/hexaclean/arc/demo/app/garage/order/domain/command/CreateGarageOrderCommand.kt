package com.hexaclean.arc.demo.app.garage.order.domain.command

import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderPosition
import com.hexaclean.arc.demo.app.garage.order.domain.model.Vehicle

data class CreateGarageOrderCommand(val orderPositions: MutableList<OrderPosition>, val vehicle: Vehicle)