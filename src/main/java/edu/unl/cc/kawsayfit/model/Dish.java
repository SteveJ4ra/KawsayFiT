package edu.unl.cc.kawsayfit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "dishes")
@NamedQueries({
        @NamedQuery(name = "User.findLikeName",
                query = "select o from Dish o where o.name like :name"),
        @NamedQuery(name = "User.findById",
                query = "select o from Dish o where o.id = :id ")
})
public class Dish {

    public Dish() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String imagePath; // ejemplo para recordar: "arroz-con-pollo.jpg"

    @Lob
    @Column(nullable = false)
    private String ingredients;

    @Positive
    @Column(nullable = false)
    private double caloriesPerServing;

    @Positive
    @Column(nullable = false)
    private double amount;

    @PositiveOrZero
    @Column(nullable = false)
    private double proteins;

    @PositiveOrZero
    @Column(nullable = false)
    private double carbohydrates;

    @PositiveOrZero
    @Column(nullable = false)
    private double calories;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public @NotBlank String getImagePath() {
        return imagePath;
    }

    public void setImagePath(@NotBlank String imagePath) {
        this.imagePath = imagePath;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public @Positive double getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public void setCaloriesPerServing(@Positive double caloriesPerServing) {
        this.caloriesPerServing = caloriesPerServing;
    }

    public @PositiveOrZero double getProteins() {
        return proteins;
    }

    public void setProteins(@PositiveOrZero double proteins) {
        this.proteins = proteins;
    }

    public @PositiveOrZero double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(@PositiveOrZero double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public @PositiveOrZero double getCalories() {
        return calories;
    }

    public void setCalories(@PositiveOrZero double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dish{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", imagePath='").append(imagePath).append('\'');
        sb.append(", ingredients='").append(ingredients).append('\'');
        sb.append(", caloriesPerServing=").append(caloriesPerServing);
        sb.append(", proteins=").append(proteins);
        sb.append(", carbohydrates=").append(carbohydrates);
        sb.append(", calories=").append(calories);
        sb.append('}');
        return sb.toString();
    }

}
