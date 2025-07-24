package edu.unl.cc.kawsayfit.controller.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("dashboardBean")
@SessionScoped
public class DasboardBean implements Serializable {

    private String search;

    private List<String> dishList;

    public List<String> completeSuggestions(String query) {
        List<String> results = new ArrayList<>();
        for (String dish : dishList) {
            if (dish.toLowerCase().contains(query.toLowerCase())) {
                results.add(dish);
            }
            if (results.size() >= 10) {
                break;
            }
        }
        return results;
    }

    public String find() {
        System.out.println("Búsqueda realizada: " + search);
        return "dish?faces-redirect=true";
    }

    public String getSearching() {
        return search;
    }

    public void setSearching(String seaching) {
        this.search = seaching;
    }

    public DasboardBean() {
        dishList = new ArrayList<>();
        // Alimentos
        dishList.add("Huevos cocidos");
        dishList.add("Manzana");
        dishList.add("Pera");
        dishList.add("Piña");
        dishList.add("Papaya");
        dishList.add("Mango");
        dishList.add("Hamburguesa");
        dishList.add("Pizza");
        dishList.add("Alitas");
        dishList.add("Lasaña");
        dishList.add("Tacos");
        dishList.add("Shawarma");
        dishList.add("Yogurt");
        dishList.add("Tripa Mishki");
        dishList.add("Arroz con leche");
        dishList.add("Salchipapa");
        dishList.add("Papipollo");
        dishList.add("Chuzos (Carne en palito)");
        dishList.add("Naranja");
        dishList.add("Mandarina");
        dishList.add("Guayaba");
        dishList.add("Guanábana");
        dishList.add("Maduro");
        dishList.add("Kiwi");
        dishList.add("Zapote");
        dishList.add("Durazno");
        dishList.add("Sandía");
        dishList.add("Melón");

        // Desayunos
        dishList.add("Tamales");
        dishList.add("Humitas");
        dishList.add("Tigrillo");
        dishList.add("Quimbolitos");
        dishList.add("Mote sucio");
        dishList.add("Bolón");
        dishList.add("Empanada de verde");
        dishList.add("Empanada de viento");
        dishList.add("Empanada de yuca");
        dishList.add("Llapingachos");
        dishList.add("Bollo de pescado");
        dishList.add("Encebollado");
        dishList.add("Tostadas");
        dishList.add("Mote con chicharrón");
        dishList.add("Pan de yuca");
        dishList.add("Batidos");
        dishList.add("Café con pan");

        // Almuerzos y meriendas
        dishList.add("Ceviche de camarón");
        dishList.add("Pan con café");
        dishList.add("Cevichocho");
        dishList.add("Ceviche de pescado");
        dishList.add("Arroz con menestra y carne");
        dishList.add("Seco de pollo");
        dishList.add("Caldo de pollo");
        dishList.add("Caldo de bolas");
        dishList.add("Caldo de carne");
        dishList.add("Sopa de fideos");
        dishList.add("Aguado de gallina");
        dishList.add("Caldo de bagre");
        dishList.add("Sopa de maní");
        dishList.add("Guatita");
        dishList.add("Arroz marinero");
        dishList.add("Estofado de carne");
        dishList.add("Hornado");
        dishList.add("Cuy asado");
        dishList.add("Caldo de pata");
        dishList.add("Arroz con pescado frito");
        dishList.add("Arroz con pollo frito");
        dishList.add("Arroz con carne frita");
        dishList.add("Ceviche de concha");
        dishList.add("Ensalada de frutas");
        dishList.add("Arroz con longaniza");
        dishList.add("Fritada");
        dishList.add("Parrillada");
        dishList.add("Corviche");
        dishList.add("Arroz con pollo");
        dishList.add("Chaulafán");
        dishList.add("Menestrón");
        dishList.add("Seco de chivo");
        dishList.add("Ceviche mixto");
        dishList.add("Cangrejada");
        dishList.add("Repe");
        dishList.add("Alverjas con cuero");
        dishList.add("Locro de papa");
        dishList.add("Chivo al hueco");
        dishList.add("Sopa de habas");
        dishList.add("Yahuarlocro");
        dishList.add("Encocado de pescado");
        dishList.add("Chanfaina");
        dishList.add("Sopa de porotos");
    }

}

