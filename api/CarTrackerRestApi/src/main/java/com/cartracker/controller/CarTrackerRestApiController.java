package com.cartracker.controller;

import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;
import com.cartracker.service.AlertsAndReadingsManagementService;
import com.cartracker.service.VehicleRecordsStoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarTrackerRestApiController {

    @Autowired
    VehicleRecordsStoringService vehicleRecordsStoringService;
    @Autowired
    AlertsAndReadingsManagementService alertsAndReadingsManagementService;

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

        vehicleRecordsStoringService.recordVehicleReadings(reading);
        alertsAndReadingsManagementService.checkingForAlerts(reading);

    }

    @RequestMapping(value = "/vehicleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> listAllVehicles(){
        return vehicleRecordsStoringService.listOfVehicles();
    }

}
