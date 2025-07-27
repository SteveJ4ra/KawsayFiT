package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;


@Named("loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;

    @Inject
    private UserService userservice;

    public String login() {
        return userservice.login(email, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
