package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private List<CyberneticOrgan> installedOrgans;

    public Patient(String name, int age, String medicalHistory){
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.installedOrgans = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        installedOrgans.add(organ);
        System.out.println("Organ added: " + organ.getDetails());
    }

    public String getPatientInfo() {
        return "Name: " + name + ", Age: " + age + ", Medical History: " + medicalHistory + ", organs installed: " + installedOrgans.size();

    }
}
