package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.util.Scanner;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> organs;
    private int maxCapacity = 1000;

    public OrganInventory() {
        this.organs = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        if (organs.size() >= maxCapacity) throw new IllegalStateException("Inventory is full.");
        for (CyberneticOrgan o : organs) {
            if (o.getId().equals(organ.getId())) throw new IllegalArgumentException("Organ ID must be unique.");
        }
        organs.add(organ);
    }

    public void removeOrgan(String id, String reason) {
        CyberneticOrgan organ = organs.stream()
                .filter(o -> o.getId().equals(id) && o.getStatus().equals("AVAILABLE"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Organ not available for removal."));
        organs.remove(organ);
        System.out.println("Removed organ: " + organ.getId() + " for reason: " + reason);
    }

    public ArrayList<CyberneticOrgan> sortByPowerLevel() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        quickSortByPower(sorted, 0, sorted.size() - 1);
        return sorted;
    }

    private void quickSortByPower(ArrayList<CyberneticOrgan> list, int low, int high) {
        if (low < high) {
            int pi = partitionByPower(list, low, high);
            quickSortByPower(list, low, pi - 1);
            quickSortByPower(list, pi + 1, high);
        }
    }

    private int partitionByPower(ArrayList<CyberneticOrgan> list, int low, int high) {
        int pivot = list.get(high).getPowerLevel();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).getPowerLevel() >= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    public ArrayList<CyberneticOrgan> sortByManufactureDate() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        // Implement mergeSort
        return sorted;
    }

    public ArrayList<CyberneticOrgan> sortByCompatibilityScore() {
        ArrayList<CyberneticOrgan> sorted = new ArrayList<>(organs);
        // Implement bubbleSort
        return sorted;
    }
}
