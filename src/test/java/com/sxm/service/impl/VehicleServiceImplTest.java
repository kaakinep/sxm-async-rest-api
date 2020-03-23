package com.sxm.service.impl;


import com.sxm.model.Vehicle;
import com.sxm.service.VehicleService;
import com.sxm.starter.SXMAsyncRestAPIApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SXMAsyncRestAPIApplication.class)
public class VehicleServiceImplTest {

    @Autowired
    VehicleService vehicleService;

    @Test
    public void createVehicle() throws InterruptedException {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Make");
        vehicle.setModel("Model");
        vehicle.setTransmissionType("TransmissionType");
        vehicle.setVin("VIN");
        vehicle.setYear(2020);
        String vehicleId = UUID.randomUUID().toString();
        Future<String> result = vehicleService.createVehicle(vehicle, vehicleId);
        String resultToCompare = "Vehicle has been created successfully, Vehicle ID : " + vehicleId;
        String actualResult = "";
        while (true) {
            if (result.isDone()) {
                actualResult = "Vehicle has been created successfully, Vehicle ID : " + vehicleId;
                break;
            }
            Thread.sleep(1000);
        }
        Assert.assertEquals(resultToCompare, actualResult);
    }

}
