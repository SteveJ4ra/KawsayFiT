package edu.unl.cc.kawsayfit.repository;

import edu.unl.cc.kawsayfit.exception.EntityNotFoundException;
import edu.unl.cc.kawsayfit.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;

@ApplicationScoped
public class UserRepository {

    private static final Map<Long, User> tableUserBD;

    static {
        tableUserBD = new TreeMap<>();
    }

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

    public User find(String name) throws EntityNotFoundException {
        User userFound = null;
        for (Map.Entry<Long, User> entry : tableUserBD.entrySet()) {
            User user = entry.getValue();
            if (Objects.equals(user.getEmail().toLowerCase(), name.toLowerCase())){
                userFound = entry.getValue();
                break;
            }
        }
        if (userFound == null){
            throw new EntityNotFoundException("User no encontrado con [" + name + "]");
        }
        return userFound;
    }
}
