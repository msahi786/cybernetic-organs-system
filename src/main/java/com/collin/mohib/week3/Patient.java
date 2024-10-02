package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private final String name;
    private int age;
    private String medicalHistory;
    private Organ[] installedOrgans;
    private int organCount;

    public Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.installedOrgans = new Organ[5];
        this.organCount = 0;
    }

    public String getName() {
        return name;
    }

    public String addOrgan(Organ organ) {
        if (organCount < installedOrgans.length) {
            installedOrgans[organCount++] = organ;
            return "Organ added: " + organ.getDetails();
        } else {
            return "No space available to add more organs.";
        }
    }

    public List<Organ> getOrganList() {
        List<Organ> organList = new ArrayList<>();
        for (int i = 0; i < organCount; i++) {
            organList.add(installedOrgans[i]);
        }
        return organList;

    }

    public String getPatientInfo() {
        StringBuilder info = new StringBuilder("Name: " + name + ", Age: " + age + ", Medical History: " + medicalHistory + ", Installed Organs: ");
        if (organCount == 0) {
            info.append("None");
        } else {
            for (int i = 0; i < organCount; i++) {
                info.append("\n").append(installedOrgans[i].getDetails());
            }
        }
        return info.toString();
    }
}