package edu.unl.cc.kawsayfit.controller.beans;


import edu.unl.cc.kawsayfit.model.Food;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("dashboardBean")
@ViewScoped
public class DasboardBean implements Serializable{

    private List<Food> listFood;
    private List<String> suggestion;

    public DasboardBean() {
        loadFood();
        makeSuggestion();
    }

    @Inject
    //TODO
    private void loadFood() {
        listFood = new ArrayList<>();
        listFood.add(new Food("AguadoGallina", "images/AguadoGallina.png"));
        listFood.add(new Food("AlitasAsadas", "images/AlitasAsadas.png"));
        listFood.add(new Food("AlverjasCuero", "images/AlverjasCuero.png"));
        listFood.add(new Food("ArrozCarneFrita", "images/ArrozCarneFrita.png"));
        listFood.add(new Food("ArrozConLeche", "images/ArrozConLeche.png"));
        listFood.add(new Food("ArrozLonganiza", "images/ArrozLonganiza.png"));
        listFood.add(new Food("ArrozMarinero", "images/ArrozMarinero.png"));
        listFood.add(new Food("ArrozPescadoFrito", "images/ArrozPescadoFrito.png"));
        listFood.add(new Food("ArrozPolloFrito", "images/ArrozPolloFrito.png"));
        listFood.add(new Food("Banana", "images/Banana.png"));
        listFood.add(new Food("Batido", "images/Batido.png"));
        listFood.add(new Food("BolloPescado", "images/BolloPescado.png"));
        listFood.add(new Food("Bolon", "images/Bolon.png"));
        listFood.add(new Food("CafePan", "images/CafePan.png"));
        listFood.add(new Food("CaldoBagre", "images/CaldoBagre.png"));
        listFood.add(new Food("CaldoBola", "images/CaldoBola.png"));
        listFood.add(new Food("CaldoCarne", "images/CaldoCarne.png"));
        listFood.add(new Food("CaldoPata", "images/CaldoPata.png"));
        listFood.add(new Food("CaldoPollo", "images/CaldoPollo.png"));
        listFood.add(new Food("Cangrejeada", "images/Cangrejeada.png"));
        listFood.add(new Food("CevicheCamaron", "images/CevicheCamaron.png"));
        listFood.add(new Food("CevicheConcha", "images/CevicheConcha.png"));
        listFood.add(new Food("CevicheMixto", "images/CevicheMixto.png"));
        listFood.add(new Food("CevichePescado", "images/CevichePescado.png"));
        listFood.add(new Food("Cevichocho", "images/Cevichocho.png"));
        listFood.add(new Food("Chanfaina", "images/Chanfaina.png"));
        listFood.add(new Food("Chaulafan", "images/Chaulafan.png"));
        listFood.add(new Food("ChivoHueco", "images/ChivoHueco.png"));
        listFood.add(new Food("ChuzosCarne", "images/ChuzosCarne.png"));
        listFood.add(new Food("Corviche", "images/Corviche.png"));
        listFood.add(new Food("CuyAsado", "images/CuyAsado.png"));
        listFood.add(new Food("Durazno", "images/Durazno.png"));
        listFood.add(new Food("EmpanadaVerde", "images/EmpanadaVerde.png"));
        listFood.add(new Food("EmpanadaViento", "images/EmpanadaViento.png"));
        listFood.add(new Food("EmpanadaYuca", "images/EmpanadaYuca.png"));
        listFood.add(new Food("Encebollado", "images/Encebollado.png"));
        listFood.add(new Food("EncocadoPescado", "images/EncocadoPescado.png"));
        listFood.add(new Food("EnsaladaFrutas", "images/EnsaladaFrutas.png"));
        listFood.add(new Food("EstofadoCarne", "images/EstofadoCarne.png"));
        listFood.add(new Food("FondoKawsayFit", "images/FondoKawsayFit.png"));
        listFood.add(new Food("Fritada", "images/Fritada.png"));
        listFood.add(new Food("Guanabana", "images/Guanabana.png"));
        listFood.add(new Food("Guatita", "images/Guatita.png"));
        listFood.add(new Food("Guayaba", "images/Guayaba.png"));
        listFood.add(new Food("Hamburguesa", "images/Hamburguesa.png"));
        listFood.add(new Food("Hornado", "images/Hornado.png"));
        listFood.add(new Food("HuevosCocidos", "images/HuevosCocidos.png"));
        listFood.add(new Food("Humita", "images/Humita.png"));
        listFood.add(new Food("KawsayFit", "images/KawsayFit.png"));
        listFood.add(new Food("Kiwi", "images/Kiwi.png"));
        listFood.add(new Food("Lasagna", "images/Lasagna.png"));
        listFood.add(new Food("Llapingachos", "images/Llapingachos.png"));
        listFood.add(new Food("LocroPapa", "images/LocroPapa.png"));
        listFood.add(new Food("Mandarina", "images/Mandarina.png"));
        listFood.add(new Food("Mango", "images/Mango.png"));
    }


    private void makeSuggestion() {
        suggestion = new ArrayList<>();
        for (Food food : listFood) {
            suggestion.add(food.getName());
        }
    }

    public List<Food> getFoodList() {
        return listFood;
    }

    public List<String> getSuggestion() {
        return suggestion;
    }

}
