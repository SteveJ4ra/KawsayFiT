package edu.unl.cc.kawsayfit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "daily_logs")
public class DailyLog {

    public DailyLog() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "dailyLog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsumedDish> consumedDishes = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(@NotNull LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ConsumedDish> getConsumedDishes() {
        return consumedDishes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DailyLog{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", user=").append(user);
        sb.append(", consumedDishes=").append(consumedDishes);
        sb.append('}');
        return sb.toString();
    }
}
