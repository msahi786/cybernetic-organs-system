package com.cybernetic;

public class DiagnosticNode {
    private String measurementType;
    private double thresholdValue;
    private String diagnosis;
    private DiagnosticNode left;
    private DiagnosticNode right;

    public DiagnosticNode(String measurementType, double thresholdValue) {
        this.measurementType = measurementType;
        this.thresholdValue = thresholdValue;
        this.diagnosis = null;
    }

    public DiagnosticNode(String measurementType, double thresholdValue, String diagnosis) {
        this.measurementType = measurementType;
        this.thresholdValue = thresholdValue;
        this.diagnosis = diagnosis;
    }


    public String getMeasurementType() {
        return measurementType;
    }

    public double getThresholdValue() {
        return thresholdValue;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public DiagnosticNode getLeft() {
        return left;
    }

    public void setLeft(DiagnosticNode left) {
        this.left = left;
    }

    public DiagnosticNode getRight() {
        return right;
    }

    public void setRight(DiagnosticNode right) {
        this.right = right;
    }
}
