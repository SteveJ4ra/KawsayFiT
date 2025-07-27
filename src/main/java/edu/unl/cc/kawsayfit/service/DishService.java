package edu.unl.cc.kawsayfit.service;

import edu.unl.cc.kawsayfit.model.Dish;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class  DishService implements Serializable {

    private List<Dish> platosEcuatorianos;

    @PostConstruct
    public void init() {
        platosEcuatorianos = new ArrayList<>();

        platosEcuatorianos.add(new Dish(
                "Encebollado",
                "Sopa tradicional de pescado",
                "Hola mundo",
                "Encebollado.png",
                300,
                20.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Manzana",
                "1 unidad mediana (182 g)",
                "sdfasd",
                "ManzanaRoja.png",
                95,
                0.5,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pera",
                "1 unidad mediana (178 g)",
                "sdfasd",
                "Pera.png",
                101,
                0.6,
                27.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pinia",
                "1 taza (165 g)",
                "sdfasd",
                "Piña.png",
                82,
                0.9,
                22.0
        ));

        platosEcuatorianos.add(new Dish(
                "Papaya",
                "1 taza (145 g)",
                "sdfasd",
                "Papaya.png",
                59,
                0.9,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Mango",
                "1 unidad mediana (200 g)",
                "sdfasd",
                "Mango.png",
                135,
                1.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Hamburguesa",
                "1 unidad (250 g)",
                "sdfasd",
                "Hamburguesa.png",
                550,
                25.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pizza",
                "1 porción (180 g)",
                "sdfasd",
                "PizzaQueso.png",
                400,
                15.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Alitas",
                "5 unidades (150 g)",
                "sdfasd",
                "AlitasAsadas.png",
                430,
                28.0,
                4.0
        ));

        platosEcuatorianos.add(new Dish(
                "Lasania",
                "1 porción (300 g)",
                "sdfasd",
                "Lasagna.png",
                480,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tacos",
                "2 unidades (180 g)",
                "sdfasd",
                "TacoCarne.png",
                350,
                18.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Shawarma",
                "1 unidad (250 g)",
                "sdfasd",
                "ShawarmaPollo.png",
                480,
                25.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Yogurt",
                "1 vaso (200 ml)",
                "sdfasd",
                "YogurtFresa.png",
                151,
                6.0,
                20.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tripa Mishki",
                "1 porción (180 g)",
                "sdfasd",
                "TripaMishki.png",
                350,
                28.0,
                3.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con leche",
                "1 porción (150 g)",
                "sdfasd",
                "ArrozConLeche.png",
                210,
                4.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Salchipapa",
                "1 porción (300 g)",
                "sdfasd",
                "Salchipapa.png",
                500,
                14.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Papipollo",
                "1 porción (350 g)",
                "sdfasd",
                "Papipollo.png",
                620,
                25.0,
                50.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chuzos",
                "2 palitos (200 g)",
                "sdfasd",
                "ChuzosCarne.png",
                400,
                30.0,
                8.0
        ));

        platosEcuatorianos.add(new Dish(
                "Naranja",
                "1 unidad (130 g)",
                "sdfasd",
                "Naranja.png",
                62,
                1.2,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Mandarina",
                "1 unidad (120 g)",
                "sdfasd",
                "Mandarina.png",
                53,
                0.8,
                13.0
        ));

        platosEcuatorianos.add(new Dish(
                "Guayaba",
                "1 unidad (100 g)",
                "sdfasd",
                "Guayaba.png",
                68,
                2.6,
                14.0
        ));

        platosEcuatorianos.add(new Dish(
                "Guanabana",
                "1 taza (225 g)",
                "sdfasd",
                "Guanabana.png",
                135,
                2.5,
                34.0
        ));

        platosEcuatorianos.add(new Dish(
                "Maduro",
                "1 unidad (150 g)",
                "sdfasd",
                "Banana.png",
                160,
                1.3,
                37.0
        ));

        platosEcuatorianos.add(new Dish(
                "Kiwi",
                "1 unidad (75 g)",
                "sdfasd",
                "Kiwi.png",
                42,
                0.8,
                10.0
        ));

        platosEcuatorianos.add(new Dish(
                "Zapote",
                "1 unidad (250 g)",
                "sdfasd",
                "Zapote.png",
                110,
                2.0,
                28.0
        ));

        platosEcuatorianos.add(new Dish(
                "Durazno",
                "1 unidad (150 g)",
                "sdfasd",
                "Durazno.png",
                59,
                1.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sandia",
                "1 taza (150 g)",
                "sdfasd",
                "Sandia.png",
                46,
                0.9,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Melon",
                "1 taza (160 g)",
                "sdfasd",
                "Melon.png",
                60,
                1.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tamales",
                "1 unidad (200 g)",
                "sdfasd",
                "TamalPollo.png",
                250,
                8.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Humitas",
                "1 unidad (180 g)",
                "sdfasd",
                "Humita.png",
                230,
                7.0,
                33.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tigrillo",
                "1 porción (250 g)",
                "sdfasd",
                "Tigrillo.png",
                400,
                12.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Quimbolitos",
                "1 unidad (150 g)",
                "sdfasd",
                "Quimbolito.png",
                200,
                4.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Mote sucio",
                "1 porción (200 g)",
                "sdfasd",
                "MoteSucio.png",
                280,
                10.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Bolon",
                "1 unidad (250 g)",
                "sdfasd",
                "Bolon.png",
                420,
                10.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Empanada de verde",
                "1 unidad (150 g)",
                "sdfasd",
                "EmpanadaVerde.png",
                290,
                6.0,
                28.0
        ));

        platosEcuatorianos.add(new Dish(
                "Empanada de viento",
                "1 unidad (140 g)",
                "sdfasd",
                "EmpanadaViento.png",
                320,
                5.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Empanada de yuca",
                "1 unidad (130 g)",
                "sdfasd",
                "EmpanadaYuca.png",
                280,
                5.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Llapingachos",
                "2 unidades (200 g)",
                "sdfasd",
                "Llapingachos.png",
                360,
                8.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Bollo de pescado",
                "1 unidad (300 g)",
                "sdfasd",
                "BolloPescado.png",
                480,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tostadas",
                "2 unidades (160 g)",
                "sdfasd",
                "Tostada.png",
                300,
                8.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Mote con chicharron",
                "1 porción (250 g)",
                "sdfasd",
                "MoteChicharron.png",
                500,
                15.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pan de yuca",
                "3 unidades (90 g)",
                "sdfasd",
                "PanYuca.png",
                220,
                5.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Batidos",
                "1 vaso (300 ml)",
                "sdfasd",
                "Batido.png",
                180,
                4.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cafe con pan",
                "1 taza + 1 pan (180 g)",
                "sdfasd",
                "CafePan.png",
                220,
                4.0,
                28.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche de camaron",
                "1 porción (456 g)",
                "sdfasd",
                "CevicheCamaron.png",
                208,
                34.0,
                19.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cevichocho",
                "1 porción (350 g)",
                "sdfasd",
                "Cevichocho.png",
                280,
                12.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche de pescado",
                "1 porción (400 g)",
                "sdfasd",
                "CevichePescado.png",
                220,
                30.0,
                18.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con menestra y carne",
                "1 porción (400 g)",
                "sdfasd",
                "ArrozMenestraCarne.png",
                700,
                35.0,
                60.0
        ));

        platosEcuatorianos.add(new Dish(
                "Seco de pollo",
                "1 porción (350 g)",
                "sdfasd",
                "SecoPollo.png",
                620,
                32.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de pollo",
                "1 plato (350 g)",
                "sdfasd",
                "CaldoPollo.png",
                300,
                25.0,
                10.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de bolas",
                "1 porción (400 g)",
                "sdfasd",
                "CaldoBola.png",
                450,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de carne",
                "1 plato (350 g)",
                "sdfasd",
                "CaldoCarne.png",
                360,
                30.0,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de fideos",
                "1 plato (300 g)",
                "sdfasd",
                "SopaFideo.png",
                220,
                6.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Aguado de gallina",
                "1 porción (400 g)",
                "sdfasd",
                "AguadoGallina.png",
                310,
                20.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de bagre",
                "1 plato (350 g)",
                "sdfasd",
                "CaldoBagre.png",
                340,
                28.0,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de mani",
                "1 plato (300 g)",
                "sdfasd",
                "SopaMani.png",
                400,
                10.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Guatita",
                "1 porción (350 g)",
                "sdfasd",
                "Guatita.png",
                500,
                22.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz marinero",
                "1 porción (400 g)",
                "sdfasd",
                "ArrozMarinero.png",
                580,
                35.0,
                50.0
        ));

        platosEcuatorianos.add(new Dish(
                "Estofado de carne",
                "1 porción (350 g)",
                "sdfasd",
                "EstofadoCarne.png",
                520,
                30.0,
                28.0
        ));

        platosEcuatorianos.add(new Dish(
                "Hornado",
                "1 porción (400 g)",
                "sdfasd",
                "Hornado.png",
                650,
                32.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cuy asado",
                "1 porción (350 g)",
                "sdfasd",
                "CuyAsado.png",
                480,
                35.0,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de pata",
                "1 plato (350 g)",
                "sdfasd",
                "CaldoPata.png",
                430,
                22.0,
                20.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con pescado frito",
                "1 porción (400 g)",
                "sdfasd",
                "ArrozPescadoFrito.png",
                580,
                30.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con Pollo Frito",
                "1 porción (400 g)",
                "sdfasd",
                "ArrozPolloFrito.png",
                650,
                32.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con Carne Frita",
                "1 porción (400 g)",
                "sdfasd",
                "ArrozCarneFrita.png",
                700,
                35.0,
                42.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche de concha",
                "1 porción (400 g)",
                "sdfasd",
                "CevicheConcha.png",
                210,
                28.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ensalada de frutas",
                "1 vaso (300 g)",
                "sdfasd",
                "EnsaladaFrutas.png",
                180,
                3.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con longaniza",
                "1 porción (400 g)",
                "sdfasd",
                "ArrozLonganiza.png",
                680,
                28.0,
                50.0
        ));

        platosEcuatorianos.add(new Dish(
                "Fritada",
                "1 porción (450 g)",
                "sdfasd",
                "Fritada.png",
                720,
                35.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Parrillada",
                "1 porción (500 g)",
                "sdfasd",
                "Parrillada.png",
                900,
                50.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Corviche",
                "1 unidad (200 g)",
                "sdfasd",
                "Corviche.png",
                340,
                10.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con pollo frito",
                "1 porción (400 g)",
                "sdfasd",
                "ArrozPolloFrito.png",
                600,
                28.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chaulafan",
                "1 porción (400 g)",
                "sdfasd",
                "Chaulafan.png",
                650,
                30.0,
                55.0
        ));

        platosEcuatorianos.add(new Dish(
                "Menestron",
                "1 plato (350 g)",
                "sdfasd",
                "Menestron.png",
                400,
                12.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Seco de chivo",
                "1 porción (400 g)",
                "sdfasd",
                "SecoChivo.png",
                680,
                32.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche mixto",
                "1 porción (400 g)",
                "sdfasd",
                "CevicheMixto.png",
                230,
                30.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cangrejada",
                "1 porción (500 g)",
                "sdfasd",
                "Cangrejada.png",
                500,
                35.0,
                20.0
        ));

        platosEcuatorianos.add(new Dish(
                "Repe",
                "1 taza (300 g)",
                "sdfasd",
                "Repe.png",
                240,
                6.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Alverjas con cuero",
                "1 porción (350 g)",
                "sdfasd",
                "AlverjasCuero.png",
                480,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Locro de papa",
                "1 taza (300 g)",
                "sdfasd",
                "LocroPapa.png",
                350,
                8.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chivo al hueco",
                "1 porción (400 g)",
                "sdfasd",
                "ChivoHueco.png",
                720,
                35.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de habas",
                "1 taza (300 g)",
                "sdfasd",
                "SopaHaba.png",
                320,
                10.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Yahuarlocro",
                "1 plato (350 g)",
                "sdfasd",
                "Yahuarlocro.png",
                500,
                20.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Encocado de pescado",
                "1 porción (400 g)",
                "sdfasd",
                "EncocadoPescado.png",
                550,
                30.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chanfaina",
                "1 porción (350 g)",
                "sdfasd",
                "Chanfaina.png",
                480,
                25.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de porotos",
                "1 taza (300 g)",
                "sdfasd",
                "SopaPoroto.png",
                330,
                10.0,
                35.0
        ));

    }

    public Dish findById(Long id) {
        return platosEcuatorianos.stream()
                .filter(d -> id.equals(d.getId()))
                .findFirst()
                .orElse(null);
    }

    public Dish findByName(String name) {
        return platosEcuatorianos.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name.trim()))
                .findFirst()
                .orElse(null);
    }

    public List<String> getAllDishNames() {
        return platosEcuatorianos.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}