package edu.unl.cc.kawsayfit.service;

import java.io.Serializable;

public class ImcCalculator implements Serializable {

    private double weight; // kg
    private double height; // cm
    private double imc;

    public ImcCalculator(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double calculate() {
        double heightInMeters = height / 100.0;
        imc = weight / (heightInMeters * heightInMeters);
        return imc;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}
