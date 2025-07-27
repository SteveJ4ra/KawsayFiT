package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.model.NutritionalPlan;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NutritionService {

    public double calculateBMR(User user) {
        double weight = user.getWeight();
        double height = user.getHeight();
        int age = user.getAge();

        return switch (user.getGender()) {
            case MALE -> 10 * weight + 6.25 * height - 5 * age + 5;
            case FEMALE -> 10 * weight + 6.25 * height - 5 * age - 161;
        };
    }

    public double calculateTDEE(User user) {
        return calculateBMR(user) * user.getPhysicalActivityLevel().getMultiplier();
    }

    public NutritionalPlan calculateDailyPlan(User user) {
        double tdee = calculateTDEE(user);

        String velocity = user.getVelocity() != null ? user.getVelocity().toLowerCase() : "moderado";

        double adjustment;
        switch (velocity) {
            case "lento" -> adjustment = 250;
            case "rapido" -> adjustment = 750;
            default -> adjustment = 500;
        }

        Goal goal = user.getGoal();
        double calories = switch (goal) {
            case LOSE_WEIGHT -> tdee - adjustment;
            case MAINTAIN_WEIGHT -> tdee;
            case GAIN_MUSCLE -> tdee + adjustment;
        };

        double proteins = (calories * 0.3) / 4;
        double carbs = (calories * 0.4) / 4;
        double fats = (calories * 0.3) / 9;

        return new NutritionalPlan(calories, proteins, carbs, fats, goal);
    }
}
