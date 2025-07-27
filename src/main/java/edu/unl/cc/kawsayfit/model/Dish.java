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
    private String information;
    private String imageUrl;
    private double caloriesPerServing;
    private double proteins;
    private double carbohydrates;

    public Dish() {}

    public Dish(String name, String description, String information, String imageUrl,
                double caloriesPerServing, double proteins, double carbohydrates) {
        this.name = name;
        this.description = description;
        this.information = information;
        this.imageUrl = imageUrl;
        this.caloriesPerServing = caloriesPerServing;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public double getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getCalories() {
        return this.caloriesPerServing;
    }

    public String getInformation() {
        return information;
    }
}