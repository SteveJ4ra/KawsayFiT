package edu.unl.cc.kawsayfit.controller;

import edu.unl.cc.kawsayfit.model.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class UserSession implements Serializable {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean isLoggedIn() {
        return loggedUser != null;
    }

    public void logout() {
        loggedUser = null;
    }

    public User getCurrentUser() {
        return getLoggedUser();
    }

    public void setCurrentUser(User user) {
        setLoggedUser(user);
    }
}
