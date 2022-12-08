package com.hexaclean.arc.demo.lab.five;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleController;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleToVehicleResourceMapper;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleMotionDataResource;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleCommand;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class InputAdapter_Task_5_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleController should save a vehicle")
    void should_save_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        VehicleResource vehicle = createVehicle(expectedVehicle);
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin().getValue());
        assertThat(vehicle.getLicensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().getLicensePlate().getValue());
        assertThat(vehicle.getMileage()).isEqualTo(expectedVehicle.getVehicleMotionData().getMileage().getValue());
    }

    @Test
    @DisplayName("The VehicleController should update a vehicle")
    void should_update_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        VehicleResource vehicle = updateVehicle(expectedVehicle);
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin().getValue());
        assertThat(vehicle.getLicensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().getLicensePlate().getValue());
        assertThat(vehicle.getMileage()).isEqualTo(expectedVehicle.getVehicleMotionData().getMileage().getValue());
    }

    private VehicleResource createVehicle(Vehicle vehicleToSave) {
        VehicleResource vehicleResource = createExpectedVehicleResource();
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        VehicleCommand vehicleCommand = Mockito.mock(VehicleCommand.class);
        VehicleToVehicleResourceMapper mapper = Mockito.mock(VehicleToVehicleResourceMapper.class);
        when(mapper.mapVehicleResourceToVehicle(vehicleResource)).thenReturn(vehicleToSave);
        when(vehicleCommand.create(vehicleToSave)).thenReturn(vehicleToSave);
        return new VehicleController(vehicleQuery, mapper, vehicleCommand).createVehicle(vehicleResource);
    }

    private VehicleResource updateVehicle(Vehicle vehicleToSave) {
        VehicleMotionDataResource vehicleResource = createExpectedVehicleMotionDataResource();
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        VehicleCommand vehicleCommand = Mockito.mock(VehicleCommand.class);
        VehicleToVehicleResourceMapper mapper = Mockito.mock(VehicleToVehicleResourceMapper.class);
        when(mapper.mapVehicleResourceToVehicleMotionData(vehicleResource)).thenReturn(vehicleToSave.getVehicleMotionData());
        when(vehicleCommand.update(vehicleToSave.getVin(), vehicleToSave.getVehicleMotionData())).thenReturn(vehicleToSave);
        return new VehicleController(vehicleQuery, mapper, vehicleCommand).updateVehicle(vehicleToSave.getVin().getValue(), vehicleResource);
    }

}
