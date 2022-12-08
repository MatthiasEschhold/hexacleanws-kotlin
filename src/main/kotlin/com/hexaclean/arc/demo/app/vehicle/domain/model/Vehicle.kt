package com.hexaclean.arc.demo.app.vehicle.domain.model

import com.hexaclean.arc.demo.common.mappings.Default

class Vehicle(val vin: Vin, val vehicleMotionData: VehicleMotionData) {
    var vehicleMasterData: VehicleMasterData? = null
        private set

    var isHas2GSupport: Boolean? = null
        private set

    init {
        check(vin == null || vehicleMotionData == null) {
            throw IllegalStateException("One or more of the properties vin or motion data are null!")
        }
    }

    @Default
    constructor(vin: Vin, vehicleMotionData: VehicleMotionData, vehicleMasterData: VehicleMasterData) : this(
        vin,
        vehicleMotionData
    ) {
        addVehicleMasterData(vehicleMasterData)
    }

    private fun determineHas2GSupport(equipmentList: List<Equipment>) {
        isHas2GSupport = equipmentList.stream()
            .filter { e: Equipment -> e.code.value == "GS200" }
            .findAny()
            .isPresent
    }

    private fun validateVehicleMasterData() {
        checkNotNull(vehicleMasterData) { throw IllegalStateException("vehicle master data should not be null!") }
    }

    fun addVehicleMasterData(vehicleMasterData: VehicleMasterData?) {
        this.vehicleMasterData = vehicleMasterData
        validateVehicleMasterData()
        this.vehicleMasterData?.let { determineHas2GSupport(it.equipmentList) }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vehicle

        if (vin != other.vin) return false

        return true
    }

    override fun hashCode(): Int {
        return vin.hashCode()
    }

}