package edu.unl.cc.kawsayfit.controller;

import edu.unl.cc.kawsayfit.exception.CredentialInvalidException;
import edu.unl.cc.kawsayfit.exception.EncryptorException;
import edu.unl.cc.kawsayfit.exception.EntityNotFoundException;
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

    public User validateUser(String name, String password) throws CredentialInvalidException, EncryptorException {
        try{
            User userFound = userRepository.find(name);
            String pwdEncrypted = EncryptorManager.encrypt(password);

            if (pwdEncrypted.equals(userFound.getPasswordHash())){
                return userFound;
            }
            throw new CredentialInvalidException();
        } catch (EntityNotFoundException e){
            throw new CredentialInvalidException();
        }
    }


}
