package edu.unl.cc.kawsayfit.service;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("search")
@SessionScoped
public class SearchSuggestions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String busqueda;

    // Lista simulada de platos (puedes reemplazar con base de datos)
    private List<String> listaPlatos;

    // Método para autocompletado
    public List<String> completeSuggestions(String query) {
        List<String> resultados = new ArrayList<>();
        for (String plato : listaPlatos) {
            if (plato.toLowerCase().contains(query.toLowerCase())) {
                resultados.add(plato);
            }
            if (resultados.size() >= 10) { // Limita a 10 sugerencias
                break;
            }
        }
        return resultados;
    }

    // Acción del botón "Buscar"
    public String buscar() {
        System.out.println("Búsqueda realizada: " + busqueda);
        // Aquí podrías redirigir o filtrar una receta específica
        return "dish?faces-redirect=true"; // O la vista que desees mostrar
    }

    // Getters y Setters
    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public SearchSuggestions() {
        listaPlatos = new ArrayList<>();

        // Alimentos
        listaPlatos.add("Huevos cocidos");
        listaPlatos.add("Manzana");
        listaPlatos.add("Pera");
        listaPlatos.add("Piña");
        listaPlatos.add("Papaya");
        listaPlatos.add("Mango");
        listaPlatos.add("Hamburguesa");
        listaPlatos.add("Pizza");
        listaPlatos.add("Alitas");
        listaPlatos.add("Lasaña");
        listaPlatos.add("Tacos");
        listaPlatos.add("Shawarma");
        listaPlatos.add("Yogurt");
        listaPlatos.add("Tripa Mishki");
        listaPlatos.add("Arroz con leche");
        listaPlatos.add("Salchipapa");
        listaPlatos.add("Papipollo");
        listaPlatos.add("Chuzos (Carne en palito)");
        listaPlatos.add("Naranja");
        listaPlatos.add("Mandarina");
        listaPlatos.add("Guayaba");
        listaPlatos.add("Guanábana");
        listaPlatos.add("Maduro");
        listaPlatos.add("Kiwi");
        listaPlatos.add("Zapote");
        listaPlatos.add("Durazno");
        listaPlatos.add("Sandía");
        listaPlatos.add("Melón");

        // Desayunos
        listaPlatos.add("Tamales");
        listaPlatos.add("Humitas");
        listaPlatos.add("Tigrillo");
        listaPlatos.add("Quimbolitos");
        listaPlatos.add("Mote sucio");
        listaPlatos.add("Bolón");
        listaPlatos.add("Empanada de verde");
        listaPlatos.add("Empanada de viento");
        listaPlatos.add("Empanada de yuca");
        listaPlatos.add("Llapingachos");
        listaPlatos.add("Bollo de pescado");
        listaPlatos.add("Encebollado");
        listaPlatos.add("Tostadas");
        listaPlatos.add("Mote con chicharrón");
        listaPlatos.add("Pan de yuca");
        listaPlatos.add("Batidos");
        listaPlatos.add("Café con pan");

        // Almuerzos y meriendas
        listaPlatos.add("Ceviche de camarón");
        listaPlatos.add("Pan con café");
        listaPlatos.add("Cevichocho");
        listaPlatos.add("Ceviche de pescado");
        listaPlatos.add("Arroz con menestra y carne");
        listaPlatos.add("Seco de pollo");
        listaPlatos.add("Caldo de pollo");
        listaPlatos.add("Caldo de bolas");
        listaPlatos.add("Caldo de carne");
        listaPlatos.add("Sopa de fideos");
        listaPlatos.add("Aguado de gallina");
        listaPlatos.add("Caldo de bagre");
        listaPlatos.add("Sopa de maní");
        listaPlatos.add("Guatita");
        listaPlatos.add("Arroz marinero");
        listaPlatos.add("Estofado de carne");
        listaPlatos.add("Hornado");
        listaPlatos.add("Cuy asado");
        listaPlatos.add("Caldo de pata");
        listaPlatos.add("Arroz con pescado frito");
        listaPlatos.add("Arroz con pollo frito");
        listaPlatos.add("Arroz con carne frita");
        listaPlatos.add("Ceviche de concha");
        listaPlatos.add("Ensalada de frutas");
        listaPlatos.add("Arroz con longaniza");
        listaPlatos.add("Fritada");
        listaPlatos.add("Parrillada");
        listaPlatos.add("Corviche");
        listaPlatos.add("Arroz con pollo");
        listaPlatos.add("Chaulafán");
        listaPlatos.add("Menestrón");
        listaPlatos.add("Seco de chivo");
        listaPlatos.add("Ceviche mixto");
        listaPlatos.add("Cangrejada");
        listaPlatos.add("Repe");
        listaPlatos.add("Alverjas con cuero");
        listaPlatos.add("Locro de papa");
        listaPlatos.add("Chivo al hueco");
        listaPlatos.add("Sopa de habas");
        listaPlatos.add("Yahuarlocro");
        listaPlatos.add("Encocado de pescado");
        listaPlatos.add("Chanfaina");
        listaPlatos.add("Sopa de porotos");
    }

}

