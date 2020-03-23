package com.sxm.controller;

import com.sxm.model.TransmissionType;
import com.sxm.model.Vehicle;
import com.sxm.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/vehicle-api/v1")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/vehicles/vehicle", method = RequestMethod.POST)
    public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle) throws URISyntaxException {

        if(vehicle == null || StringUtils.isEmpty(vehicle.getVin()) || StringUtils.isEmpty(vehicle.getMake())
                || StringUtils.isEmpty(vehicle.getModel()) || StringUtils.isEmpty(vehicle.getTransmissionType()) || vehicle.getYear() <= 0){
            return new ResponseEntity<String>("Either Vehicle data is null or either of VIN/Year/Make/Model/TransmissionType is null or empty or invalid", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(StringUtils.isEmpty(vehicle.getTransmissionType()) || !TransmissionType.contains(vehicle.getTransmissionType())){
            return new ResponseEntity<String>("Invalid TransmissionType received. It has to be either 'MANUAL' or 'AUTO'", new HttpHeaders(), HttpStatus.OK);
        }

        String vehicleId = UUID.randomUUID().toString();

        /**
         * Creating a result(AsyncResult) so we can retrieve the result of the asynchronous method if needed
         */
        Future<String> result =vehicleService.createVehicle(vehicle, vehicleId);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(new URI(vehicleId));
        responseHeaders.set("Vehicle ID", vehicleId);
        return new ResponseEntity<String>("Vehicle has been created successfully, Vehicle ID : " + vehicleId, responseHeaders, HttpStatus.OK);
    }

}
