package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.model.Dish;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.service.DishService;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("dishBean")
@RequestScoped
public class DishBean implements Serializable {

    private Dish dish;

    private double calories;
    private double carbohydrates;
    private double proteins;
    private String name;
    private String img;
    private double amount;
    private String ingredients;

    @Inject
    private DishService dishService;

    @Inject
    private UserService userService;

    @Inject
    private UserSession sessionBean;

    private void addMessage(String summary, FacesMessage.Severity severity) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, null));
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        String dishIdStr = context.getExternalContext().getRequestParameterMap().get("id");
        if (dishIdStr != null) {
            try {
                Long dishId = Long.parseLong(dishIdStr);
                this.dish = dishService.findById(dishId);

                if (this.dish != null) {
                    this.calories = dish.getCalories();
                    this.carbohydrates = dish.getCarbohydrates();
                    this.proteins = dish.getProteins();
                    this.name = dish.getName();
                    this.img = dish.getImagePath();
                    this.amount = dish.getAmount();
                    this.ingredients = dish.getIngredients();
                }

            } catch (NumberFormatException e) {
                addMessage("ID inválido: no es un número.", FacesMessage.SEVERITY_ERROR);
            } catch (Exception e) {
                addMessage("Error inesperado al cargar el plato.", FacesMessage.SEVERITY_ERROR);
                e.printStackTrace();
            }
        }
    }

    public String registerFood() {
        User user = sessionBean.getCurrentUser();

        if (user != null && dish != null) {
            userService.updateActivityLevel(user, user.getPhysicalActivityLevel());
        }

        return "profile.xhtml?faces-redirect=true";
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public double getCalories() {
        return calories;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getProteins() {
        return proteins;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public double getAmount() {
        return amount;
    }

    public String getIngredients() {
        return ingredients;
    }
}
