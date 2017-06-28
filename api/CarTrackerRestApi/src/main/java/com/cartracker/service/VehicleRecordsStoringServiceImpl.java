package com.cartracker.service;

import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;
import com.cartracker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleRecordsStoringServiceImpl implements VehicleRecordsStoringService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional
    public void insertVehicleInformation(List<Vehicle> vehicleList) {
        for (Vehicle vehicle:vehicleList) {
            Vehicle v = vehicleRepository.findVehicleByVin(vehicle.getVin());
            if(v == null)
                vehicleRepository.insertVehicleInformation(vehicle);
            else
                vehicleRepository.updateVehicleInformation(vehicle);
        }
    }

    @Transactional
    public void recordVehicleReadings(Reading reading) {

        vehicleRepository.recordVehicleReadings(reading);

    }

}
