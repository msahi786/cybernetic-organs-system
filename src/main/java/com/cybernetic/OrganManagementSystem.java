package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrganManagementSystem {
    private List<Organ> organs;
    private List<Patient> patients;

    public OrganManagementSystem(List<Organ> organs, List<Patient> patients) {
        this.organs = organs;
        this.patients = patients;
    }

    public Set<String> getUniqueBloodTypes() {
        Set<String> uniqueBloodTypes = new HashSet<>();
        organs.forEach(organ -> uniqueBloodTypes.add(organ.getBloodType()));
        patients.forEach(patient -> uniqueBloodTypes.add(patient.getBloodType()));
        return uniqueBloodTypes;
    }

    public Map<String, List<Patient>> groupPatientsByBloodType() {
        return patients.stream().collect(Collectors.groupingBy(Patient::getBloodType));
    }

    public List<Organ> sortOrgansByWeight() {
        return organs.stream()
                .sorted(Comparator.comparingInt(Organ::getWeight))
                .collect(Collectors.toList());
    }

    public List<Organ> getTopCompatibleOrgans(Patient patient, int n) {
        OrganCompatibilityAnalyzer analyzer = new OrganCompatibilityAnalyzer();
        organs.forEach(analyzer::addOrgan);  // Adding organs to analyzer

        return organs.stream()
                .sorted((organ1, organ2) -> {
                    double score1 = analyzer.calculateCompatibilityScore(organ1, patient);
                    double score2 = analyzer.calculateCompatibilityScore(organ2, patient);
                    return Double.compare(score2, score1);  // Sort by highest score first
                })
                .limit(n)
                .collect(Collectors.toList());
    }
}