package edu.unl.cc.kawsayfit.model;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private double amount;

    public Ingredient() {}

    public Ingredient(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    // GETTERS PÚBLICOS
    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}