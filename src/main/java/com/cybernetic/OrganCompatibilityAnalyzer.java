package com.cybernetic;

import java.util.*;

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

    public int[][] createCompatibilityMatrix() {
        int[][] matrix = new int[organs.size()][patients.size() * 3]; // 3 factors: blood type, weight, HLA
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < patients.size(); j++) { // Changed to loop through patients.size()
                matrix[i][j * 3] = calculateBloodTypeCompatibility(organs.get(i).getBloodType(), patients.get(j).getBloodType());
                matrix[i][j * 3 + 1] = calculateWeightCompatibility(organs.get(i).getWeight(), patients.get(j).getWeight());
                matrix[i][j * 3 + 2] = calculateHlaCompatibility(organs.get(i).getHlaType(), patients.get(j).getHlaType()); // Corrected index
            }
        }
        return matrix;
    }

    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        // Cover exact match cases
        if (donorType.equals(recipientType)) return 100;
        // If recipient is AB+ and not exact match, compatible, otherwise incompatible
        if (recipientType.equals("AB+")) return 80;
        // Compare compatible blood types (excluding AB+, AB-, A+, and B+ which are covered by the two checks above)
        return switch (donorType) {
            case "O-" -> 80;
            case "O+" -> Set.of("A+", "B+").contains(recipientType) ? 80 : 0;
            case "A-" -> Set.of("A+", "AB-").contains(recipientType) ? 80 : 0;
            case "B-" -> Set.of("B+", "AB-").contains(recipientType) ? 80 : 0;
            default -> 0;
        };
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        double weightRatio = (double) organWeight / (patientWeight * 1000);
        int compatibilityScore = 0;
        // If between 0.6 & 1.4, +50. If between 0.8 & 1.2, another +50 for 100
        if (weightRatio >= 0.6 && weightRatio <= 1.4) compatibilityScore += 50;
        if (weightRatio >= 0.8 && weightRatio <= 1.2) compatibilityScore += 50;
        return compatibilityScore;
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

    public double[][] calculateWeightedCompatibility(double[] weights) {
        int[][] compatibilityMatrix = createCompatibilityMatrix();
        double[][] resultMatrix = new double[organs.size()][patients.size()];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                double weightedBlood = compatibilityMatrix[i][j * 3] * weights[0];
                double weightedWeight = compatibilityMatrix[i][j * 3 + 1] * weights[1];
                double weightedHla = compatibilityMatrix[i][j * 3 + 2] * weights[2];
                resultMatrix[i][j] = weightedBlood + weightedWeight + weightedHla;
            }
        }
        return resultMatrix;
    }


    public void displayMatrix(int[][] matrix) {
        System.out.println("Initial Compatibility Matrix:");
        System.out.print("    ");
        for (int i = 0; i < matrix[0].length / 3; i++) {
            for (int j = 0; j < matrix[0].length / 3; j++) {
                System.out.print("P" + (i + 1) + "  ");
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("\nO" + (i + 1) + "  ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%-" + 4 + "s", matrix[i][j]);
            }
        }
    }

    public void displayWeightMatrix(double[] weights) {
        System.out.println("\n\nWeight Matrix:");
        for (double weight : weights) {
            System.out.printf("%.2f  ", weight);
        }
        System.out.println();
    }

    public void displayWeightedMatrix(double[][] matrix) {
        System.out.println("\nFinal Weighted Compatibility Matrix:");
        System.out.print("     ");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.printf("%-" + 5 + "s", "P" + (i + 1));
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("\nO" + (i + 1) + "  ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%-" + 6 + "s", matrix[i][j]);
            }
        }
    }

}