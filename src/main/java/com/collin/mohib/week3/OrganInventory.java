package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;

public class OrganInventory {
    private final List<com.cybernetic.Organ> inventory;

    public OrganInventory() {
        this.inventory = new ArrayList<>();
    }

    public String addOrgan(Organ organ) {
        inventory.add(organ);
        return "Organ added: " + organ.getDetails(); // Enhanced return message
    }

    public Optional<String> removeOrgan(String model) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getModel().equalsIgnoreCase(model)) {
                inventory.remove(i);
                return Optional.of("Organ removed: " + model); // Enhanced return message
            }
        }
        return Optional.empty(); // Indicate that the organ was not found
    }

    public List<Organ> searchOrganByFunctionality(String functionality) {
        List<Organ> result = new ArrayList<>();
        for (Organ organ : inventory) {
            if (organ.getFunctionality().equalsIgnoreCase(functionality)) {
                result.add(organ);
            }
        }
        return result;
    }

    public List<Organ> sortOrganByModel() {
        Collections.sort(inventory, Comparator.comparing(Organ::getModel)); // Improved sorting
        return inventory;
    }

    public String getOrganList() {
        return String.join(", ", inventory.stream()
                .map(Organ::getModel)
                .toArray(String[]::new)); // Improved string handling
    }
}
