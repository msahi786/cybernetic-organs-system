package com.cybernetic;

public class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private CyberneticOrgan[] installedOrgans = new CyberneticOrgan[5];
    private int organCount = 0;

    public Patient(String name, int age, String medicalHistory){
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;

    }

    public String addOrgan(CyberneticOrgan organ) {
        if (organCount < installedOrgans.length) {
            installedOrgans[organCount++] = organ;
            return "Organ Added";
        }

        else {
            return " No More Organs";
        }

    }

    public String getPatientInfo() {
        StringBuilder info = new StringBuilder("Name: " + name + ", Age: " + age + ", Medical History: " + medicalHistory + "\nInstalled Organs:\n");
        for (CyberneticOrgan organ : installedOrgans) {
            if (organ != null) {
                info.append(organ.getDetails()).append("\n");
            }
        }

        return info.toString();
    }
}
