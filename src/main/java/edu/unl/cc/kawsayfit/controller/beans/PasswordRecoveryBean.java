package edu.unl.cc.kawsayfit.controller.beans;

import edu.unl.cc.kawsayfit.exception.EncryptorException;
import edu.unl.cc.kawsayfit.model.RecoveryCode;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.repository.RecoveryCodeRepository;
import edu.unl.cc.kawsayfit.repository.UserRepository;
import edu.unl.cc.kawsayfit.util.PasswordUtils;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;

@Named("passwordRecoveryBean")
@ViewScoped
public class PasswordRecoveryBean implements Serializable {

    private String email;
    private String confirmationCode;
    private String newPassword;
    private String confirmPassword;
    private String message;
    private boolean codeSent;

    @Inject
    private UserRepository userRepository;

    @Inject
    private RecoveryCodeRepository recoveryCodeRepository;

    public String sendCode() {
        String code = generateRandomCode();

        recoveryCodeRepository.deleteByEmail(email);

        RecoveryCode recovery = new RecoveryCode();
        recovery.setEmail(email);
        recovery.setCode(code);
        recovery.setExpirationTime(LocalDateTime.now().plusMinutes(10));
        recoveryCodeRepository.save(recovery);

        codeSent = true;
        return "reset-password?faces-redirect=true";
    }

    public void resetPassword() {
        if (!newPassword.equals(confirmPassword)) {
            message = "Las contraseñas no coinciden.";
            return;
        }

        RecoveryCode storedCode = recoveryCodeRepository.findByEmail(email).orElse(null);
        if (storedCode == null || !storedCode.getCode().equals(confirmationCode)) {
            message = "Código de confirmación inválido.";
            return;
        }

        if (storedCode.getExpirationTime().isBefore(LocalDateTime.now())) {
            message = "El código ha expirado.";
            return;
        }

        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            message = "Usuario no encontrado.";
            return;
        }

        try {
            // Generar nuevo salt y hashear la contraseña
            String salt = PasswordUtils.generateSalt();
            String hashedPassword = PasswordUtils.hashPassword(newPassword, salt);

            // Actualizar el usuario con nueva contraseña y salt
            user.setPasswordHash(hashedPassword);
            user.setSalt(salt);

            userRepository.update(user);
            recoveryCodeRepository.deleteByEmail(email); // limpieza
            message = "Contraseña actualizada con éxito.";
            clearForm();
        } catch (EncryptorException e) {
            message = "Error al actualizar la contraseña: " + e.getMessage();
        }

    }

    private String generateRandomCode() {
        int code = (int) (Math.random() * 900000) + 100000; // Genera un número entre 100000 y 999999
        return String.valueOf(code);
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
