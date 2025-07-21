package edu.unl.cc.kawsayfit.controller.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("recoverPwdsBean")
@ViewScoped
public class RecoverPwdsBean implements Serializable {
    private String correo;
    private boolean mostrarModal;

    public void enviarCodigo() {
        //TODO
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public boolean isMostrarModal() { return mostrarModal; }
    public void setMostrarModal(boolean mostrarModal) { this.mostrarModal = mostrarModal; }
}
