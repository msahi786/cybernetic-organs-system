package com.cybernetic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class PatientWaitingList {
    private Queue<Patient> waitingList;

    public PatientWaitingList() {
        this.waitingList = new LinkedList<>();
    }

    /**
     * Add a new patient to the end of the waiting list.
     * @param patient The patient to be added to the waiting list.
     */
    public void addPatient(Patient patient) {
        waitingList.add(patient);
    }

    /**
     * Remove and return the next patient from the front of the waiting list.
     * @return The next patient in the waiting list.
     */
    public Patient removeNextPatient() {
        return waitingList.remove();
    }

    /**
     * Check if the patient waiting list is empty.
     * @return True if the waiting list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    /**
     * Print the current state of the patient waiting list.
     */
    public void printWaitingList() {
        System.out.println("Current Waiting Queue:");
        StringJoiner queue = new StringJoiner(" <--- ");
        int position = 1;
        for (Patient patient : waitingList) {
            queue.add(position + ". [ " + patient.getName() + " ]");
            position++;
        }
        System.out.println(queue);
    }

}