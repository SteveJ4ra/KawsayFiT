package edu.unl.cc.kawsayfit.controller.beans;


import edu.unl.cc.kawsayfit.model.Food;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("dashboardBean")
@ViewScoped
public class DasboardBean implements Serializable {

    private List<Food> listFood;
    private List<String> suggestion;

    public DasboardBean() {
        loadFood();
        makeSuggestion();
    }


    public void loadFood() {
        //TODO
    }


    public void makeSuggestion() {
        suggestion = new ArrayList<>();
        for (Food food : listFood) {
            suggestion.add(food.getName());
        }
    }

    public List<Food> getFoodList() {
        return listFood;
    }

    public List<String> getSuggestion() {
        return suggestion;
    }

}
