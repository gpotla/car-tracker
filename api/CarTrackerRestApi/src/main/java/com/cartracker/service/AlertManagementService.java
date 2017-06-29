package com.cartracker.service;


import com.cartracker.entity.Reading;

public interface AlertManagementService {
    void checkingForAlerts(Reading reading);
}
