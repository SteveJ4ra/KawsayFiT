package edu.unl.cc.kawsayfit.controller.beans;


import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("profileBean")
@ViewScoped
public class ProfileBean implements Serializable {
    private String fotoPerfil;
    private String nombreCompleto;
    private String email;
    private int edad;
    private double altura; // en cm
    private double peso;   // en kg
    private double imc;
    private String estadoImc;

    private String objetivo;

    private int caloriasConsumidas;
    private int caloriasMeta;
    private int proteinasConsumidas;
    private int proteinasMeta;
    private int carbohidratosConsumidos;
    private int carbohidratosMeta;

    public ProfileBean() {
        fotoPerfil = "avatar_default.png";
        nombreCompleto = "Juan Pérez";
        email = "juan.perez@example.com";
        edad = 29;
        altura = 175; // cm
        peso = 72;    // kg

        calcularImc();

        objetivo = "Perder grasa";

        caloriasConsumidas = 1300;
        caloriasMeta = 2000;

        proteinasConsumidas = 80;
        proteinasMeta = 120;

        carbohidratosConsumidos = 180;
        carbohidratosMeta = 250;
    }

    private void calcularImc() {
        if (altura > 0) {
            double alturaEnMetros = altura / 100.0;
            imc = peso / (alturaEnMetros * alturaEnMetros);

            if (imc < 18.5) estadoImc = "Bajo peso";
            else if (imc < 25) estadoImc = "Normal";
            else if (imc < 30) estadoImc = "Sobrepeso";
            else estadoImc = "Obesidad";
        } else {
            imc = 0;
            estadoImc = "No definido";
        }
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
        calcularImc();
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        calcularImc();
    }

    public double getImc() {
        return Math.round(imc * 10) / 10.0;
    }

    public String getEstadoImc() {
        return estadoImc;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getCaloriasConsumidas() {
        return caloriasConsumidas;
    }

    public void setCaloriasConsumidas(int valor) {
        this.caloriasConsumidas = valor;
    }

    public int getCaloriasMeta() {
        return caloriasMeta;
    }

    public void setCaloriasMeta(int valor) {
        this.caloriasMeta = valor;
    }

    public int getProteinasConsumidas() {
        return proteinasConsumidas;
    }

    public void setProteinasConsumidas(int valor) {
        this.proteinasConsumidas = valor;
    }

    public int getProteinasMeta() {
        return proteinasMeta;
    }

    public void setProteinasMeta(int valor) {
        this.proteinasMeta = valor;
    }

    public int getCarbohidratosConsumidos() {
        return carbohidratosConsumidos;
    }

    public void setCarbohidratosConsumidos(int valor) {
        this.carbohidratosConsumidos = valor;
    }

    public int getCarbohidratosMeta() {
        return carbohidratosMeta;
    }

    public void setCarbohidratosMeta(int valor) {
        this.carbohidratosMeta = valor;
    }
}
