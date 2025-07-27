package edu.unl.cc.kawsayfit.exception;

public class LoginFailedException extends Exception {
    public LoginFailedException() {
        super("Error de inicio de sesión");
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
