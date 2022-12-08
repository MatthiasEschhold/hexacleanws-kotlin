package com.hexaclean.arc.demo.lab.three;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleController;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleToVehicleResourceMapper;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class InputAdapter_Task_3_3 extends BaseExerciseTest {

    @Test
    @DisplayName("VehicleController should return a valid vehicle")
    void vehicle_controller_should_return_a_valid_vehicle() {
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        Vehicle vehicle = createExpectedVehicle();
        VehicleResource expectedVehicleResource = createExpectedVehicleResource();
        VehicleToVehicleResourceMapper mapper = Mockito.mock(VehicleToVehicleResourceMapper.class);

        when(vehicleQuery.findByVin(new Vin(VIN))).thenReturn(vehicle);

        when(mapper.mapVehicleToVehicleResource(vehicle)).thenReturn(expectedVehicleResource);

        VehicleResource vehicleResource = createVehicleController(vehicleQuery, mapper).readVehicle(VIN);
        assertThat(vehicleResource.getVin()).isEqualTo(createExpectedVehicleResource().getVin());
    }

    private VehicleController createVehicleController(VehicleQuery vehicleQuery, VehicleToVehicleResourceMapper mapper) {

        return new VehicleController(vehicleQuery, mapper);
    }

}
