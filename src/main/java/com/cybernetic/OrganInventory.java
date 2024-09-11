package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> inventory = new ArrayList<>();


    public String addOrgan(CyberneticOrgan organ) {
        inventory.add(organ);
        return "Organ Added";
    }

    public CyberneticOrgan getOrgan(String model) {
        for (CyberneticOrgan organ : inventory) {
            if (organ.getDetails().contains(model)) {
                return organ;
            }
        }
        return null;
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        return inventory;
    }

    public String removeOrgan(String model) {
        for (CyberneticOrgan organ : inventory) {
            if (organ.getDetails().contains(model)) {
                inventory.remove(organ);
                return "Organ Removed";
            }
        }
        return "Organ Not Found";
    }

    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality) {
        ArrayList<CyberneticOrgan> matchingOrgans = new ArrayList<>();
        for (CyberneticOrgan organ : inventory) {
            if (organ.getDetails().contains(functionality)) {
                matchingOrgans.add(organ);
            }
        }
        return matchingOrgans;
    }

    public ArrayList<CyberneticOrgan> sortOrgansByModel() {
        Collections.sort(inventory, (o1, o2) -> o1.getModel().compareTo(o2.getModel()));


        return inventory;
    }

}

