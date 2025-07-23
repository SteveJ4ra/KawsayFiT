package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.ActivityOption;
import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.PhysicalActivityLevel;
import edu.unl.cc.kawsayfit.model.training.*;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("activityBean")
@ViewScoped
public class ActivityBean implements Serializable {

    private String activityLevel = "";
    private Training trainType;

    @Inject
    private UserSession userSession;

    @Inject
    private UserService userService;

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Training getTraining() {
        return trainType;
    }

    public String processSelection() {
        PhysicalActivityLevel levelEnum;
        if (activityLevel == null || activityLevel.isEmpty()) {
            System.out.println("Ningún nivel de actividad seleccionado");
            return null;
        }
        switch (activityLevel) {
            case "sedentario":
                levelEnum = PhysicalActivityLevel.SEDENTARY;
                trainType = new Sedentary();
                break;
            case "ligeramente-activo":
                levelEnum = PhysicalActivityLevel.LIGHTLY_ACTIVE;
                trainType = new LightlyActive();
                break;
            case "moderadamente-activo":
                levelEnum = PhysicalActivityLevel.MODERATELY_ACTIVE;
                trainType = new ModeratelyActive();
                break;
            case "muy-activo":
                levelEnum = PhysicalActivityLevel.VERY_ACTIVE;
                trainType = new VeryActive();
                break;
            case "atleta":
                levelEnum = PhysicalActivityLevel.ATHLETE;
                trainType = new ProfessionalAthlete();
                break;
            default:
                levelEnum = null;
                trainType = null;
                break;
        }

        if (levelEnum != null) {
            User user = userSession.getCurrentUser();
            if (user == null) {
                return "login.xhtml?faces-redirect=true";
            }
            userService.updateActivityLevel(user, levelEnum);

        }
        return "strength-training.xhtml?faces-redirect=true";
    }

    private List<ActivityOption> activityOptions;

    @PostConstruct
    public void init() {
        activityOptions = List.of(
                new ActivityOption("sedentario", "Sedentario", "Poco o nada de ejercicio"),
                new ActivityOption("ligeramente-activo", "Ligeramente Activo", "Ejercicio 2 a 3 días por semana"),
                new ActivityOption("moderadamente-activo", "Moderadamente Activo", "Ejercicio 4 a 5 días por semana"),
                new ActivityOption("muy-activo", "Muy Activo", "Ejercicio 6 a 7 días por semana"),
                new ActivityOption("atleta", "Atleta Profesional", "Ejercicio intenso 6 a 7 días por semana")
        );
    }

    public List<ActivityOption> getActivityOptions() {
        return activityOptions;
    }
}

