package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.model.Dish;
import edu.unl.cc.kawsayfit.repository.DishRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class DishService {

    @Inject
    private DishRepository dishRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public List<Dish> search(String name) {
        return dishRepository.searchByName(name);
    }

    public Dish findById(Long id) {
        return dishRepository.findById(id);
    }
}
