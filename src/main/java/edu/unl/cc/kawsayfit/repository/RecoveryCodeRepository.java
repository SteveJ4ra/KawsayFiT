package edu.unl.cc.kawsayfit.repository;

import edu.unl.cc.kawsayfit.model.RecoveryCode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

@ApplicationScoped
public class RecoveryCodeRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(RecoveryCode code) {
        em.persist(code);
    }

    public Optional<RecoveryCode> findByEmail(String email) {
        return em.createQuery("SELECT r FROM RecoveryCode r WHERE r.email = :email", RecoveryCode.class)
                .setParameter("email", email)
                .getResultStream().findFirst();
    }

    public void deleteByEmail(String email) {
        em.createQuery("DELETE FROM RecoveryCode r WHERE r.email = :email")
                .setParameter("email", email)
                .executeUpdate();
    }
}
