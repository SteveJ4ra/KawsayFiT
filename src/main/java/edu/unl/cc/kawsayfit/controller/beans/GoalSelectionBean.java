package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named("goalSelectionBean")
@ViewScoped
public class GoalSelectionBean implements Serializable {

    private Goal selectedGoal;
    private String message;

    @Inject
    private UserSession userSession;

    @Inject
    private UserService userService;

    // Guarda el objetivo y redirige a la siguiente vista
    public String goToActivityLevel() {
        User user = userSession.getLoggedUser();

        if (user == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario no autenticado."));
            return null;
        }

        if (selectedGoal == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Debes seleccionar un objetivo."));
            return null;
        }

        try {
            userService.updateGoal(user,selectedGoal);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Objetivo actualizado a: " + selectedGoal.name()));
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar el objetivo", e.getMessage()));
            return null;
        }

        return "activity-level.xhtml?faces-redirect=true";
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

