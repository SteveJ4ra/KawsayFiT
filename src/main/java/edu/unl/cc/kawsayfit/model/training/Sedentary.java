package edu.unl.cc.kawsayfit.model.training;

public class Sedentary implements Training {
    public String getType() {
        return "Sedentario";
    }

    public String getRecomendation() {
        return "Caminar 30 minutos al día";
    }
}
