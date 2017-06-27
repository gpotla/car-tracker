package com.cartracker.repository;


import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {

    void insertVehicleInformation(List<Vehicle> vehicleList);

    void updateReadings(Reading reading);
}
