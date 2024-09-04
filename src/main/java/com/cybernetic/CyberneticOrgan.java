package com.cybernetic;

public class CyberneticOrgan {
    private String id;
    private String model;
    private String functionality;
    private String compatibility;

    public CyberneticOrgan(String id, String model, String functionality, String compatibility) {
        this.id = id;
        this.model = model;
        this.functionality = functionality;
        this.compatibility = compatibility;
    }

    public String getDetails() {
        return "ID: " + id + ", Model: " + model + ", Funcationality: " + functionality + ", compatibility: " + compatibility;
    }

    public boolean isCompatible(String patientCompatibility){
        return patientCompatibility;
    }
}
