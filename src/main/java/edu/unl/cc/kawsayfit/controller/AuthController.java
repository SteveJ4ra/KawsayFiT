package edu.unl.cc.kawsayfit.controller;

import edu.unl.cc.kawsayfit.exception.CredentialInvalidException;
import edu.unl.cc.kawsayfit.exception.EncryptorException;

import edu.unl.cc.kawsayfit.model.User;
import edu.unl.cc.kawsayfit.repository.UserRepository;
import edu.unl.cc.kawsayfit.util.EncryptorManager;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named
public class AuthController {

    @Inject
    private UserRepository userRepository;

    public User validateUser(String email, String password) throws CredentialInvalidException, EncryptorException {
        User user = userRepository.findByEmail(email).orElseThrow(CredentialInvalidException::new);

        String encrypted = EncryptorManager.encrypt(password);
        if (encrypted.equals(user.getPasswordHash())) {
            return user;
        }

        throw new CredentialInvalidException();
    }
}
