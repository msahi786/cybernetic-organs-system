package com.cybernetic;

public class Organ {
    private String name;
    private String model;
    private String compatibility;
    private String functionality;

    public Organ(String name, String model, String compatibility, String functionality) {
        this.name = name;
        this.model = model;
        this.compatibility = compatibility;
        this.functionality = functionality;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public String getFunctionality() {
        return functionality;
    }

    public String getDetails() {
        return "Name: " + name + ", Model: " + model + ", Compatibility: " + compatibility + ", Functionality: " + functionality;
    }
}
