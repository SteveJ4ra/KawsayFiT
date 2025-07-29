package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.model.Dish;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class DishService implements Serializable {

    @PersistenceContext
    private EntityManager em;

    private List<Dish> ecuadorDishes;

    @PostConstruct
    public void init() {
        ecuadorDishes = em.createQuery("SELECT d FROM Dish d", Dish.class).getResultList();
    }

    public Dish findByName(String name) {
        return ecuadorDishes.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name.trim()))
                .findFirst()
                .orElse(null);
    }

    public List<String> getAllDishNames() {
        return ecuadorDishes.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public Dish findById(Long id) {
        return ecuadorDishes.stream()
                .filter(d -> id.equals(d.getId()))
                .findFirst()
                .orElse(null);
    }

}