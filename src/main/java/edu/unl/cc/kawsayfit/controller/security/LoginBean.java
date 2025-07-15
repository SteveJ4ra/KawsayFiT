package edu.unl.cc.kawsayfit.controller.security;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.logging.Logger;

@Named("loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private static Logger logger = Logger.getLogger(LoginBean.class.getName());

    @NotNull
    private String email;

    @NotNull
    @Size(min=8, message="Contraseña muy corta")
    private String password;

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

    //metodos

    public String login(){
        logger.info("Logging in with username: " + email);
        logger.info("Logging in with password: " + password);

        try {
        } catch (Exception e) {
            return null;
        }
        return "index";
    }
}
