package com.cartracker.service;

import com.cartracker.DTO.HighAlerts;
import com.cartracker.entity.*;
import com.cartracker.exception.ResourceNotFoundException;
import com.cartracker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertsAndReadingsManagementServiceImpl implements AlertsAndReadingsManagementService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional
    public void checkingForAlerts(Reading reading) {

        Vehicle vehicle = vehicleRepository.findVehicleByVin(reading.getVin());
        Tyre tyre = reading.getTires();

        if(vehicle.getRedlineRpm()<reading.getEngineRpm()){
            Alert alert = new Alert();
            alert.setAlertType("High");
            alert.setMessage("Check engine RPM");
            alert.setReadingId(reading.getReadingId());
            vehicleRepository.createAlert(alert);
        }
        if(reading.getFuelVolume()<(0.1*vehicle.getMaxFuelVolume())){
            Alert alert = new Alert();
            alert.setAlertType("Medium");
            alert.setMessage("Check the FUEL VOLUME, it is less than 10 percent of max fuel volume");
            alert.setReadingId(reading.getReadingId());
            vehicleRepository.createAlert(alert);
        }
        if((tyre.getFrontLeft()<32 || tyre.getFrontLeft()>36) || (tyre.getFrontRight()<32 || tyre.getFrontRight()>36)
                || (tyre.getRearLeft()<32 || tyre.getRearLeft()>36) || (tyre.getRearRight()<32 || tyre.getRearRight()>36)){
            Alert alert = new Alert();
            alert.setAlertType("Low");
            alert.setMessage("Check TIRES PRESSURE");
            alert.setReadingId(reading.getReadingId());
            vehicleRepository.createAlert(alert);
        }
        if(reading.isCheckEngineLightOn()){
            Alert alert = new Alert();
            alert.setAlertType("Low");
            alert.setMessage("Check your ENGINE LIGHT it is ON");
            alert.setReadingId(reading.getReadingId());
            vehicleRepository.createAlert(alert);
        }
        if(reading.isEngineCoolantLow()){
            Alert alert = new Alert();
            alert.setAlertType("Low");
            alert.setMessage("Check your ENGINE COOLANT");
            alert.setReadingId(reading.getReadingId());
            vehicleRepository.createAlert(alert);
        }
    }

    @Transactional
    public List<HighAlerts> retrieveAllHighAlerts() {
        return vehicleRepository.listOfHighAlerts();
    }

    @Transactional
    public List<Reading> vehicleReadingsHistory(String vin, int specifiedTime) {
        Vehicle vehicle = vehicleRepository.findVehicleByVin(vin);
        if(vehicle == null){
            throw new ResourceNotFoundException("Vehicle with Id: "+vin+" not found");
        }
        return vehicleRepository.vehicleReadingsHistory(vin,specifiedTime);
    }

}
