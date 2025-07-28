package edu.unl.cc.kawsayfit.model.enums;

public enum Goal {
    LOSE_WEIGHT("Perder peso"),
    MAINTAIN_WEIGHT("Mantener peso"),
    GAIN_MUSCLE("Ganar músculo");

    private final String displayName;

    Goal(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
