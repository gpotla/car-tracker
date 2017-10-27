package com.cartracker.repository;


import com.cartracker.entity.Alert;
import com.cartracker.DTO.HighAlerts;
import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {

    void insertVehicleInformation(Vehicle vehicle);

    void updateVehicleInformation(Vehicle vehicle);

    void recordVehicleReadings(Reading reading);

    Vehicle findVehicleByVin(String vin);

    void createAlert(Alert alert);

    List<Vehicle> listOfVehicles();

    List<HighAlerts> listOfHighAlerts();

    List<Reading> vehicleReadingsHistory(String vin, int specifiedTime);
}
