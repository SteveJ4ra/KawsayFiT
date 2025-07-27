package edu.unl.cc.kawsayfit.controller;

import edu.unl.cc.kawsayfit.exception.CredentialInvalidException;
import edu.unl.cc.kawsayfit.exception.EncryptorException;
import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.repository.UserRepository;
import edu.unl.cc.kawsayfit.util.PasswordUtils;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named
public class AuthController {

    @Inject
    private UserRepository userRepository;

    public User validateUser(String email, String password) throws CredentialInvalidException {
        // Busca el usuario o lanza excepción si no existe
        User user = userRepository.findByEmail(email).orElseThrow(CredentialInvalidException::new);

        try {
            // Verifica la contraseña con la utilidad, puede lanzar EncryptorException
            if (PasswordUtils.verifyPassword(password, user.getPasswordHash(), user.getSalt())) {
                return user;
            } else {
                throw new CredentialInvalidException("Contraseña incorrecta");
            }
        } catch (EncryptorException e) {
            // Aquí "envolvemos" el error técnico en excepción de credenciales inválidas para no exponer detalles
            throw new CredentialInvalidException("Error verificando contraseña", e);
        }
    }
}

