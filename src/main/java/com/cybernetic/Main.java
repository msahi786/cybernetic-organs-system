package com.cybernetic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Organ> organs = Arrays.asList(
                new Organ("H1", "Heart", "A+", 300, generateRandomHLAType()),
                new Organ("K1", "Kidney", "B-", 150, generateRandomHLAType()),
                new Organ("L1", "Liver", "O+", 1500, generateRandomHLAType())
        );

        List<Patient> patients = Arrays.asList(
                new Patient("P1", "John Doe", "A+", 70, generateRandomHLAType()),
                new Patient("P2", "Jane Smith", "B-", 65, generateRandomHLAType()),
                new Patient("P3", "Bob Johnson", "O+", 80, generateRandomHLAType())
        );

        OrganManagementSystem system = new OrganManagementSystem(organs, patients);
        OrganCompatibilityAnalyzer analyzer = new OrganCompatibilityAnalyzer();
        organs.forEach(analyzer::addOrgan);
        patients.forEach(analyzer::addPatient);

        // Output as per assignment requirements
        System.out.println("Available Organs:");
        organs.forEach(o -> System.out.println(o.getId() + ". " + o.getName() + " (" + o.getBloodType() + ", " + o.getWeight() + "g)"));

        System.out.println("\nPatients:");
        patients.forEach(p -> System.out.println(p.getId() + ". " + p.getName() + " (" + p.getBloodType() + ", " + p.getWeight() + "kg)"));

        System.out.println("\nUnique Blood Types: " + system.getUniqueBloodTypes());

        System.out.println("\nPatients Grouped by Blood Type:");
        system.groupPatientsByBloodType().forEach((bloodType, patientList) ->
                System.out.println(bloodType + ": " + patientList.stream().map(Patient::getName).collect(Collectors.toList())));

        System.out.println("\nOrgans Sorted by Weight:");
        system.sortOrgansByWeight().forEach(o ->
                System.out.println(o.getName() + " (" + o.getBloodType() + ", " + o.getWeight() + "g)"));

        System.out.println("\nCompatibility Scores:");
        Map<Patient, List<Double>> scores = analyzer.calculateCompatibilityScores();
        scores.forEach((patient, scoreList) -> {
            for (int i = 0; i < organs.size(); i++) {
                System.out.println(patient.getName() + " - " + organs.get(i).getName() + ": " + String.format("%.2f", scoreList.get(i)));
            }
        });

        Patient patient = patients.get(0);
        System.out.println("\nTop 3 Compatible Organs for: "+patient.getName());
        List<Organ> topOrgans = system.getTopCompatibleOrgans(patient, 3);
        for (int i = 0; i < topOrgans.size(); i++) {
            Organ organ = topOrgans.get(i);
            double score = analyzer.calculateCompatibilityScore(organ, patient);
            System.out.println((i+1) + ". " + organ.getName() + " (" + organ.getBloodType() + ", " + organ.getWeight() + "g) - Score: " + String.format("%.2f", score));
        }
    }

    private static String generateRandomHLAType() {
        Random random = new Random();
        return random.ints(1, 10)
                .limit(6)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("-"));
    }
}