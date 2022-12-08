package com.hexaclean.arc.demo.lab.six;

import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleQueryService;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DomainRing_Task_6_1 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleService should implement the orchestration between different outgoing use cases")
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);

        VehicleDbQuery vehicleDbQuery = Mockito.mock(VehicleDbQuery.class);
        when(vehicleDbQuery.findVehicleByLicensePlate(new LicensePlate(LICENSE_PLATE_TEST_VALUE))).thenReturn(createExpectedVehicle());

        FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
        when(fetchVehicleMasterData.fetch(vin)).thenReturn(createExpectedVehicleMasterData());

        Vehicle expectedVehicle = createExpectedVehicle();
        Vehicle vehicle = new VehicleQueryService(vehicleDbQuery, fetchVehicleMasterData).findByLicensePlate(expectedVehicle.getVehicleMotionData().getLicensePlate());

        assertThat(vehicle).isEqualTo(expectedVehicle);
        assertThat(vehicle.getVehicleMasterData().getVehicleModel().getModelType()).isEqualTo(expectedVehicle.getVehicleMasterData().getVehicleModel().getModelType());
        assertThat(vehicle.getVehicleMasterData().getVehicleModel().getModelDescription()).isEqualTo(expectedVehicle.getVehicleMasterData().getVehicleModel().getModelDescription());
        assertThat(vehicle.getVehicleMasterData().getMileageUnit()).isEqualTo(expectedVehicle.getVehicleMasterData().getMileageUnit());
        assertThat(vehicle.getVehicleMasterData().getSerialNumber()).isEqualTo(expectedVehicle.getVehicleMasterData().getSerialNumber());
        assertThat(vehicle.isHas2GSupport()).isFalse();
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin());
        assertThat(vehicle.getVehicleMotionData().getLicensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().getLicensePlate());
        assertThat(vehicle.getVehicleMotionData().getMileage()).isEqualTo(expectedVehicle.getVehicleMotionData().getMileage());
    }

}
