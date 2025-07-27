package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.model.Dish;
import edu.unl.cc.kawsayfit.service.DishService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("dashboardBean")
@SessionScoped
public class DashboardBean implements Serializable {

    private String searching;
    private Dish selectedDish;

    @Inject
    private DishService dishService;

    public List<String> completeSuggestions(String query) {
        return dishService.getAllDishNames().stream()
                .filter(name -> name.toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public String find() {
        if (searching != null && !searching.isEmpty()) {
            selectedDish = dishService.findByName(searching);
            if (selectedDish != null) {
                return "dish?faces-redirect=true";
            }
        }
        return null;
    }

    public Dish getSelectedDish() {
        return selectedDish;
    }

    public String getSearching() {
        return searching;
    }

    public void setSearching(String searching) {
        this.searching = searching;
    }
}