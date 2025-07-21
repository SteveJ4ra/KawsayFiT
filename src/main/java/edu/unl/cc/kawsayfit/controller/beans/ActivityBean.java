package edu.unl.cc.kawsayfit.controller.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("activityBean")
@ViewScoped
public class ActivityBean implements Serializable {

    private String activityLevel = "";

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String processSelection() {
        switch (activityLevel) {
            case "sedentario":
                // entrenamiento = new EntrenamientoSedentario();
                break;
            case "ligeramente-activo":
                // entrenamiento = new EntrenamientoLigero();
                break;
            case "moderadamente-activo":
                // entrenamiento = new EntrenamientoModerado();
                break;
            case "muy-activo":
                // entrenamiento = new EntrenamientoIntenso();
                break;
            case "atleta":
                // entrenamiento = new EntrenamientoAvanzado();
                break;
            default:
                // Opcional: redirige a una vista de error o alerta
                break;
        }

        return "strength-training.xhtml?faces-redirect=true";
    }
}
