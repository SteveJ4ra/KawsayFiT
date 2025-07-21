package edu.unl.cc.kawsayfit.controller.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import edu.unl.cc.kawsayfit.business.Dish;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("dishBean")
@ViewScoped
public class DishBean implements Serializable {
    private String busqueda;
    private String tituloReceta;
    private String imagen;
    private String porcionTexto;
    private int calorias;
    private double proteinas;
    private double carbohidratos;
    private List<Dish> ingredientes;

    public DishBean() {
        ingredientes = new ArrayList<>();
    }

    public void buscar() {
        if (busqueda != null && busqueda.equalsIgnoreCase("ceviche")) {
            tituloReceta = "Ceviche de Camarón";
            imagen = "CevicheCamaron.png";
            porcionTexto = "1 porción (456 g)";
            calorias = 208;
            proteinas = 34.0;
            carbohidratos = 19.0;

            ingredientes.clear();
            ingredientes.add(new Dish("Camarones", 160));
            ingredientes.add(new Dish("Zumo de limón", 90));
            ingredientes.add(new Dish("Cebolla", 75));
            ingredientes.add(new Dish("Tomate", 65));
            ingredientes.add(new Dish("Cilantro", 6));
        } else {
            // Si no se encuentra la receta
            tituloReceta = "Receta no encontrada";
            imagen = "not_found.png";
            porcionTexto = "-";
            calorias = 0;
            proteinas = 0.0;
            carbohidratos = 0.0;
            ingredientes.clear();
        }
    }

    public String registrar() {
        return "registroConfirmado?faces-redirect=true";
    }


    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getTituloReceta() {
        return tituloReceta;
    }

    public void setTituloReceta(String tituloReceta) {
        this.tituloReceta = tituloReceta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPorcionTexto() {
        return porcionTexto;
    }

    public void setPorcionTexto(String porcionTexto) {
        this.porcionTexto = porcionTexto;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public List<Dish> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Dish> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
