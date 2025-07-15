package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.model.*;
import edu.unl.cc.kawsayfit.repository.ConsumedDishRepository;
import edu.unl.cc.kawsayfit.repository.DailyLogRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class HistoryService {

    @Inject
    private DailyLogRepository dailyLogRepository;

    @Inject
    private ConsumedDishRepository consumedDishRepository;

    public DailyLog getOrCreateTodayLog(User user) {
        LocalDate today = LocalDate.now();
        DailyLog log = dailyLogRepository.findByUserAndDate(user, today);
        if (log == null) {
            log = new DailyLog();
            log.setDate(today);
            log.setUser(user);
            dailyLogRepository.save(log);
        }
        return log;
    }

    public ConsumedDish addDishToToday(User user, Dish dish, int servings) {
        DailyLog log = getOrCreateTodayLog(user);

        ConsumedDish consumed = new ConsumedDish();
        consumed.setUser(user);
        consumed.setDish(dish);
        consumed.setServings(servings);
        consumed.setDailyLog(log);

        log.getConsumedDishes().add(consumed);
        consumedDishRepository.save(consumed);
        dailyLogRepository.update(log);

        return consumed;
    }

    public List<DailyLog> getHistory(User user) {
        return dailyLogRepository.findAllByUser(user);
    }
}
