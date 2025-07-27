package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.controller.AuthController;
import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.exception.*;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.model.enums.PhysicalActivityLevel;
import edu.unl.cc.kawsayfit.repository.UserRepository;
import edu.unl.cc.kawsayfit.util.PasswordUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserSession userSession;

    @Inject
    private AuthController authController;

    @Transactional
    public String login(String email, String password) throws LoginFailedException {
        try {
            User user = authController.validateUser(email, password);
            if (user == null) {
                throw new LoginFailedException("Usuario no encontrado o credenciales inválidas");
            }
            userSession.setLoggedUser(user);
            logger.log(Level.INFO, "Usuario {0} ha iniciado sesión correctamente.", email);
            return "dashboard.xhtml?faces-redirect=true";
        } catch (CredentialInvalidException e) {
            logger.log(Level.WARNING, "Login fallido para email: " + email, e);
            throw new LoginFailedException("Credenciales inválidas", e);
        }
    }

    @Transactional
    public User register(User user) throws DuplicateEmailException, EncryptorException {
        user.setRegistrationDate(LocalDate.now());

        // Generar salt y hash de la contraseña aquí:
        String salt = PasswordUtils.generateSalt();
        String hashedPassword = PasswordUtils.hashPassword(user.getPasswordHash(), salt);
        user.setSalt(salt);
        user.setPasswordHash(hashedPassword);

        try {
            User savedUser = userRepository.save(user);
            logger.log(Level.INFO, "Usuario registrado con email: {0}", user.getEmail());
            return savedUser;
        } catch (PersistenceException e) {
            logger.log(Level.SEVERE, "Error registrando usuario con email: " + user.getEmail(), e);
            throw new DuplicateEmailException("El correo ya se encuentra registrado", e);
        }
    }


    @Transactional
    public User update(User user) throws EntityNotFoundException, UserUpdateException {
        validateUserForUpdate(user);
        return safeUpdate(user);
    }

    @Transactional
    public void updateGoal(User user, Goal newGoal) throws EntityNotFoundException, UserUpdateException {
        validateUserForUpdate(user);
        user.setGoal(newGoal);
        safeUpdate(user);
    }

    @Transactional
    public void updateWeight(User user, double newWeight) throws EntityNotFoundException, UserUpdateException {
        validateUserForUpdate(user);
        user.setWeight(newWeight);
        safeUpdate(user);
    }

    @Transactional
    public void updateActivityLevel(User user, PhysicalActivityLevel level) throws EntityNotFoundException, UserUpdateException {
        validateUserForUpdate(user);
        user.setPhysicalActivityLevel(level);
        safeUpdate(user);
    }

    public User findById(Long id) throws EntityNotFoundException {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new EntityNotFoundException("Usuario con ID " + id + " no encontrado");
        }
        return user;
    }

    private void validateUserForUpdate(User user) throws EntityNotFoundException {
        if (user == null || user.getId() == null) {
            throw new EntityNotFoundException("Usuario no encontrado para actualización");
        }
    }

    private User safeUpdate(User user) throws UserUpdateException {
        try {
            User updated = userRepository.update(user);
            logger.log(Level.INFO, "Usuario con ID {0} actualizado correctamente", user.getId());
            return updated;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error actualizando usuario con ID: " + (user != null ? user.getId() : "null"), e);
            throw new UserUpdateException("Error al actualizar el usuario: " + e.getMessage(), e);
        }
    }
}

