package com.sxm.service.impl;

import com.google.gson.Gson;
import com.sxm.model.Vehicle;
import com.sxm.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Override
    @Async
    public Future<String> createVehicle(Vehicle vehicle, String vehicleId) {
            LOGGER.info("Request Payload : " + new Gson().toJson(vehicle));
            LOGGER.info("Vehicle has been created successfully, Vehicle ID : " + vehicleId);
        return new AsyncResult<String>("Vehicle has been created successfully, Vehicle ID : " + vehicleId);
    }

}
