package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Gender;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class CustomizeGoalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date birthdate;
    private Gender gender;
    private double currentWeight;
    private double targetWeight;
    private String velocity;

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

        // Redirige a la vista de resultados
        return "user-results.xhtml?faces-redirect=true";
    }

    public List<SelectItem> getWeightList() {
        List<SelectItem> items = new ArrayList<>();
        for(int i = 40; i <= 150; i += 5) {
            items.add(new SelectItem(i, i + "kg"));
        }
        return items;
    }

    public Gender[] getGenderValues() {
        return Gender.values();
    }

    // Getters y Setters

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
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

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }
}


