package com.cybernetic;

import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class EmergencyWaitlist {
    private PriorityQueue<EmergencyCase> emergencyQueue;
    private TreeMap<String, EmergencyCase> bstIndex;

    public EmergencyWaitlist() {
        this.emergencyQueue = new PriorityQueue<>((c1, c2) -> {
            if (c1.getSeverityLevel() != c2.getSeverityLevel()) {
                return Integer.compare(c2.getSeverityLevel(), c1.getSeverityLevel());
            }
            return c1.getRegistrationTime().compareTo(c2.getRegistrationTime());
        });
        this.bstIndex = new TreeMap<>();
    }

    public void addEmergencyCase(EmergencyCase emergencyCase) {
        if (bstIndex.containsKey(emergencyCase.getCaseId())) {
            throw new IllegalArgumentException("Case ID must be unique: " + emergencyCase.getCaseId());
        }
        emergencyQueue.add(emergencyCase);
        bstIndex.put(emergencyCase.getCaseId(), emergencyCase);
    }

    public EmergencyCase getNextUrgentCase() {
        if (emergencyQueue.isEmpty()) {
            throw new IllegalStateException("No emergency cases available.");
        }
        EmergencyCase nextCase = emergencyQueue.poll();
        bstIndex.remove(nextCase.getCaseId());
        return nextCase;
    }

    public void updateCaseSeverity(String caseId, int newLevel) {
        EmergencyCase emergencyCase = bstIndex.get(caseId);
        if (emergencyCase == null) {
            throw new IllegalArgumentException("Case ID not found: " + caseId);
        }

        // Remove and reinsert to reflect updated priority
        emergencyQueue.remove(emergencyCase);
        emergencyCase.setSeverityLevel(newLevel);
        emergencyQueue.add(emergencyCase);
    }

    public EmergencyCase findCaseById(String caseId) {
        return bstIndex.get(caseId);
    }

    public EmergencyCase[] getAllCasesBySeverity(int severityLevel) {
        return emergencyQueue.stream()
                .filter(caseObj -> caseObj.getSeverityLevel() == severityLevel)
                .toArray(EmergencyCase[]::new);
    }

    public void displayAllCases() {
        System.out.println("Emergency Cases in Queue:");
        emergencyQueue.forEach(System.out::println);
    }
}

