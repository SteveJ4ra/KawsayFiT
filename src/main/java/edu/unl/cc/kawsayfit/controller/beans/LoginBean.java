package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.exception.CredentialInvalidException;
import edu.unl.cc.kawsayfit.exception.EncryptorException;
import edu.unl.cc.kawsayfit.exception.LoginFailedException;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;


@Named("loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;

    @Inject
    private UserService userService;

    public String login() {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Campos requeridos", "Email y contraseña son obligatorios"));
            return null;
        }
        try {
            return userService.login(email, password);
        } catch (LoginFailedException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al iniciar sesión", e.getMessage()));
            return null;
        } finally {
            password = null; // limpiar la contraseña de memoria
        }
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
