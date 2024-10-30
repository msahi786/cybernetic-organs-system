package com.cybernetic;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Patient {
    private String id;
    private String name;
    private String bloodType;
    private int weight;
    private String hlaType;


    @Setter(AccessLevel.NONE)
    private PatientHistory history;

    public Patient(String id, String name,String bloodType, int weight, String hlaType) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
        this.history = new PatientHistory();
    }


    public void addMedicalEvent(String medicalEvent) {
        this.history.addMedicalEvent(medicalEvent);
    }

    public String removeMostRecentEvent() {
        return this.history.removeMostRecentEvent();
    }

    public String getName(){
        return name;
    }

    public PatientHistory getHistory() {
        return history;
    }
}