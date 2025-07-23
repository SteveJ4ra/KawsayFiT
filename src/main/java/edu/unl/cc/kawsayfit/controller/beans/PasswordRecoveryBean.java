package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.repository.UserRepository;
import edu.unl.cc.kawsayfit.util.EncryptorManager;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named
@ViewScoped
public class PasswordRecoveryBean implements Serializable {

    private String email;
    private String confirmationCode;
    private String newPassword;
    private String confirmPassword;
    private String message;
    private boolean codeSent;

    // Simula códigos temporales (en memoria)
    private static final Map<String, String> tempCodes = new HashMap<>();

    @Inject
    private UserRepository userRepository;

    
    public String sendCode() {
        String code = generateMockCode();
        tempCodes.put(email, code);
        codeSent = true;

        return "reset-password?faces-redirect=true";
    }

    public void resetPassword() {
        if (!newPassword.equals(confirmPassword)) {
            message = "Las contraseñas no coinciden.";
            return;
        }

        String storedCode = tempCodes.get(email);
        if (storedCode == null || !storedCode.equals(confirmationCode)) {
            message = "Código de confirmación inválido.";
            return;
        }

        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            message = "Usuario no encontrado.";
            return;
        }

        try {
            String encrypted = EncryptorManager.encrypt(newPassword);
            user.setPasswordHash(encrypted);
            userRepository.update(user);
            message = "Contraseña actualizada con éxito.";
            tempCodes.remove(email);
            clearForm();
        } catch (Exception e) {
            message = "Error al actualizar la contraseña: " + e.getMessage();
        }
    }

    private String generateMockCode() {


        return "123456"; // es la app debe generar aleatoriamente esto
    }

    private void clearForm() {
        confirmationCode = "";
        newPassword = "";
        confirmPassword = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

    public boolean isCodeSent() {
        return codeSent;
    }
}
