package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.model.enums.PhysicalActivityLevel;
import edu.unl.cc.kawsayfit.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public Optional<User> login(String email, String rawPassword) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPasswordHash().equals(rawPassword)); // Simplificado. Usa hashing en producción.
    }

    public User register(User user) {
        user.setRegistrationDate(LocalDate.now());
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public void updateGoal(User user, Goal newGoal) {
        user.setGoal(newGoal);
        userRepository.update(user);
    }

    public void updateWeight(User user, double newWeight) {
        user.setWeight(newWeight);
        userRepository.update(user);
    }

    public void updateActivityLevel(User user, PhysicalActivityLevel level) {
        user.setPhysicalActivityLevel(level);
        userRepository.update(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
