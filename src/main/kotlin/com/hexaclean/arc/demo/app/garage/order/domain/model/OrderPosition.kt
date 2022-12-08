package com.hexaclean.arc.demo.app.garage.order.domain.model

class OrderPosition(var positionNumber: String, var description: String, var quantity: Double) {

    open fun changeQuantity(quantity: Double) {
        this.quantity = quantity
    }
}