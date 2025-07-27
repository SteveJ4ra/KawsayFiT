package edu.unl.cc.kawsayfit.controller;

import edu.unl.cc.kawsayfit.exception.EntityNotFoundException;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class UserSession implements Serializable {

    private Long userId;

    private User loggedUser;

    @Inject
    private UserService userService;

    public void setLoggedUser(User user) {
        this.loggedUser = user;
        this.userId = user.getId();
    }

    public boolean isLoggedIn() {
        return loggedUser != null || userId != null;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public User getCurrentUser() {
        if (loggedUser != null) {
            return loggedUser;
        }
        if (userId != null) {
            try {
                User userFromDb = userService.findById(userId);
                this.loggedUser = userFromDb;
                return userFromDb;
            }catch (EntityNotFoundException e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no encontrado", e.getMessage()));
                return null;
            }

        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Usuario no autenticado."));
        return null;
    }
}
