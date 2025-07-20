package edu.unl.cc.kawsayfit.controller;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Gender;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;

@Named
@ViewScoped
public class CustomizeGoalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate birthdate;
    private Gender gender;
    private double currentWeight;
    private double targetWeight;

    @Inject
    private UserSession userSession;

    @Inject
    private UserService userService;

    @PostConstruct
    public void init() {
        User user = userSession.getCurrentUser();
        if (user != null) {
            this.birthdate = user.getBirthDate();
            this.gender = user.getGender();
            this.currentWeight = user.getWeight();
            this.targetWeight = user.getTargetWeight();
        }
    }

    public String saveAndContinue() {
        User user = userSession.getCurrentUser();
        if (user != null) {
            user.setBirthDate(birthdate);
            user.setGender(gender);
            user.setWeight(currentWeight);
            user.setTargetWeight(targetWeight);
            userService.update(user);
        }

        // Redirige a la vista de resultados (ajusta según la navegación real)
        return "userResults.xhtml?faces-redirect=true";
    }

    // Getters y Setters

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }
}
