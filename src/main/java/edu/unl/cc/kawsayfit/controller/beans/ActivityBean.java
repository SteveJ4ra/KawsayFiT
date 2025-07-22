package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.model.training.*;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("activityBean")
@ViewScoped
public class ActivityBean implements Serializable {

    private String activityLevel = "";
    private Training entrenamiento;

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Training getTraining() {
        return entrenamiento;
    }

    public String processSelection() {
        switch (activityLevel) {
            case "sedentario":
                entrenamiento = new Sedentary();
                break;
            case "ligeramente-activo":
                entrenamiento = new LightlyActive();
                break;
            case "moderadamente-activo":
                entrenamiento = new ModeratelyActive();
                break;
            case "muy-activo":
                entrenamiento = new VeryActive();
                break;
            case "atleta":
                entrenamiento = new ProfessionalAthlete();
                break;
            default:
                entrenamiento = null;
                break;
        }
        return "strength-training.xhtml?faces-redirect=true";
    }
}
