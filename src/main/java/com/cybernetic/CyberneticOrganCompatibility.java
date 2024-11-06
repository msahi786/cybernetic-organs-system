package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Main compatibility checker class
public class CyberneticOrganCompatibility {
    private List<String> incompatibilityReasons;

    public CyberneticOrganCompatibility() {
        this.incompatibilityReasons = new ArrayList<>();
    }

    public boolean isCompatible(Patient patient,
                                CyberneticOrgan organ,
                                DiagnosticDecisionTree diagnosticTree) {

        incompatibilityReasons.clear();
        boolean isCompatible = true;

        // Step 1: Run diagnostic tree analysis
        String diagnosis = diagnosticTree.diagnosePatient(patient.getAllMeasurements());

        if ("Not Compatible".equals(diagnosis)) {
            incompatibilityReasons.add("Diagnostic Tree Result: Not Compatible");
            return false;
        } else if ("Inconclusive".equals(diagnosis)) {
            incompatibilityReasons.add("Diagnostic Tree Result: Inconclusive");
        }

        // Step 2: Check each measurement against organ requirements
        for (Map.Entry<String, CyberneticOrgan.Range> requirement : organ.getRequirements().entrySet()) {
            String measurementType = requirement.getKey();
            double patientValue = patient.getMeasurement(measurementType);
            CyberneticOrgan.Range range = requirement.getValue();

            // Step 3: Check each measurement against organ requirements
            if (patientValue < range.min || patientValue > range.max) {
                incompatibilityReasons.add(measurementType + " out of range: " + patientValue +
                        " (required: " + range.min + " - " + range.max + ")");
                isCompatible = false;
            }
        }

        return isCompatible;
    }

    public List<String> getIncompatibilityReasons() {
        return new ArrayList<>(incompatibilityReasons);
    }
}
