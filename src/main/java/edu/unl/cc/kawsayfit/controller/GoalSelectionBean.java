package edu.unl.cc.kawsayfit.controller;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class GoalSelectionBean implements Serializable {

    private Goal selectedGoal;
    private String message;

    @Inject
    private UserSession userSession;

    @Inject
    private UserService userService;

    public void saveGoal() {
        User user = userSession.getLoggedUser();
        if (user == null) {
            message = "Usuario no autenticado.";
            return;
        }

        if (selectedGoal == null) {
            message = "Debes seleccionar un objetivo.";
            return;
        }

        userService.updateGoal(user, selectedGoal);
        message = "Objetivo actualizado a: " + selectedGoal.name();
    }

    public List<Goal> getAvailableGoals() {
        return Arrays.asList(Goal.values());
    }


    public Goal getSelectedGoal() {
        return selectedGoal;
    }

    public void setSelectedGoal(Goal selectedGoal) {
        this.selectedGoal = selectedGoal;
    }

    public String getMessage() {
        return message;
    }
}
