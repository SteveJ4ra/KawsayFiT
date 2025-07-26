package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import java.io.Serializable;

public class Calculator implements Serializable {

    public static double calculateIMC(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Peso o altura inválidos");
        }
        double alturaEnMetros = height / 100.0;
        return weight / (alturaEnMetros * alturaEnMetros);
    }

    public static String calculateImcState(double imc) {
        if (imc < 18.5) return "Bajo peso";
        else if (imc < 25) return "Normal";
        else if (imc < 30) return "Sobrepeso";
        else return "Obesidad";
    }

    public static int calculateCaloricGoal(User user) {
        double bmr = 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getAge();
        double tdee = bmr * 1.2;

        Goal goal = user.getGoal();
        if (goal != null) {
            switch (goal) {
                case GAIN_MUSCLE:
                    tdee += 300;
                    break;
                case LOSE_WEIGHT:
                    tdee -= 300;
                    break;
                case MAINTAIN_WEIGHT:
                default:
                    break;
            }
        }

        return (int) Math.round(tdee);
    }

    public static int calculateProteinGoal(User user) {
        Goal goal = user.getGoal();
        double factor;

        if (goal != null) {
            switch (goal) {
                case GAIN_MUSCLE:
                    factor = 2.0;
                    break;
                case LOSE_WEIGHT:
                    factor = 2.2;
                    break;
                case MAINTAIN_WEIGHT:
                default:
                    factor = 1.6;
                    break;
            }
        } else {
            factor = 1.6;
        }

        return (int) Math.round(user.getWeight() * factor);
    }

    public static int calculateCarbohydrateGoal(User user) {
        Goal goal = user.getGoal();
        double factor;

        if (goal != null) {
            switch (goal) {
                case GAIN_MUSCLE:
                    factor = 5.0;
                    break;
                case LOSE_WEIGHT:
                    factor = 3.0;
                    break;
                case MAINTAIN_WEIGHT:
                default:
                    factor = 4.0;
                    break;
            }
        } else {
            factor = 4.0;
        }

        return (int) Math.round(user.getWeight() * factor);
    }
}
