package com.cybernetic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransplantHistory {

    private TransplantRecord head;

    public void addTransplantRecordAtBeginning(TransplantRecord record) {
        record.next = head;
        head = record;
    }

    public void addTransplantRecordAtEnd(TransplantRecord record) {
        if (head == null) {
            head = record;
        } else {
            TransplantRecord current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = record;
        }
    }

    public TransplantRecord findTransplantByPatient(String patientId) {
        TransplantRecord current = head;
        while (current != null) {
            if (current.patientId.equals(patientId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public List<TransplantRecord> getRecentTransplants(int count) {
        List<TransplantRecord> result = new ArrayList<>();
        TransplantRecord current = head;
        while (current != null && count > 0) {
            result.add(current);
            current = current.next;
            count--;
        }
        return result;
    }

    public List<TransplantRecord> getAllTransplantsByDate(LocalDate date) {
        List<TransplantRecord> result = new ArrayList<>();
        TransplantRecord current = head;
        while (current != null) {
            if (current.timestamp.toLocalDate().equals(date)) {
                result.add(current);
            }
            current = current.next;
        }
        return result;
    }

    public TransplantRecord searchRecord(String operationId) {
        TransplantRecord current = head;
        while (current != null) {
            if (current.operationId.equals(operationId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean deleteRecord(String operationId) {
        if (head == null) {
            return false; // List is empty
        }

        if (head.operationId.equals(operationId)) {
            head = head.next; // Delete the head
            return true;
        }

        TransplantRecord current = head;
        while (current.next != null) {
            if (current.next.operationId.equals(operationId)) {
                current.next = current.next.next; // Bypass the deleted node
                return true;
            }
            current = current.next;
        }
        return false; // Record not found
    }
}
