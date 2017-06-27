package com.cartracker.controller;

import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;
import com.cartracker.service.VehicleRecordsStoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarTrackerRestApiController {

    @Autowired
    VehicleRecordsStoringService vehicleRecordsStoringService;

    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(value = "/vehicles", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createVehicles(@RequestBody List<Vehicle> listOfVehicles){

        vehicleRecordsStoringService.insertVehicleInformation(listOfVehicles);

    }

    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(value = "/readings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void vehicleReadings(@RequestBody Reading reading){

        vehicleRecordsStoringService.updateVehicleReadings(reading);

    }
}
