package com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("VEHICLE")
class VehicleDbEntity {
    @Column("ID")
    var vin: String? = null

    @Column("LICENSE_PLATE")
    var licensePlate: String? = null

    @Column("MILEAGE")
    var milage: Double? = null
}