package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.model.ConsumedDish;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.repository.ConsumedDishRepository;
import edu.unl.cc.kawsayfit.service.Calculator;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Inject
    private UserSession userSession;

    @Inject
    private ConsumedDishRepository consumedDishRepository;

    @PostConstruct
    public void init() {
        User user = userSession.getLoggedUser();
        if (user != null) {
            this.fullName = user.getUsername();
            this.email = user.getEmail();
            this.age = user.getAge();
            this.height = user.getHeight();
            this.weight = user.getWeight();
            this.goal = user.getGoal() != null ? user.getGoal().toString() : "Sin objetivo";

            this.caloriesGoal = Calculator.calculateCaloricGoal(user);
            this.proteinsGoal = Calculator.calculateProteinGoal(user);
            this.carbohydratesGoal = Calculator.calculateCarbohydrateGoal(user);

            List<ConsumedDish> consumed = consumedDishRepository.findByUser(user);

            this.consumedCalories = (int) consumed.stream()
                    .mapToDouble(ConsumedDish::getTotalCalories)
                    .sum();

            this.comsumedProteins = (int) consumed.stream()
                    .mapToDouble(ConsumedDish::getTotalProteins)
                    .sum();

            this.consumedCarbohydrates = (int) consumed.stream()
                    .mapToDouble(ConsumedDish::getTotalCarbohydrates)
                    .sum();
        }
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

    public Map<String, Number> getCaloriesData() {
        Map<String, Number> data = new LinkedHashMap<>();
        data.put("Consumido", consumedCalories);
        data.put("Restante", Math.max(0, caloriesGoal - consumedCalories));
        return data;
    }

    public Map<String, Number> getProteinsData() {
        Map<String, Number> data = new LinkedHashMap<>();
        data.put("Consumido", comsumedProteins);
        data.put("Restante", Math.max(0, proteinsGoal - comsumedProteins));
        return data;
    }

    public Map<String, Number> getCarbsData() {
        Map<String, Number> data = new LinkedHashMap<>();
        data.put("Consumido", consumedCarbohydrates);
        data.put("Restante", Math.max(0, carbohydratesGoal - consumedCarbohydrates));
        return data;
    }

}
