package edu.unl.cc.kawsayfit.exception;

public class DuplicateEmailException extends Exception {
    public DuplicateEmailException() {
        super("Correo electrónico ya registrado");
    }

    public DuplicateEmailException(String message) {
        super(message);
    }

    public DuplicateEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
