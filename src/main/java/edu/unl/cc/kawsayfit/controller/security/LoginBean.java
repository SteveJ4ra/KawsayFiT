package edu.unl.cc.kawsayfit.controller.security;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.logging.Logger;

@Named("loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private static final Logger logger = Logger.getLogger(LoginBean.class.getName());

    @Inject
    private UserService userService;

    @NotNull
    private String email;

    @NotNull
    @Size(min=8, message="Contraseña muy corta")
    private String password;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Método principal de login
    public String login() {
        logger.info("Intentando iniciar sesión con: " + email);

        try {
            User user = userService.validateUser(email, password);

            if (user != null) {
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getSessionMap()
                        .put("currentUser", user);

                return "/dashboard.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Correo o contraseña incorrectos", null));
                return null;
            }
        } catch (Exception e) {
            logger.severe("Error al iniciar sesión: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error inesperado al iniciar sesión", null));
            return null;
        }
    }
}
