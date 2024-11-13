package com.cybernetic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient {

    private String id;
    private String name;
    private int age;
    private String bloodType;
    private String organNeeded;
    private int urgencyLevel;
    private LocalDate registrationDate;
    private String status;

    public Patient(String id, String name, int age, String bloodType, String organNeeded, int urgencyLevel, LocalDate registrationDate, String status) {
        setId(id);
        setName(name);
        setAge(age);
        setBloodType(bloodType);
        setOrganNeeded(organNeeded);
        setUrgencyLevel(urgencyLevel);
        setRegistrationDate(registrationDate);
        setStatus(status);
    }

    public Patient() {
        this.id = "PAT-0000";
        this.name = "Unknown";
        this.age = 1;
        this.bloodType = "O+";
        this.organNeeded = "HEART";
        this.urgencyLevel = 1;
        this.registrationDate = LocalDate.now();
        this.status = "WAITING";
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getBloodType() { return bloodType; }
    public String getOrganNeeded() { return organNeeded; }
    public int getUrgencyLevel() { return urgencyLevel; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public String getStatus() { return status; }

    public void setId(String id) {
        if (id.matches("PAT-\\d{4}")) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Patient ID format is invalid.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Patient age is invalid.");
        }
    }

    public void setBloodType(String bloodType) {
        if (bloodType.matches("A\\+|A-|B\\+|B-|AB\\+|AB-|O\\+|O-")) {
            this.bloodType = bloodType;
        } else {
            throw new IllegalArgumentException("Patient blood type is invalid.");
        }
    }

    public void setOrganNeeded(String organNeeded) {
        if (organNeeded.matches("HEART|LUNG|KIDNEY|LIVER")) {
            this.organNeeded = organNeeded;
        } else {
            throw new IllegalArgumentException("Patient organ needed is invalid.");
        }
    }

    public void setUrgencyLevel(int urgencyLevel) {
        if (urgencyLevel >= 1 && urgencyLevel <= 10) {
            this.urgencyLevel = urgencyLevel;
        } else {
            throw new IllegalArgumentException("Urgency level is invalid.");
        }
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setStatus(String status) {
        if (status.equals("WAITING") || status.equals("MATCHED") || status.equals("TRANSPLANTED")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status. Must be WAITING, MATCHED, or TRANSPLANTED.");
        }
    }
}
