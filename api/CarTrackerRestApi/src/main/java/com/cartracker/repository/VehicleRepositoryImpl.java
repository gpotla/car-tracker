package com.cartracker.repository;

import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public void insertVehicleInformation(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    public void updateVehicleInformation(Vehicle vehicle) {
        entityManager.merge(vehicle);
    }

    public void recordVehicleReadings(Reading reading) {
        entityManager.persist(reading);
    }

    public Vehicle findVehicleByVin(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }
}
