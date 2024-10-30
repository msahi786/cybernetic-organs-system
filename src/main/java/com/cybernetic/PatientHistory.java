package com.cybernetic;

import java.util.Stack;

public class PatientHistory {
    private Stack<String> medicalHistory;

    public PatientHistory() {
        this.medicalHistory = new Stack<>();
    }


    /**
     * Add a new medical event to the patient's history.
     * @param event The medical event to be added.
     */
    public void addMedicalEvent(String event) {
        medicalHistory.push(event);
    }

    /**
     * View the most recent medical event without removing it from the stack.
     * @return The most recent medical event.
     */
    public String viewLatestEvent() {
        return medicalHistory.peek();
    }

    /**
     * Remove and return the most recent medical event from the stack.
     * @return The most recent medical event.
     */
    public String removeMostRecentEvent() {
        return medicalHistory.pop();
    }

    /**
     * Check if the patient's medical history is empty.
     * @return True if the medical history is empty, false otherwise.
     */
    public boolean isEmpty() {
        return medicalHistory.isEmpty();
    }
}