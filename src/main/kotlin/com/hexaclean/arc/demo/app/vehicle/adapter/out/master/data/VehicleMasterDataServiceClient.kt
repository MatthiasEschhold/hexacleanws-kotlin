package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data

import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentDto
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentListDto
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.VehicleDataDto
import com.hexaclean.arc.demo.app.vehicle.domain.model.MileageUnitValue
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData

class VehicleMasterDataServiceClient(private val mapper: VehicleToVehicleDtoMapper) : FetchVehicleMasterData {
    override fun fetch(vin: Vin): VehicleMasterData {
        return mapper.mapVehicleDtoToVehicleMasterData(createExpectedVehicleDto())
    }

    private fun createExpectedVehicleDto(): VehicleDataDto {
        val equipmentListDto = EquipmentListDto()
        equipmentListDto.equipmentList = createEquipmentListDto()
        val vehicleDto = VehicleDataDto()
        vehicleDto.baumuster = VEHICLE_MODEL_TYPE_TEST_VALUE
        vehicleDto.baumusterDescription = VEHICLE_MODEL_DESCRIPTION_TEST_VALUE
        vehicleDto.mileageUnit = MileageUnitValue.KM.toString()
        vehicleDto.vinOrFin = VIN
        vehicleDto.serialNumber = SERIAL_NUMBER_TEST_VALUE
        vehicleDto.equipmentListDto = equipmentListDto
        return vehicleDto
    }

    private fun createEquipmentListDto(): List<EquipmentDto> {
        val list: MutableList<EquipmentDto> = ArrayList<EquipmentDto>()
        list.add(EquipmentDto("CU897", "Live Traffic Assistent"))
        list.add(EquipmentDto("DK564", "Visual Park Assistent"))
        list.add(EquipmentDto("KL457", "Sports Chassis M Deluxe"))
        return list
    }

    companion object {
        private const val VEHICLE_MODEL_DESCRIPTION_TEST_VALUE = "E30 Limousine"
        private const val VEHICLE_MODEL_TYPE_TEST_VALUE = "3er"
        private const val SERIAL_NUMBER_TEST_VALUE = "0123456789"
        private const val VIN = "WP0ZZZ99ZTS392155"
    }
}