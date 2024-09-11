package com.cybernetic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        OrganInventory inventory = new OrganInventory();
        String csvFile = "organ.csv";
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] organData = line.split(splitBy);
                CyberneticOrgan organ = new CyberneticOrgan(
                        organData[0],
                        organData[1],
                        organData[2],
                        organData[3]
                );
                inventory.addOrgan(organ);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Organ Inventory:");
        for (CyberneticOrgan organ : inventory.getOrganList()) {
            System.out.println(organ.getDetails());
        }
    }
}