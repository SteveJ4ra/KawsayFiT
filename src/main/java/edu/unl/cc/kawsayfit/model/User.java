package edu.unl.cc.kawsayfit.model;

import edu.unl.cc.kawsayfit.model.enums.Gender;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.model.enums.PhysicalActivityLevel;
import edu.unl.cc.kawsayfit.service.ImcCalculator;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")
public class User implements Serializable {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    private LocalDate registrationDate;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double weight;

    private double height; // Centímetros

    private double targetWeight;

    private double imc;

    private double calculate () {
        ImcCalculator imcCalculator = new ImcCalculator(weight, height);
        imc = imcCalculator.calculate(weight, height);
        return imc;
    }

    @Enumerated(EnumType.STRING)
    private Goal goal;

    @Enumerated(EnumType.STRING)
    private PhysicalActivityLevel physicalActivityLevel;

    private boolean strengthTraining;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public PhysicalActivityLevel getPhysicalActivityLevel() {
        return physicalActivityLevel;
    }

    public void setPhysicalActivityLevel(PhysicalActivityLevel physicalActivityLevel) {
        this.physicalActivityLevel = physicalActivityLevel;
    }

    public boolean isStrengthTraining() {
        return strengthTraining;
    }

    public void setStrengthTraining(boolean strengthTraining) {
        this.strengthTraining = strengthTraining;
    }

    /**
     * Devuelve la edad en base al campo birthDate.
     */
    public int getAge() {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", registrationDate=" + registrationDate +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                ", targetWeight=" + targetWeight +
                ", goal=" + goal +
                ", physicalActivityLevel=" + physicalActivityLevel +
                ", strengthTraining=" + strengthTraining +
                '}';
        // Seguridad: ¡NO incluimos passwordHash para evitar exponer claves!
    }
}
