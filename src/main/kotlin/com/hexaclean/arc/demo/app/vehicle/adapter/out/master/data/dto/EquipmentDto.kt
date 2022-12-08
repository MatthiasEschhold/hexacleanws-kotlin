package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto

class EquipmentDto {
    var code: String? = null
    var label: String? = null

    constructor() {}
    constructor(code: String?, label: String?) {
        this.code = code
        this.label = label
    }
}