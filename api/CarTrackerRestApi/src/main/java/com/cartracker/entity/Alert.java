package com.cartracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

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
