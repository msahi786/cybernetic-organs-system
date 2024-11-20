package com.cybernetic;

import java.time.LocalDateTime;

public class SystemOperation {
    String operationId;
    String operationType;
    LocalDateTime timestamp;
    String description;
    boolean isReversible;

    public SystemOperation(String operationId, String operationType, String description, boolean isReversible) {
        this.operationId = operationId;
        this.operationType = operationType;
        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.isReversible = isReversible;
    }

    public String toString() {
        return operationId + ": " + description;
    }

}

