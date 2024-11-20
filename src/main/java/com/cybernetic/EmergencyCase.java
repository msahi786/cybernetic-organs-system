package com.cybernetic;

import java.time.LocalDateTime;

public class EmergencyCase {
    private String caseId;
    private Patient patient;
    private int severityLevel;
    private LocalDateTime registrationTime;

    public EmergencyCase(String caseId, Patient patient, int severityLevel, LocalDateTime registrationTime) {
        this.caseId = caseId;
        this.patient = patient;
        setSeverityLevel(severityLevel);
        this.registrationTime = registrationTime;
    }

    public String getCaseId() {
        return caseId;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        if (severityLevel < 1 || severityLevel > 5) {
            throw new IllegalArgumentException("Severity level must be between 1 and 5.");
        }
        this.severityLevel = severityLevel;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public String toString() {
        return caseId + ": " + patient.getName() + " (Severity: " + severityLevel + ", Registered: " + registrationTime + ")";
    }
}

