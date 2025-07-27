package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.model.NutritionalPlan;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.service.NutritionService;
import edu.unl.cc.kawsayfit.service.NutritionService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named( "userResultBean")
@ViewScoped
public class UserResultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserSession userSession;

    @Inject
    private NutritionService nutritionService;

    private NutritionalPlan plan;

    @PostConstruct
    public void init() {
        User user = userSession.getLoggedUser();
        if (user != null) {
            plan = nutritionService.calculateDailyPlan(user);
        }
    }

    public NutritionalPlan getPlan() {
        return plan;
    }

}
