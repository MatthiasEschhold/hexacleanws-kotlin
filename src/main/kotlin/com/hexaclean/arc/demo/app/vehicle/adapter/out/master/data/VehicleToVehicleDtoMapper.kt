package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data

import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentDto
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.VehicleDataDto
import com.hexaclean.arc.demo.app.vehicle.domain.model.*
import java.util.stream.Collectors

class VehicleToVehicleDtoMapper {
    fun mapVehicleDtoToVehicleMasterData(dto: VehicleDataDto): VehicleMasterData {
        return VehicleMasterData(
            VehicleModel(dto.baumuster!!, dto.baumusterDescription!!),
            SerialNumber(dto.serialNumber!!),
            MileageUnit(MileageUnitValue.valueOf(dto.mileageUnit!!)),
            dto.equipmentListDto!!.equipmentList!!
                .map { dto: EquipmentDto -> mapEquipmentDToToEquipment(dto) })
    }

    private fun mapEquipmentDToToEquipment(dto: EquipmentDto): Equipment {
        return Equipment(EquipmentCode(dto.code!!), dto.label!!)
    }
}