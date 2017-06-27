package com.cartracker.controller;

import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarTrackerRestApiController {

    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(value = "/vehicles", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createVehicles(@RequestBody List<Vehicle> list){
        System.out.println("PUT");
        for(Vehicle v : list)
        System.out.println(v.toString());

    }

    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(value = "/readings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void vehicleReadings(@RequestBody Reading r){
        System.out.println(r.toString());
    }
}
