package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.PhysicalActivityLevel;
import edu.unl.cc.kawsayfit.model.training.*;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

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
            userService.updateActivityLevel(user, levelEnum);
        }
        return "strength-training.xhtml?faces-redirect=true";
    }
}

