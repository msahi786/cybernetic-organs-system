package com.cybernetic;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CyberneticOrgan {
    private String id;
    private String type;
    private Map<String, Range> requirementRanges;

    public CyberneticOrgan(String id, String type) {
        this.id = id;
        this.type = type;
        this.requirementRanges = new HashMap<>();
    }

    public void addRequirement(String measurementType, double min, double max) {
        requirementRanges.put(measurementType, new Range(min, max));
    }

    public Map<String, Range> getRequirements() {
        return new HashMap<>(requirementRanges);
    }

    public String getType() {
        return type;
    }

    static class Range {
        double min;
        double max;

        Range(double min, double max) {
            this.min = min;
            this.max = max;
        }
    }
}