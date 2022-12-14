package com.hexaclean.arc.demo.lab.five;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleCommandService;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbCommand;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DomainService_Task_5_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleCommandService should create a vehicle")
    void should_create_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        Vehicle vehicle = createVehicle(expectedVehicle);
        assertThat(vehicle.getVin().getValue()).isEqualTo(expectedVehicle.getVin().getValue());
        assertThat(vehicle.getVehicleMotionData().getLicensePlate().getValue()).isEqualTo(expectedVehicle.getVehicleMotionData().getMileage().getValue());
        assertThat(vehicle.getVehicleMotionData().getMileage().getValue()).isEqualTo(expectedVehicle.getVehicleMotionData().getMileage().getValue());
    }

    @Test
    @DisplayName("The VehicleCommandServie should update a vehicle")
    void should_update_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        Vehicle vehicle = updateVehicle(expectedVehicle);
        assertThat(vehicle.getVin().getValue()).isEqualTo(expectedVehicle.getVin().getValue());
        assertThat(vehicle.getVehicleMotionData().getLicensePlate().getValue()).isEqualTo(expectedVehicle.getVehicleMotionData().getLicensePlate().getValue());
        assertThat(vehicle.getVehicleMotionData().getMileage().getValue()).isEqualTo(expectedVehicle.getVehicleMotionData().getMileage().getValue());
    }

    private Vehicle createVehicle(Vehicle vehicleToCreate) {
        VehicleDbCommand vehicleCommand = Mockito.mock(VehicleDbCommand.class);
        when(vehicleCommand.saveVehicle(vehicleToCreate)).thenReturn(vehicleToCreate);
        return new VehicleCommandService(vehicleCommand).create(vehicleToCreate);
    }

    private Vehicle updateVehicle(Vehicle vehicleToUpdate) {
        VehicleDbCommand vehicleCommand = Mockito.mock(VehicleDbCommand.class);
        when(vehicleCommand.saveVehicle(vehicleToUpdate)).thenReturn(vehicleToUpdate);
        return new VehicleCommandService(vehicleCommand).update(vehicleToUpdate.getVin(), vehicleToUpdate.getVehicleMotionData());
    }

}
