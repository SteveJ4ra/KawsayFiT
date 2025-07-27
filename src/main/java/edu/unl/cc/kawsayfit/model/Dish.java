package edu.unl.cc.kawsayfit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String imageUrl;

    private double caloriesPerServing;
    private double proteins;
    private double carbohydrates;
    private double fats;

    // Constructor vacío requerido por JPA
    public Dish() {}

    // Constructor con parámetros
    public Dish(String name, String description, double price, String imageUrl,
                double caloriesPerServing, double proteins, double carbohydrates, double fats) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.caloriesPerServing = caloriesPerServing;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getCaloriesPerServing() {
        return caloriesPerServing;
    }
    public void setCaloriesPerServing(double caloriesPerServing) {
        this.caloriesPerServing = caloriesPerServing;
    }

    public double getProteins() {
        return proteins;
    }
    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }
    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFats() {
        return fats;
    }
    public void setFats(double fats) {
        this.fats = fats;
    }
    public double getCalories() {
        return this.caloriesPerServing;
    }
}