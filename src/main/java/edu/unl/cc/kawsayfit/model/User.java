package edu.unl.cc.kawsayfit.model;

import edu.unl.cc.kawsayfit.model.enums.Gender;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.model.enums.PhysicalActivityLevel;
import edu.unl.cc.kawsayfit.service.Calculator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements Serializable {

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    private LocalDate registrationDate;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Column(nullable = false)
    private double weight;

    @NotNull
    @Column(nullable = false)
    private double height;

    @NotNull
    @Column(nullable = false)
    private double targetWeight;

    @NotNull
    @Column(nullable = false)
    private double imc;

    @Enumerated(EnumType.STRING)
    private Goal goal;

    @Enumerated(EnumType.STRING)
    @Column(name = "physicalActivityLevel")
    private PhysicalActivityLevel physicalActivityLevel;

    @NotNull
    @Column(nullable = false)
    private boolean strengthTraining;

    @Column(nullable = true)
    private String velocity;

    @Column(nullable = false)
    private String salt;

    public double calculate() {
        Calculator calculator = new Calculator();
        imc = calculator.calculateIMC(weight, height);
        return imc;
    }

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Devuelve la edad en base al campo birthDate.
     */
    public int getAge() {
        if (birthDate == null) return 0;
        LocalDate birthLocal = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(birthLocal, LocalDate.now()).getYears();
    }
    
}
