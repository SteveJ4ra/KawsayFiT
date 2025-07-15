package edu.unl.cc.kawsayfit.model.enums;

public enum PhysicalActivityLevel {
    SEDENTARY(1.2),
    LIGHTLY_ACTIVE(1.375),
    MODERATELY_ACTIVE(1.55),
    VERY_ACTIVE(1.725),
    ATHLETE(1.9);

    private final double multiplier;

    PhysicalActivityLevel(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
