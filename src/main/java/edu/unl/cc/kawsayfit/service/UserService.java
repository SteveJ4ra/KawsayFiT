package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.controller.AuthController;
import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.exception.CredentialInvalidException;
import edu.unl.cc.kawsayfit.exception.EncryptorException;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.model.enums.Goal;
import edu.unl.cc.kawsayfit.model.enums.PhysicalActivityLevel;
import edu.unl.cc.kawsayfit.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped
public class UserService {

    private String email;
    private String password;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserSession userSession;

    @Inject
    private AuthController authController;

    public String login(String email, String password) {
        try {
            User user = authController.validateUser(email, password);
            userSession.setLoggedUser(user);
            return "dashboard.xhtml?faces-redirect=true";
        } catch (CredentialInvalidException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales inválidas", null));
        } catch (EncryptorException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al encriptar la contraseña", null));
        }
        return null;
    }

    @Transactional
    public User register(User user) {
        user.setRegistrationDate(LocalDate.now());
        try {
            return userRepository.save(user);
        }catch (PersistenceException e) {
            throw new RuntimeException("El correo ya se encuentra registrado", e);
        }
    }

    @Transactional
    public User update(User user) {
        return userRepository.update(user);
    }

    @Transactional
    public void updateGoal(User user, Goal newGoal) {
        System.out.println("Actualizando objetivo a: " + newGoal);
        user.setGoal(newGoal);
        userRepository.update(user);
    }

    public void updateWeight(User user, double newWeight) {
        user.setWeight(newWeight);
        userRepository.update(user);
    }

    @Transactional
    public void updateActivityLevel(User user, PhysicalActivityLevel level) {
        user.setPhysicalActivityLevel(level);
        userRepository.update(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }


}
