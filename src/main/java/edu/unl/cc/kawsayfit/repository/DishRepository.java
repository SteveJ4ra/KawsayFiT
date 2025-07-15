package edu.unl.cc.kawsayfit.repository;

import edu.unl.cc.kawsayfit.model.Dish;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class DishRepository {

    @PersistenceContext
    private EntityManager em;

    public Dish findById(Long id) {
        return em.find(Dish.class, id);
    }

    public List<Dish> findAll() {
        return em.createQuery("SELECT d FROM Dish d", Dish.class).getResultList();
    }

    public List<Dish> searchByName(String query) {
        return em.createQuery("SELECT d FROM Dish d WHERE LOWER(d.name) LIKE :query", Dish.class)
                .setParameter("query", "%" + query.toLowerCase() + "%")
                .getResultList();
    }
}
