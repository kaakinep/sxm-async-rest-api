package com.sxm.service;

import com.sxm.model.Vehicle;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public interface VehicleService {

    @Async
    Future<String> createVehicle(Vehicle vehicle, String vehicleId);
}
