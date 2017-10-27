package com.cartracker.DTO;

import org.springframework.stereotype.Component;

@Component
public class HighAlerts {

    private String vin;
    private String make;
    private String model;
    private int numberOfHighAlerts;

    public HighAlerts(){}

    public HighAlerts(String vin, String make, String model, int numberOfHighAlerts) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.numberOfHighAlerts = numberOfHighAlerts;
    }
}
