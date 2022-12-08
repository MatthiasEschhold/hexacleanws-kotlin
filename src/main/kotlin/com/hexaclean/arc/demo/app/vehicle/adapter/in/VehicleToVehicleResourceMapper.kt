package com.hexaclean.arc.demo.app.vehicle.adapter.`in`

import com.hexaclean.arc.demo.app.vehicle.adapter.`in`.resource.EquipmentResource
import com.hexaclean.arc.demo.app.vehicle.adapter.`in`.resource.VehicleMotionDataResource
import com.hexaclean.arc.demo.app.vehicle.adapter.`in`.resource.VehicleResource
import com.hexaclean.arc.demo.app.vehicle.domain.model.*
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named

@Mapper
interface VehicleToVehicleResourceMapper {
    @Mapping(source = "mileage", target = "vehicleMotionData.mileage.value")
    @Mapping(source = "licensePlate", target = "vehicleMotionData.licensePlate.value")
    @Mapping(source = "mileageUnit", target = "vehicleMasterData.mileageUnit", qualifiedByName = ["mapToMileageUnit"])
    @Mapping(source = "vehicleModelName", target = "vehicleMasterData.vehicleModel.modelDescription")
    @Mapping(source = "vehicleModelType", target = "vehicleMasterData.vehicleModel.modelType")
    @Mapping(source = "serialNumber", target = "vehicleMasterData.serialNumber.value")
    @Mapping(source = "vin", target = "vin.value")
    //@Mapping(source = "has2GSupport", target = "has2GSupport")
    @Mapping(source = "equipmentList", target = "vehicleMasterData.equipmentList")
    fun mapVehicleResourceToVehicle(resource: VehicleResource): Vehicle

    @Mapping(source = "code", target = "code.value")
    @Mapping(source = "description", target = "description")
    fun mapEquipmentResourceToEquipment(resource: EquipmentResource): Equipment

    @Mapping(source = "licensePlate", target = "licensePlate.value")
    @Mapping(source = "mileage", target = "mileage.value")
    fun mapVehicleResourceToVehicleMotionData(resource: VehicleMotionDataResource): VehicleMotionData

    @Mapping(target = "mileage", source = "vehicleMotionData.mileage.value")
    @Mapping(target = "licensePlate", source = "vehicleMotionData.licensePlate.value")
    @Mapping(target = "mileageUnit", source = "vehicleMasterData.mileageUnit", qualifiedByName = ["mapToMileageUnitPrimitive"])
    @Mapping(target = "vehicleModelName", source = "vehicleMasterData.vehicleModel.modelDescription")
    @Mapping(target = "vehicleModelType", source = "vehicleMasterData.vehicleModel.modelType")
    @Mapping(target = "serialNumber", source = "vehicleMasterData.serialNumber.value")
    @Mapping(target = "vin", source = "vin.value")
    @Mapping(target = "has2GSupport", source = "has2GSupport")
    @Mapping(target = "equipmentList", source = "vehicleMasterData.equipmentList")
    fun mapVehicleToVehicleResource(entity: Vehicle?): VehicleResource

    @Mapping(target = "code", source = "code.value")
    @Mapping(target = "description", source = "description")
    fun mapEquipmentResourceToEquipment(equipment: Equipment): EquipmentResource

    companion object {
        @JvmStatic
        @Named("mapToMileageUnit")
        fun mapToMileageUnit(mileageUnit: String): MileageUnit {
            return MileageUnit(MileageUnitValue.valueOf(mileageUnit))
        }

        @JvmStatic
        @Named("mapToMileageUnitPrimitive")
        fun mapToMileageUnitPrimitive(mileageUnit: MileageUnit): String {
            return mileageUnit.value.toString()
        }
    }
}