package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("strengthTrainingBean")
@ViewScoped
public class StrengthTrainingBean implements Serializable {

    private boolean doesStrengthTraining;

    @Inject
    private UserSession userSession;

    @Inject
    private UserService userService;

    public boolean isDoesStrengthTraining() {
        return doesStrengthTraining;
    }

    public void setDoesStrengthTraining(boolean doesStrengthTraining) {
        this.doesStrengthTraining = doesStrengthTraining;
    }

    public String saveAndContinue() {
        User user = userSession.getCurrentUser();
        if(user != null) {
            user.setStrengthTraining(doesStrengthTraining);

            try {
                userService.update(user);
            }catch(Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar el usuario",
                                e.getMessage()));
                return null;
            }
        }

        return "user-objectives.xhtml?faces-redirect=true";
    }
}
