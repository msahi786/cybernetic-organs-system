package com.cybernetic;


public class Main {
    public static void main(String[] args) {

        Patient johnDoe = new Patient("P001", "John Doe", "A+", 70, "HLA-A");
        Patient janeSmith = new Patient("P002", "Jane Smith", "B-", 65, "HLA-B");
        Patient bobJohnson = new Patient("P003", "Bob Johnson", "O+", 80, "HLA-A");
        Patient aliceBrown = new Patient("P004", "Alice Brown", "AB-", 55, "HLA-C");

        // Create patient waiting list
        PatientWaitingList waitingList = new PatientWaitingList();

        // Add patients to the waiting list
        waitingList.addPatient(aliceBrown);
        waitingList.addPatient(bobJohnson);
        waitingList.addPatient(janeSmith);
        waitingList.addPatient(johnDoe);

        // Print waiting list
        waitingList.printWaitingList();


        // Add medical events to the patients
        String[] events = {"Annual checkup","Flu vaccination","Broken arm surgery"};
        System.out.println("\nAdding medical event to Alice's history: ");
        for (String event : events) {
            System.out.println("- " + event);
            aliceBrown.addMedicalEvent(event);
        }

        // View and remove the latest medical event from Alice's history
        System.out.println("\nViewing Alice's latest medical event: " + aliceBrown.getHistory().viewLatestEvent());
        System.out.println("Removing Alice's latest medical event: " + aliceBrown.removeMostRecentEvent());



        // Create an organ
        Organ cyberHeart = new Organ("O001", "CyberHeart-X1", "A+", 350, "HLA-A");

        Patient nextPatient = waitingList.removeNextPatient();
        System.out.println("\nProcessing the next patient for CyberHeart-X1 transplant:");
        System.out.println("Matched CyberHeart-X1 to " + nextPatient.getName());

        System.out.println("\nChecking " + nextPatient.getName() + "'s medical history for compatibility:");
        while (!nextPatient.getHistory().isEmpty()) {
            System.out.println("- " + nextPatient.getHistory().removeMostRecentEvent());
        }

        System.out.println("\n" + nextPatient.getName() + " is compatible with "+cyberHeart.getName()+"!\n");

        waitingList.printWaitingList();
    }
}