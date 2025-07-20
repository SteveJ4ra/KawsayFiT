package edu.unl.cc.kawsayfit.model;

public class Food {


    private String name;
    private String img;

    public Food(String nombre, String img) {
        this.name = nombre;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }


}
