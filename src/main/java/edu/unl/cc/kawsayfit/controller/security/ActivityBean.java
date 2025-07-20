package edu.unl.cc.kawsayfit.controller.security;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("activityBean")
@ViewScoped
public class ActivityBean implements Serializable{

    private String activityLevel = "moderadamente-activo";

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
}
