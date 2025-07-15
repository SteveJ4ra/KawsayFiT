package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Goal;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NutritionService {

    public double calculateBMR(User user) {
        double weight = user.getWeight();
        double height = user.getHeight();
        int age = user.getAge(); // calculado automáticamente en la entidad User

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
        double calories = switch (user.getGoal()) {
            case LOSE_WEIGHT -> tdee - 500;
            case MAINTAIN_WEIGHT -> tdee;
            case GAIN_MUSCLE -> tdee + 300;
        };

        // Macronutrient distribution
        double proteins = (calories * 0.3) / 4;
        double carbs = (calories * 0.4) / 4;
        double fats = (calories * 0.3) / 9;

        return new NutritionalPlan(calories, proteins, carbs, fats);
    }

    public static class NutritionalPlan {
        private final double calories;
        private final double proteins;
        private final double carbs;
        private final double fats;

        public NutritionalPlan(double calories, double proteins, double carbs, double fats) {
            this.calories = calories;
            this.proteins = proteins;
            this.carbs = carbs;
            this.fats = fats;
        }

        public double getCalories() {
            return calories;
        }

        public double getProteins() {
            return proteins;
        }

        public double getCarbs() {
            return carbs;
        }

        public double getFats() {
            return fats;
        }
    }
}
