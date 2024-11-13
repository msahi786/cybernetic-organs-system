package com.cybernetic;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class CyberneticOrgan {
    private String id;
    private String type;
    private String model;
    private int powerLevel;
    private double compatibilityScore;
    private LocalDate manufactureDate;
    private String status;
    private String manufacturer;

    public CyberneticOrgan(String id, String type, String model, int powerLevel, double compatibilityScore, LocalDate manufactureDate, String status, String manufacturer) {
        validateOrgan(id, type, model, powerLevel, compatibilityScore, manufactureDate, status);

        this.id = id;
        this.type = type;
        this.model = model;
        this.powerLevel = powerLevel;
        this.compatibilityScore = compatibilityScore;
        this.manufactureDate = manufactureDate;
        this.status = status;
        this.manufacturer = manufacturer;
    }

    private void validateOrgan(String id, String type, String model, int powerLevel, double compatibilityScore, LocalDate manufactureDate, String status) {
        if (!id.matches("ORG-\\d{4}")) throw new IllegalArgumentException("ID format is invalid.");
        if (!type.matches("HEART|LUNG|KIDNEY|LIVER")) throw new IllegalArgumentException("Invalid organ type.");
        if (!model.matches(type + "X-\\d+")) throw new IllegalArgumentException("Model format is invalid.");
        if (powerLevel < 1 || powerLevel > 100) throw new IllegalArgumentException("Power level is out of range.");
        if (compatibilityScore < 0.0 || compatibilityScore > 1.0) throw new IllegalArgumentException("Compatibility score is out of range.");
        if (manufactureDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Manufacture date cannot be in the future.");
        if (!status.matches("AVAILABLE|ALLOCATED|DEFECTIVE")) throw new IllegalArgumentException("Invalid status.");
    }

    // Getters for sorting and data access
    public String getId() { return id; }
    public int getPowerLevel() { return powerLevel; }
    public LocalDate getManufactureDate() { return manufactureDate; }
    public double getCompatibilityScore() { return compatibilityScore; }
}
