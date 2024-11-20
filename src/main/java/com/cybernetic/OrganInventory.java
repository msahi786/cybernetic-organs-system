package com.cybernetic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize all components
        TransplantHistory transplantHistory = new TransplantHistory();
        SystemOperationsLog operationsLog = new SystemOperationsLog(100);
        EmergencyWaitlist emergencyWaitlist = new EmergencyWaitlist();

        System.out.println("Part 2 - Advanced Data Structures Demo");
        System.out.println("====================================\n");

        // 1. Demonstrate Transplant History
        System.out.println("1. Transplant History Operations");
        System.out.println("------------------------------");
        System.out.println("Adding transplant records...");

        transplantHistory.addTransplantRecordAtBeginning(
                new TransplantRecord("TR-001", "PAT-001", "ORG-001", "Dr. Smith", "Success")
        );
        System.out.println("Added: TR-001 (PAT-001, ORG-001, Success)");

        transplantHistory.addTransplantRecordAtBeginning(
                new TransplantRecord("TR-002", "PAT-002", "ORG-003", "Dr. Johnson", "Success")
        );
        System.out.println("Added: TR-002 (PAT-002, ORG-003, Success)");

        transplantHistory.addTransplantRecordAtBeginning(
                new TransplantRecord("TR-003", "PAT-003", "ORG-002", "Dr. Brown", "Pending")
        );
        System.out.println("Added: TR-003 (PAT-003, ORG-002, Pending)");

        System.out.println("\nRecent Transplants (Last 2):");
        List<TransplantRecord> recentTransplants = transplantHistory.getRecentTransplants(2);
        for (int i = 0; i < recentTransplants.size(); i++) {
            System.out.println((i + 1) + ". " + recentTransplants.get(i));
        }

        // 2. Demonstrate System Operations Log
        System.out.println("\n2. System Operations Log");
        System.out.println("----------------------");
        System.out.println("Pushing operations...");

        operationsLog.pushOperation(
                new SystemOperation("MATCH-001", "Organ-Patient Match",
                        "Matched ORG-001 with PAT-002", true)
        );
        System.out.println("PUSH: MATCH-001 (Organ-Patient Match)");

        operationsLog.pushOperation(
                new SystemOperation("TRANSPLANT-001", "Schedule Transplant",
                        "Scheduled transplant for PAT-002", true)
        );
        System.out.println("PUSH: TRANSPLANT-001 (Schedule Transplant)");

        operationsLog.pushOperation(
                new SystemOperation("EMERGENCY-001", "Emergency Case",
                        "New emergency case for PAT-003", false)
        );
        System.out.println("PUSH: EMERGENCY-001 (Emergency Case)");

        System.out.println("\nRecent Operations:");
        List<SystemOperation> recentOps = operationsLog.getRecentOperations(3);
        for (int i = 0; i < recentOps.size(); i++) {
            System.out.println((i + 1) + ". " + recentOps.get(i) + (i == 0 ? " (Latest)" : ""));
        }

        System.out.println("\nUndoing last operation...");
        SystemOperation poppedOp = operationsLog.popLastOperation();
        System.out.println("Popped: " + poppedOp.getOperationId());
        System.out.println("Current top: " + operationsLog.peekLastOperation().getOperationId());

        // 3. Demonstrate Emergency Waitlist
        System.out.println("\n3. Emergency Waitlist");
        System.out.println("-------------------");
        System.out.println("Adding emergency cases...");

        // Create sample patients with all required attributes
        Patient patient1 = new Patient(
                "PAT-001",
                "John Doe",
                45,
                "A+",
                "HEART",
                8,
                LocalDate.now().minusMonths(2),
                "WAITING"
        );

        Patient patient2 = new Patient(
                "PAT-002",
                "Jane Smith",
                52,
                "B-",
                "LUNG",
                7,
                LocalDate.now().minusMonths(1),
                "WAITING"
        );

        Patient patient3 = new Patient(
                "PAT-003",
                "Bob Wilson",
                63,
                "O+",
                "KIDNEY",
                9,
                LocalDate.now().minusDays(15),
                "WAITING"
        );

        // Create emergency cases with specific registration times
        EmergencyCase case1 = new EmergencyCase("EMERG-001",
                patient1,
                5,
                LocalDateTime.now().minusMinutes(45)  // Registered 45 minutes ago
        );
        emergencyWaitlist.addEmergencyCase(case1);
        System.out.println("Added: EMERG-001 (Severity: 5)");

        EmergencyCase case2 = new EmergencyCase("EMERG-002",
                patient2,
                3,
                LocalDateTime.now().minusMinutes(30)  // Registered 30 minutes ago
        );
        emergencyWaitlist.addEmergencyCase(case2);
        System.out.println("Added: EMERG-002 (Severity: 3)");

        EmergencyCase case3 = new EmergencyCase("EMERG-003",
                patient3,
                5,
                LocalDateTime.now().minusMinutes(15)  // Registered 15 minutes ago
        );
        emergencyWaitlist.addEmergencyCase(case3);
        System.out.println("Added: EMERG-003 (Severity: 5)");

        System.out.println("\nNext urgent case:");
        EmergencyCase nextCase = emergencyWaitlist.getNextUrgentCase();
        System.out.println(nextCase);

        System.out.println("\nUpdated EMERG-002 severity to 5");
        emergencyWaitlist.updateCaseSeverity("EMERG-002", 5);

        System.out.println("New urgent case order:");
        EmergencyCase caseX;
        int count = 1;
        while ((
                caseX = emergencyWaitlist.getNextUrgentCase()) != null) {
            System.out.println(count++ + ". " + caseX);
        }

        // System Status Summary
        System.out.println("\n4. System Status Summary");
        System.out.println("----------------------");
        System.out.println("Total transplant records: " + transplantHistory.getRecentTransplants(100).size());
        System.out.println("Operations in log: " + operationsLog.getRecentOperations(100).size());
        System.out.println("Emergency cases handled: " + (count - 1));
    }
}