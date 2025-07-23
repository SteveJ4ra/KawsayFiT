package edu.unl.cc.kawsayfit.controller;

public class ActivityOption {
    private String value;
    private String label;
    private String description;

    public ActivityOption(String value, String label, String description) {
        this.value = value;
        this.label = label;
        this.description = description;
    }

    public String getValue() { return value; }
    public String getLabel() { return label; }
    public String getDescription() { return description; }
}