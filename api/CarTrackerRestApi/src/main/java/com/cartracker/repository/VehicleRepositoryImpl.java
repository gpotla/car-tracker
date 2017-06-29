package com.cartracker.repository;

import com.cartracker.entity.Alert;
import com.cartracker.DTO.HighAlerts;
import com.cartracker.entity.Reading;
import com.cartracker.entity.Vehicle;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public void createAlert(Alert alert) {
        entityManager.persist(alert);
    }

    public List<HighAlerts> listOfHighAlerts() {

        /*Query query = entityManager.createNativeQuery("SELECT v.vin as vin, v.lastServiceDate as lastServiceDate, v.make as make, v.maxFuelVolume as maxFuelvolume, " +
                "v.model as model, v.redLineRpm as redlineRpm, v.year as year, count(a.alertType) as numberOfHighAlerts\n" +
                "FROM Vehicle v left outer join Reading  r on v.vin = r.vin left outer join Alert a on r.readingId = a.readingId\n" +
                "WHERE a.alertType = 'High' AND timestampdiff(hour, r.timestamp, UTC_TIMESTAMP()) >= 2\n" +
                "GROUP BY v.vin, v.make, v.model\n" +
                "ORDER BY numberOfHighAlerts", "NumberOfHighAlerts");*/

        Query query = entityManager.createNativeQuery("SELECT Vehicle.vin as vin, Vehicle.make as make, Vehicle.model as model, count(Alert.alertType) as numberOfHighAlerts\n" +
                "FROM Vehicle left outer join Reading on Vehicle.vin = Reading.vin left outer join Alert on Reading.readingId = Alert.readingId\n" +
                "WHERE Alert.alertType = 'High' and timestampdiff(hour, Reading.timestamp, UTC_TIMESTAMP()) <= 2\n" +
                "GROUP BY Vehicle.vin, Vehicle.make, Vehicle.model\n" +
                "ORDER BY numberOfHighAlerts;", "NumberOfHighAlerts");

        System.out.println(query.getResultList().size());
        List<HighAlerts> result = query.getResultList();

        return result;
    }

    public List<Vehicle> listOfVehicles() {

        // To be implement named query
        //TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.listAllVehicles",Vehicle.class);
        //TypedQuery<Vehicle> query = entityManager.createQuery("SELECT vehicle FROM Vehicle vehicle", Vehicle.class);
        Query query = entityManager.createNativeQuery("select * from vehicle", Vehicle.class);
        return query.getResultList();

    }

    public List<Reading> vehicleReadingsHistory(String vin, int specifiedTime) {
        // To be implement named query
        Query query = entityManager.createNativeQuery("select * from reading r\n" +
                "where timestampdiff(minute, r.timestamp, UTC_TIMESTAMP()) <="+specifiedTime, Reading.class);
        return query.getResultList();
    }




}
