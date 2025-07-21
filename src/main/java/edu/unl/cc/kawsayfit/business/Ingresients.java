package edu.unl.cc.kawsayfit.business;

public class Ingresients {
    private String name;
    private double amount;

    public Ingresients(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

