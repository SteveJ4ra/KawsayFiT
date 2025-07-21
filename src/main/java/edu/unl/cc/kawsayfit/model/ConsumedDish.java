package edu.unl.cc.kawsayfit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "consumed_dishes")
public class ConsumedDish {

    public ConsumedDish() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne(optional = false)
    @JoinColumn(name = "daily_log_id")
    private DailyLog dailyLog;

    @Positive
    @Column(nullable = false)
    private int servings;

    @Transient
    public double getTotalCalories() {
        return servings * dish.getCaloriesPerServing();
    }

    @Transient
    public double getTotalProteins() {
        return servings * dish.getProteins();
    }

    @Transient
    public double getTotalCarbohydrates() {
        return servings * dish.getCarbohydrates();
    }

    @Transient
    public double getTotalFats() {
        return servings * dish.getFats();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public @Positive int getServings() {
        return servings;
    }

    public void setServings(@Positive int servings) {
        this.servings = servings;
    }

    public DailyLog getDailyLog() {
        return dailyLog;
    }

    public void setDailyLog(DailyLog dailyLog) {
        this.dailyLog = dailyLog;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConsumedDish{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", dish=").append(dish);
        sb.append(", dailyLog=").append(dailyLog);
        sb.append(", servings=").append(servings);
        sb.append('}');
        return sb.toString();
    }
}
