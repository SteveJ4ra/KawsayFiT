package edu.unl.cc.kawsayfit.exception;

public class UserUpdateException extends Exception {
    public UserUpdateException() {
        super("Error al actualizar usuario");
    }

    public UserUpdateException(String message) {
        super(message);
    }

    public UserUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
