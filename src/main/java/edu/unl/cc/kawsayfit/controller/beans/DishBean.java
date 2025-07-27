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
    private String description;
    private String information;
    private double calories;
    private double proteins;
    private double carbohydrates;
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
            this.description = selectedDish.getDescription();
            this.information = selectedDish.getInformation();
            this.calories = selectedDish.getCalories();
            this.proteins = selectedDish.getProteins();
            this.carbohydrates = selectedDish.getCarbohydrates();
            this.img = selectedDish.getImageUrl();

            this.ingredients.clear();
            this.ingredients.add(new Ingredient(selectedDish.getName(), 100));
        } else {
            this.name = "Plato no encontrado";
            this.description = "0 g";
            this.information = "0 g";
            this.calories = 0;
            this.proteins = 0;
            this.carbohydrates = 0;
            this.img = "KawsayFit.png";
        }
    }

    public String registerFood() {
        return "dashboard?faces-redirect=true";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInformation() {
        return information;
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

    public String getImg() {
        return img;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}