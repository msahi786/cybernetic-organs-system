package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiagnosticDecisionTree {
    private DiagnosticNode root;
    private List<String> diagnosticPath;

    public DiagnosticDecisionTree() {
        this.diagnosticPath = new ArrayList<>();
    }

    public List<String> getDiagnosticPath() {
        return new ArrayList<>(diagnosticPath);  // Return a copy for encapsulation
    }

    // Add a diagnostic criterion to the BST
    public void addDiagnosticCriteria(String measurementType, double threshold, String diagnosis) {
        DiagnosticNode newNode = new DiagnosticNode(measurementType, threshold, diagnosis);
        if (root == null) {
            root = newNode;
        } else {
            addNodeRecursive(root, newNode);
        }
    }

    private void addNodeRecursive(DiagnosticNode current, DiagnosticNode newNode) {
        if (newNode.getThresholdValue() < current.getThresholdValue()) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                addNodeRecursive(current.getLeft(), newNode);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                addNodeRecursive(current.getRight(), newNode);
            }
        }
    }

    // Diagnose a patient by traversing the tree based on their measurements
    public String diagnosePatient(Map<String, Double> measurements) {
        diagnosticPath.clear();  // Clear previous diagnostic path
        return diagnosePatientRecursive(root, measurements);
    }

    private String diagnosePatientRecursive(DiagnosticNode node, Map<String, Double> measurements) {
        if (node == null) return "Unknown";

        String measurementType = node.getMeasurementType();
        Double patientValue = measurements.get(measurementType);

        if (patientValue == null) {
            diagnosticPath.add("No measurement for " + measurementType);
            return "Inconclusive";
        }

        diagnosticPath.add(measurementType + " = " + patientValue + (patientValue < node.getThresholdValue() ? " < " : " ≥ ") + node.getThresholdValue());

        if (node.getDiagnosis() != null) {
            return node.getDiagnosis();  // Leaf node with diagnosis
        }

        return patientValue < node.getThresholdValue()
                ? diagnosePatientRecursive(node.getLeft(), measurements)
                : diagnosePatientRecursive(node.getRight(), measurements);
    }

    // Print the diagnostic tree structure with proper indentation
    public void printTree() {
        System.out.println("\nDiagnostic Tree Structure:");
        printTreeRec(root, "", true);
    }

    private void printTreeRec(DiagnosticNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getMeasurementType() + " (" + node.getThresholdValue() + ")" + (node.getDiagnosis() != null ? " -> " + node.getDiagnosis() : ""));
            printTreeRec(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            printTreeRec(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
