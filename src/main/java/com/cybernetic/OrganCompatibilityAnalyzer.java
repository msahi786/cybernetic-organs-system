package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganCompatibilityAnalyzer {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganCompatibilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addOrgan(Organ organ) {
        organs.add(organ);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Organ> getCompatibleOrgans(Patient patient) {
        return organs.stream()
                .filter(organ -> isCompatible(organ, patient))
                .collect(Collectors.toList());
    }

    private boolean isCompatible(Organ organ, Patient patient) {
        return calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType()) > 0 &&
                calculateWeightCompatibility(organ.getWeight(), patient.getWeight()) > 0;
    }

    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        if (donorType.equals(recipientType)) return 100;
        if (recipientType.equals("AB+")) return 80;
        return 0;
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        double weightRatio = (double) organWeight / (patientWeight * 1000);
        if (weightRatio >= 0.8 && weightRatio <= 1.2) return 100;
        return 0;
    }

    public Map<Patient, List<Double>> calculateCompatibilityScores() {
        return patients.stream()
                .collect(Collectors.toMap(
                        patient -> patient,
                        patient -> organs.stream()
                                .map(organ -> calculateCompatibilityScore(organ, patient))
                                .collect(Collectors.toList())
                ));
    }

    public double calculateCompatibilityScore(Organ organ, Patient patient) {
        double bloodCompatibility = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType()) * 0.4;
        double weightCompatibility = calculateWeightCompatibility(organ.getWeight(), patient.getWeight()) * 0.3;
        double hlaCompatibility = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType()) * 0.3;
        return bloodCompatibility + weightCompatibility + hlaCompatibility;
    }

    private int calculateHlaCompatibility(String organHla, String patientHla) {
        String[] organHlaNumbers = organHla.split("-");
        String[] patientHlaNumbers = patientHla.split("-");
        int matchedNumbers = 0;
        for (int i = 0; i < organHlaNumbers.length; i++) {
            if (organHlaNumbers[i].equals(patientHlaNumbers[i])) matchedNumbers++;
        }
        return (int) ((double) matchedNumbers / organHlaNumbers.length * 100);
    }
}
