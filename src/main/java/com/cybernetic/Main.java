package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create diagnostic tree with BST structure
        DiagnosticDecisionTree diagnosticTree = createDiagnosticTree();

        // Create sample patients
        List<Patient> patients = createSamplePatients();

        // Create sample organs
        List<CyberneticOrgan> organs = createSampleOrgans();

        // Create compatibility checker
        CyberneticOrganCompatibility checker = new CyberneticOrganCompatibility();

        // Test compatibility for each patient
        for (Patient patient : patients) {
            System.out.println("\n=== Testing Patient: " + patient.getName() + " ===");

            // Print patient measurements
            System.out.println("Patient Measurements:");
            patient.getAllMeasurements().forEach((key, value) ->
                    System.out.printf("- %s: %.1f%n", key, value));

            // Test with each organ
            for (CyberneticOrgan organ : organs) {
                System.out.println("\nTesting with " + organ.getType());

                // Check compatibility
                boolean isCompatible = checker.isCompatible(patient, organ, diagnosticTree);

                // Print results
                System.out.println("Compatibility: " +
                        (isCompatible ? "COMPATIBLE" : "NOT COMPATIBLE"));

                if (!isCompatible) {
                    System.out.println("Reasons for Incompatibility:");
                    checker.getIncompatibilityReasons().forEach(reason ->
                            System.out.println("- " + reason));
                }

                // Show diagnostic path (demonstrates BST traversal)
                System.out.println("\nDiagnostic Path Taken:");
                diagnosticTree.getDiagnosticPath().forEach(step ->
                        System.out.println("- " + step));
            }
        }

        // Show BST structure
        System.out.println("\n=== Diagnostic Tree Structure ===");
        diagnosticTree.printTree();
    }

    private static List<Patient> createSamplePatients() {
        List<Patient> patients = new ArrayList<>();

        // Healthy patient
        Patient healthy = new Patient("P1", "John Healthy");
        healthy.addMeasurement("Blood Pressure", 120.0);
        healthy.addMeasurement("Heart Rate", 75.0);
        healthy.addMeasurement("Oxygen Saturation", 98.0);
        patients.add(healthy);

        // Critical patient
        Patient critical = new Patient("P2", "Jane Critical");
        critical.addMeasurement("Blood Pressure", 160.0);
        critical.addMeasurement("Heart Rate", 110.0);
        critical.addMeasurement("Oxygen Saturation", 88.0);
        patients.add(critical);

        return patients;
    }

    private static List<CyberneticOrgan> createSampleOrgans() {
        List<CyberneticOrgan> organs = new ArrayList<>();

        CyberneticOrgan heart = new CyberneticOrgan("O1", "CyberHeart-X1");
        heart.addRequirement("Blood Pressure", 90.0, 140.0);
        heart.addRequirement("Heart Rate", 60.0, 100.0);
        heart.addRequirement("Oxygen Saturation", 95.0, 100.0);
        organs.add(heart);

        return organs;
    }

    private static DiagnosticDecisionTree createDiagnosticTree() {
        DiagnosticDecisionTree tree = new DiagnosticDecisionTree();

        // Build diagnostic tree using BST properties
        tree.addDiagnosticCriteria("Blood Pressure", 140.0, null);
        tree.addDiagnosticCriteria("Blood Pressure", 90.0, null);
        tree.addDiagnosticCriteria("Heart Rate", 100.0, "Compatible");
        tree.addDiagnosticCriteria("Heart Rate", 60.0, "Not Compatible");
        tree.addDiagnosticCriteria("Oxygen Saturation", 95.0, "Compatible");

        return tree;
    }
}