package com.cybernetic;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Patient {
    private String id;
    private String name;
    private Map<String, Double> measurements;  // Stores medical measurements

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.measurements = new HashMap<>();
    }

    public void addMeasurement(String type, double value) {
        measurements.put(type, value);
    }

    public Double getMeasurement(String type) {
        return measurements.get(type);
    }

    public Map<String, Double> getAllMeasurements() {
        return new HashMap<>(measurements);
    }
}