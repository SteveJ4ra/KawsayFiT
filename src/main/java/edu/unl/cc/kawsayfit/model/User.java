package edu.unl.cc.kawsayfit.model;

import edu.unl.cc.kawsayfit.model.ConsumedDish;
import edu.unl.cc.kawsayfit.model.enums.Gender;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.model.enums.PhysicalActivityLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank
    @Column(nullable = false)
    private String passwordHash;

    @Positive
    @Column(nullable = false)
    private double weight; // en kg

    @Positive
    @Column(nullable = false)
    private double height; // en cm

    @Positive
    @Column(nullable = false)
    private double targetWeight;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("date DESC")
    private List<DailyLog> dailyLogs = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Goal goal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhysicalActivityLevel activityLevel;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @Transient
    public double getIMC() {
        double heightM = height / 100.0;
        return heightM <= 0 ? 0 : weight / (heightM * heightM);
    }

    @Transient
    public int getAge() {
        return (birthDate != null) ? Period.between(birthDate, LocalDate.now()).getYears() : 0;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Email @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotNull String email) {
        this.email = email;
    }

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public @NotBlank String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(@NotBlank String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public @Positive double getWeight() {
        return weight;
    }

    public void setWeight(@Positive double weight) {
        this.weight = weight;
    }

    public @Positive double getHeight() {
        return height;
    }

    public void setHeight(@Positive double height) {
        this.height = height;
    }

    public @Positive double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(@Positive double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<DailyLog> getDailyLogs() {
        return dailyLogs;
    }

    public void setDailyLogs(List<DailyLog> dailyLogs) {
        this.dailyLogs = dailyLogs;
    }

    public PhysicalActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(PhysicalActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", targetWeight=").append(targetWeight);
        sb.append(", dailyLogs=").append(dailyLogs);
        sb.append(", gender=").append(gender);
        sb.append(", goal=").append(goal);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", activityLevel=").append(activityLevel);
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }
}
