package com.cartracker.entity;

import com.cartracker.DTO.HighAlerts;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/*@SqlResultSetMapping(name="NumberOfHighAlerts",
        entities={
                @EntityResult(entityClass=Vehicle.class, fields={
                        @FieldResult(name="vin", column="vin"),
                        @FieldResult(name="lastServiceDate", column="lastServiceDate"),
                        @FieldResult(name="make", column="make"),
                        @FieldResult(name="maxFuelVolume", column="maxFuelVolume"),
                        @FieldResult(name="model", column="model"),
                        @FieldResult(name="redlineRpm", column="redlineRpm"),
                        @FieldResult(name="year", column="year")})},
        columns={
                @ColumnResult(name="numberOfHighAlerts")}
)*/


@SqlResultSetMapping(name="NumberOfHighAlerts",
        classes = {
                @ConstructorResult(targetClass = HighAlerts.class,
                        columns = {@ColumnResult(name="vin"), @ColumnResult(name="make"),
                                   @ColumnResult(name="model"), @ColumnResult(name="numberOfHighAlerts")}
                )}
)
@Entity
public class Alert {

    @Id
    @Column(columnDefinition = "VARCHAR(50)")
    private String alertId;
    @Column(columnDefinition = "VARCHAR(50)")
    private String alertType;
    @Column(columnDefinition = "VARCHAR(50)")
    private String readingId;
    @Column(columnDefinition = "VARCHAR(75)")
    private String message;
    @OneToMany
    private List<Reading> reading;

    public Alert(){
        this.alertId = UUID.randomUUID().toString();
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getReadingId() {
        return readingId;
    }

    public void setReadingId(String readingId) {
        this.readingId = readingId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
