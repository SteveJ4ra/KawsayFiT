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

    // Crear usuario
    public User save(User user) {
        em.persist(user);
        return user;
    }

    // Actualizar usuario
    public User update(User user) {
        return em.merge(user);
    }

    // Buscar usuario por email
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

    // Buscar usuario por ID
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    // Eliminar usuario (por objeto)
    public void delete(User user) {
        if (!em.contains(user)) {
            user = em.merge(user);
        }
        em.remove(user);
    }

    // Eliminar usuario por ID
    public void deleteById(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }
}
