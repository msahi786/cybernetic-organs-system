package com.cybernetic;

import java.time.LocalDateTime;

public class TransplantRecord {
    String operationId;
    String patientId;
    String organId;
    LocalDateTime timestamp;
    String surgeon;
    String outcome;
    TransplantRecord next;

    public TransplantRecord(String operationId, String patientId, String organId, String surgeon, String outcome) {
        this.operationId = operationId;
        this.patientId = patientId;
        this.organId = organId;
        this.timestamp = LocalDateTime.now();
        this.surgeon = surgeon;
        this.outcome = outcome;
    }

    public String toString() {
        return operationId + ": " + patientId + " (" + outcome + ")";
    }
}
