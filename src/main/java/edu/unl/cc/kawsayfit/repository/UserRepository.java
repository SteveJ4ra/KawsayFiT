package edu.unl.cc.kawsayfit.repository;

import edu.unl.cc.kawsayfit.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

@ApplicationScoped
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public User update(User user) {
        return em.merge(user);
    }

    public Optional<User> findByEmail(String email) {
        try {
            return Optional.of(
                    em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                            .setParameter("email", email)
                            .getSingleResult()
            );
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }
}
