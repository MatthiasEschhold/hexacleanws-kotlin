package com.hexaclean.arc.demo.app.vehicle.domain.model

data class VehicleMasterData(
    val vehicleModel: VehicleModel,
    val serialNumber: SerialNumber,
    val mileageUnit: MileageUnit,
    val equipmentList: List<Equipment>
) {
    init {
        check((vehicleModel == null) || (serialNumber == null) || (mileageUnit == null) || (mileageUnit == null)) {
            throw IllegalStateException("One or more of VehicleModel, SerialNumber oer MileageUnit are null")
        }
    }
}