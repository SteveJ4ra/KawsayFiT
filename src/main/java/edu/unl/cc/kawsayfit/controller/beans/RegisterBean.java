package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class RegisterBean implements Serializable {

    private String email;
    private String username;
    private String password;
    private String confirmPassword;

    private String message;
    private boolean registered;

    @Inject
    private UserService userService;

    @PostConstruct
    public void init() {
        registered = false;
    }

    public String register() {
        if (!password.equals(confirmPassword)) {
            message = "Las contraseñas no coinciden.";
            return null;
        }

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPasswordHash(password); // Usar Encryptor manager después

        userService.register(user);
        registered = true;
        message = "Usuario registrado con éxito.";
        clearForm();

        return "select-target.xhtml?faces-redirect=true";
    }

    private void clearForm() {
        email = "";
        username = "";
        password = "";
        confirmPassword = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRegistered() {
        return registered;
    }
}
