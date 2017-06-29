package com.cartracker.service;

import com.cartracker.entity.Alert;
import com.cartracker.entity.Reading;
import com.cartracker.entity.Tyre;
import com.cartracker.entity.Vehicle;
import com.cartracker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertManagementServiceImpl implements AlertManagementService{

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

}
