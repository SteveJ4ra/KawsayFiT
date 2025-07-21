package edu.unl.cc.kawsayfit.repository;

import edu.unl.cc.kawsayfit.model.ConsumedDish;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ConsumedDishRepository {

    @PersistenceContext
    private EntityManager em;

    public ConsumedDish save(ConsumedDish consumedDish) {
        em.persist(consumedDish);
        return consumedDish;
    }

    public ConsumedDish update(ConsumedDish consumedDish) {
        return em.merge(consumedDish);
    }

    public void delete(ConsumedDish consumedDish) {
        if (!em.contains(consumedDish)) {
            consumedDish = em.merge(consumedDish);
        }
        em.remove(consumedDish);
    }
}
