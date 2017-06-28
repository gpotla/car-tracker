package com.cartracker.service;

import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;

import java.util.List;

public interface VehicleRecordsStoringService {

    void insertVehicleInformation(List<Vehicle> vehicleList);

    void recordVehicleReadings(Reading reading);
}
