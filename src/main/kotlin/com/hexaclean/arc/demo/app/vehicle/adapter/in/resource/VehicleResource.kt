package com.hexaclean.arc.demo.app.vehicle.adapter.`in`.resource

class VehicleResource {
    var vin: String? = null
    var licensePlate: String? = null
    var mileage = 0.0
    var mileageUnit: String? = null
    var vehicleModelName: String? = null
    var vehicleModelType: String? = null
    var serialNumber: String? = null
    var isHas2GSupport = false
    var equipmentList: List<EquipmentResource>? = null
}