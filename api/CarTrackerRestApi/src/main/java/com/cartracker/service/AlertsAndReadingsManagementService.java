package com.cartracker.service;


import com.cartracker.DTO.HighAlerts;
import com.cartracker.entity.Reading;

import java.util.List;

public interface AlertsAndReadingsManagementService {
    void checkingForAlerts(Reading reading);
    List<HighAlerts> retrieveAllHighAlerts();
    List<Reading> vehicleReadingsHistory(String vin, int specifiedTime);
}
