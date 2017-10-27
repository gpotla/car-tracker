package com.cartracker.controller;

import com.cartracker.DTO.HighAlerts;
import com.cartracker.entity.Reading;
import com.cartracker.service.AlertsAndReadingsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlertsAndReadingsRetrievalController {

    @Autowired
    AlertsAndReadingsManagementService alertsAndReadingsManagementService;

    @RequestMapping(value = "/listAllHighAlerts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<HighAlerts> numberOfHighAlerts(){
        return alertsAndReadingsManagementService.retrieveAllHighAlerts();
    }

    @RequestMapping(value = "/vehicleReadings/{id}/{specifiedTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> vehicleReadingsHistory(@PathVariable("id") String vin,@PathVariable("specifiedTime") int specifiedTime) {
        return alertsAndReadingsManagementService.vehicleReadingsHistory(vin,specifiedTime);
    }

    public void vehicleHistoricalAlerts(String vehicleId){

        // To be implement it is used by UI part

    }

}
