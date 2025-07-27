package edu.unl.cc.kawsayfit.model;

import edu.unl.cc.kawsayfit.model.enums.Goal;

public class NutritionalPlan {
    private final double calories;
    private final double proteins;
    private final double carbs;
    private final double fats;
    private final Goal goal;

    public NutritionalPlan(double calories, double proteins, double carbs, double fats, Goal goal) {
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.goal = goal;
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

    public Goal getGoal() {
        return goal;
    }

    public String getGoalLabel() {
        return switch (goal) {
            case LOSE_WEIGHT -> "Bajar de peso";
            case MAINTAIN_WEIGHT -> "Mantener peso";
            case GAIN_MUSCLE -> "Ganar masa muscular";
        };
    }
}
