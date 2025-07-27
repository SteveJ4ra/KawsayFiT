package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.controller.UserSession;
import edu.unl.cc.kawsayfit.exception.DuplicateEmailException;
import edu.unl.cc.kawsayfit.exception.EncryptorException;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("registerBean")
@ViewScoped
public class RegisterBean implements Serializable {

    private String email;
    private String username;
    private String password;
    private String confirmPassword;

    @Inject
    private UserSession userSession;

    @Inject
    private UserService userService;

    public String register() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (!password.equals(confirmPassword)) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Las contraseñas no coinciden", null));
            return null;
        }

        try {
            User user = new User();
            user.setEmail(email.trim().toLowerCase());
            user.setUsername(username.trim());
            user.setPasswordHash(password); // Aquí sin hashear, el service lo hará

            User savedUser = userService.register(user);
            userSession.setLoggedUser(savedUser);

            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Usuario registrado con éxito", null));

            clearForm();
            return "select-target.xhtml?faces-redirect=true";

        } catch (DuplicateEmailException e) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Ese correo ya está registrado", null));

        } catch (EncryptorException e) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al encriptar la contraseña", null));

        } catch (Exception e) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Ocurrió un error inesperado al registrarte", null));
        }

        return null;
    }


    private void clearForm() {
        password = null;
        confirmPassword = null;
    }

    // Getters y Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}
