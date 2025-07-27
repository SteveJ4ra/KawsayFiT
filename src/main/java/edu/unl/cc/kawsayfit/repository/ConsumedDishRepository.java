package edu.unl.cc.kawsayfit.repository;

import edu.unl.cc.kawsayfit.model.ConsumedDish;
import edu.unl.cc.kawsayfit.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ConsumedDishRepository {

    @PersistenceContext
    private EntityManager em;

    public List<ConsumedDish> findByUser(User user) {
        return em.createQuery("SELECT c FROM ConsumedDish c WHERE c.user = :user", ConsumedDish.class)
                .setParameter("user", user)
                .getResultList();
    }
}
