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

    public void search() {
        //TODO
    }

    public String registerFood() { //Antes de regresar cambiar valores segun la nutricion
        return "profile.xhtml?faces-redirect=true";
    }

    Dish dish = new Dish();
    public Dish getDish() {
        return dish;
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
}
