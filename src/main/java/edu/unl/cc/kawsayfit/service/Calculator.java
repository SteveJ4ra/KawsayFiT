package edu.unl.cc.kawsayfit.service;

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
}
