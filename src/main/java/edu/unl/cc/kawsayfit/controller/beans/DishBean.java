package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.business.Ingredients;
import edu.unl.cc.kawsayfit.model.Dish;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Named("dishBean")
@ViewScoped
public class DishBean implements Serializable {

    Dish dish = new Dish();
    private double calories = dish.getCalories();
    private double carbohydrates = dish.getCarbohydrates();
    private double proteins= dish.getProteins();
    private String name = dish.getName();
    private String img = dish.getImagePath();
    private double amount = dish.getAmount();

    public void search() {
        //TODO
    }

    public String registerFood() {
        //TODO
        return "profile.xhtml?faces-redirect=true";
    }

    public List<Ingredients> getIngredients() {
        if (dish.getIngredients() == null || dish.getIngredients().isEmpty()) {
            return Collections.emptyList();
        }

        return Arrays.stream(dish.getIngredients().split(";"))
                .map(str -> {
                    String[] parts = str.split(":");
                    if (parts.length == 2) {
                        return new Ingredients(parts[0].trim(), Double.parseDouble(parts[1].trim()));
                    } else {
                        return new Ingredients(str.trim(), 0);
                    }
                })
                .collect(Collectors.toList());
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
