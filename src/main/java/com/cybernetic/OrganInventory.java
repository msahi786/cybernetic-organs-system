package com.cybernetic;

import java.util.ArrayList;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> inventory;

    public OrganInventory() {
        inventory = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
        System.out.println("Organ added: " + organ.getDetails());
    }

    public CyberneticOrgan getOrgan(String model) {
        for (CyberneticOrgan organ : inventory) {
            if (organ.getDetails().contains(model)) {
                return organ;
            }
        }
        return null;
    }
}
