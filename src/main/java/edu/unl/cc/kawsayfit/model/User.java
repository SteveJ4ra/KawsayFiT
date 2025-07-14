package edu.unl.cc.kawsayfit.model;

import edu.unl.cc.kawsayfit.model.enums.Goal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    private double weight;

    @Column
    @NotNull
    private double height;

    @Enumerated(EnumType.STRING)
    @Column @NotNull
    private Goal goal;

    @Column @NotNull
    private LocalDate registrationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public @NotNull double getWeight() {
        return weight;
    }

    public void setWeight(@NotNull double weight) {
        this.weight = weight;
    }

    public @NotNull double getHeight() {
        return height;
    }

    public void setHeight(@NotNull double height) {
        this.height = height;
    }

    public @NotNull Goal getGoal() {
        return goal;
    }

    public void setGoal(@NotNull Goal goal) {
        this.goal = goal;
    }

    public @NotNull LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(@NotNull LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", goal=").append(goal);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append('}');
        return sb.toString();
    }
}