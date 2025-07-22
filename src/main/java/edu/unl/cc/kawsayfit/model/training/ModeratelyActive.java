package edu.unl.cc.kawsayfit.model.training;

public class ModeratelyActive implements Training {
    public String getType() {
        return "Moderadamente Activo";
    }

    public String getRecomendation() {
        return "Ejercicio 4-5 veces por semana: fuerza, cardio moderado, estiramientos.";
    }
}
