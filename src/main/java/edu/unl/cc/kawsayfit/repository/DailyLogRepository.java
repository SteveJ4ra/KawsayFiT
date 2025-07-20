package edu.unl.cc.kawsayfit.repository;

import edu.unl.cc.kawsayfit.model.DailyLog;
import edu.unl.cc.kawsayfit.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DailyLogRepository {

    @PersistenceContext(unitName = "KawsayFitPU")
    private EntityManager em;

    public DailyLog save(DailyLog log) {
        em.persist(log);
        return log;
    }

    public DailyLog update(DailyLog log) {
        return em.merge(log);
    }

    public DailyLog findByUserAndDate(User user, LocalDate date) {
        try {
            return em.createQuery(
                            "SELECT l FROM DailyLog l WHERE l.user = :user AND l.date = :date", DailyLog.class)
                    .setParameter("user", user)
                    .setParameter("date", date)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<DailyLog> findAllByUser(User user) {
        return em.createQuery(
                        "SELECT l FROM DailyLog l WHERE l.user = :user ORDER BY l.date DESC", DailyLog.class)
                .setParameter("user", user)
                .getResultList();
    }
}
