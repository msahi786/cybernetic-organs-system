package com.cybernetic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of OrganInventory and add organs
        System.out.println("Adding organs to inventory...");

        // build the organ inventory from buildOrganInventory method then add the organs to the inventory
        List<Organ> organs = buildOrganInventory();
        OrganInventory inventory = new OrganInventory();
        for (Organ organ : organs) {
            inventory.addOrgan(organ);
        }

        System.out.println("Sorting inventory by name, model, and compatibility...Using Collection.sort");
        long startTime = System.nanoTime();
        List<Organ> sortedOrgans = inventory.sortOrganByNameModelAndCompatibilityUsingBuiltInSort();
        System.out.println("Time taken to sort using collection.sort: " + (System.nanoTime() - startTime) + "ns");

        System.out.println("Sorting inventory by name, model, and compatibility...Using QuickSort");
        startTime = System.nanoTime();
        sortedOrgans = inventory.quickSortOrganByNameModelAndCompatibility(inventory.getOrganList());
        System.out.println("Time taken to sort using quicksort: " + (System.nanoTime() - startTime) + "ns");
        //Then write the sorted inventory to the new csv file.
        writeOrganInventory(sortedOrgans);

        System.out.println("Sorted inventory written to file.");


    }

    private static void writeOrganInventory(List<Organ> sortedOrgans) {
        //write the sorted inventory to a new csv file
        String csvFile = "src/main/resources/sorted-organ-list.csv";
        try (PrintWriter writer = new PrintWriter(csvFile)) {
            writer.write("Model,Name,Functionality,Compatibility\n");
            for (Organ organ : sortedOrgans) {
                //write in this order name,model,functionality,compatibility
                writer.write(organ.getName() + "," + organ.getModel() + "," + organ.getFunctionality() + "," + organ.getCompatibility() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<Organ> buildOrganInventory() {
        //read the csv file
        String csvFile = "src/main/resources/sample-organ-list.csv";
        String line;
        String cvsSplitBy = ",";
        List<Organ> inventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip the header
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] organ= line.split(cvsSplitBy);
                Organ newOrgan = new Organ( organ[1].trim(),organ[0].trim(), organ[2].trim(),organ[3].trim());
                inventory.add(newOrgan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }
}