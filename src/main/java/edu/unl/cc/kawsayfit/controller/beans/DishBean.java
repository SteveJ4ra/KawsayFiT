package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.model.Dish;
import edu.unl.cc.kawsayfit.model.Ingredient;
import edu.unl.cc.kawsayfit.service.DishService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("dishBean")
@RequestScoped
public class DishBean implements Serializable {

    private String name;
    private String amount;
    private double calories;
    private double proteins;
    private double carbohydrates;
    private double fats;
    private String img;
    private List<Ingredient> ingredients = new ArrayList<>();

    @Inject
    private DashboardBean dashboardBean;

    @Inject
    private DishService dishService;

    @PostConstruct
    public void init() {
        if (dashboardBean != null && dashboardBean.getSelectedDish() != null) {
            Dish selectedDish = dashboardBean.getSelectedDish();
            this.name = selectedDish.getName();
            this.amount = selectedDish.getDescription();
            this.calories = selectedDish.getCalories();
            this.proteins = selectedDish.getProteins();
            this.carbohydrates = selectedDish.getCarbohydrates();
            this.fats = selectedDish.getFats();
            this.img = selectedDish.getImageUrl();

            this.ingredients.clear();
            this.ingredients.add(new Ingredient(selectedDish.getName(), 100));
        } else {
            this.name = "Plato no encontrado";
            this.amount = "0 g";
            this.calories = 0;
            this.proteins = 0;
            this.carbohydrates = 0;
            this.fats = 0;
            this.img = "default-food.png";
        }
    }

    public String registerFood() {
        return "dashboard?faces-redirect=true";
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public String getImg() {
        return img;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}