package edu.unl.cc.kawsayfit.model;

public class Food {

    private String name;
    private String img;

    public Food(String nombre, String img) {
        if (name == null || img == null) {
            throw new IllegalArgumentException("El nombre y la imagen son obligatorios");
        }
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
