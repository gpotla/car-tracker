package com.cartracker.service;

import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;
import com.cartracker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleRecordsStoringServiceImpl implements VehicleRecordsStoringService{

    @Autowired
    VehicleRepository vehicleRepository;

    public void insertVehicleInformation(List<Vehicle> vehicleList) {

        vehicleRepository.insertVehicleInformation(vehicleList);

    }

    public void updateVehicleReadings(Reading reading) {

        vehicleRepository.updateReadings(reading);

    }

}
