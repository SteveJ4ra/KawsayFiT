package edu.unl.cc.kawsayfit.controller;

public class ActivityOption {
    private String value;
    private String label;

    public ActivityOption(String value, String label, String description) {
        this.value = value;
        this.label = label;
    }

    public String getValue() { return value; }
    public String getLabel() { return label; }
}