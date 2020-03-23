package com.sxm.controller;

import com.sxm.model.Vehicle;
import com.sxm.starter.SXMAsyncRestAPIApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SXMAsyncRestAPIApplication.class)
public class VehicleControllerTest {

    @Autowired
    VehicleController vehicleController;

    @Test
    public void testCreateVehicle() throws URISyntaxException {

        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Make");
        vehicle.setModel("Model");
        vehicle.setTransmissionType("TransmissionType");
        vehicle.setVin("VIN");
        vehicle.setYear(2020);

        ResponseEntity<String> responseEntity = vehicleController.createVehicle(vehicle);

        Assert.assertEquals(responseEntity.getStatusCode().value(), 200);
        Assert.assertNotNull(responseEntity.getBody());
    }
}
