package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.service.Calculator;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("profileBean")
@ViewScoped
public class ProfileBean implements Serializable {

    private String fullName;
    private String email;
    private int age;
    private double height; // cm
    private double weight; // kg
    private String goal;

    private int consumedCalories;
    private int caloriesGoal;

    private int comsumedProteins;
    private int proteinsGoal;

    private int consumedCarbohydrates;
    private int carbohydratesGoal;

    public ProfileBean() {
        fullName = "Juan Pérez";
        email = "juan.perez@example.com";
        age = 29;
        height = 175;
        weight = 72;
        goal = "Perder grasa";

        consumedCalories = 1300;
        caloriesGoal = 2000;

        comsumedProteins = 80;
        proteinsGoal = 120;

        consumedCarbohydrates = 180;
        carbohydratesGoal = 250;
    }

    public double getImc() {
        try {
            return Math.round(Calculator.calculateIMC(weight, height) * 10) / 10.0;
        } catch (IllegalArgumentException e) {
            return 0.0;
        }
    }

    public String getImcState() {
        try {
            double imc = Calculator.calculateIMC(weight, height);
            return Calculator.calculateImcState(imc);
        } catch (IllegalArgumentException e) {
            return "No definido";
        }
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getConsumedCalories() {
        return consumedCalories;
    }

    public void setConsumedCalories(int consumedCalories) {
        this.consumedCalories = consumedCalories;
    }

    public int getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(int caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public int getComsumedProteins() {
        return comsumedProteins;
    }

    public void setComsumedProteins(int comsumedProteins) {
        this.comsumedProteins = comsumedProteins;
    }

    public int getProteinsGoal() {
        return proteinsGoal;
    }

    public void setProteinsGoal(int proteinsGoal) {
        this.proteinsGoal = proteinsGoal;
    }

    public int getConsumedCarbohydrates() {
        return consumedCarbohydrates;
    }

    public void setConsumedCarbohydrates(int consumedCarbohydrates) {
        this.consumedCarbohydrates = consumedCarbohydrates;
    }

    public int getCarbohydratesGoal() {
        return carbohydratesGoal;
    }

    public void setCarbohydratesGoal(int carbohydratesGoal) {
        this.carbohydratesGoal = carbohydratesGoal;
    }
}
