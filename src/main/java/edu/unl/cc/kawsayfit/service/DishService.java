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
                "200g de atún o albacora cocida, 100g de yuca cocida, 50g de cebolla colorada encurtida, 10g de cilantro fresco, 5g de ají, 10g de tomate, 5g de comino, 5g de sal, 5g de aceite, 100ml de agua o caldo de pescado",
                "Encebollado.png",
                300,
                20.0,
                25.0
        ));


        platosEcuatorianos.add(new Dish(
                "Manzana",
                "1 unidad mediana (182 g)",
                "182g de manzana roja",
                "ManzanaRoja.png",
                95,
                0.5,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pera",
                "1 unidad mediana (178 g)",
                "178g de pera",
                "Pera.png",
                101,
                0.6,
                27.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pinia",
                "1 taza (165 g)",
                "165g de piña fresca",
                "Piña.png",
                82,
                0.9,
                22.0
        ));

        platosEcuatorianos.add(new Dish(
                "Papaya",
                "1 taza (145 g)",
                "145g de papaya",
                "Papaya.png",
                59,
                0.9,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Mango",
                "1 unidad mediana (200 g)",
                "200g de mango maduro",
                "Mango.png",
                135,
                1.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Hamburguesa",
                "1 unidad (250 g)",
                "150g carne molida de res, 50g pan de hamburguesa, 20g queso cheddar, 10g lechuga, 10g tomate, 10g cebolla",
                "Hamburguesa.png",
                550,
                25.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pizza",
                "1 porción (180 g)",
                "100g masa de pizza, 50g queso mozzarella, 20g salsa de tomate, 10g aceite de oliva",
                "PizzaQueso.png",
                400,
                15.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Alitas",
                "5 unidades (150 g)",
                "150g alitas de pollo adobadas con 5g sal, 5g pimienta, 10g salsa BBQ",
                "AlitasAsadas.png",
                430,
                28.0,
                4.0
        ));

        platosEcuatorianos.add(new Dish(
                "Lasania",
                "1 porción (300 g)",
                "100g pasta de lasaña, 100g carne molida, 50g queso mozzarella, 30g salsa de tomate, 20g bechamel",
                "Lasagna.png",
                480,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tacos",
                "2 unidades (180 g)",
                "100g carne de res, 2 tortillas de maíz (60g), 10g cebolla, 10g salsa, 5g cilantro, 5g limón",
                "TacoCarne.png",
                350,
                18.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Shawarma",
                "1 unidad (250 g)",
                "150g pollo asado, 60g pan pita, 20g vegetales mixtos, 20g salsa de ajo",
                "ShawarmaPollo.png",
                480,
                25.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Yogurt",
                "1 vaso (200 ml)",
                "200ml yogurt de fresa natural",
                "YogurtFresa.png",
                151,
                6.0,
                20.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tripa Mishki",
                "1 porción (180 g)",
                "150g tripa de res, 20g cebolla, 5g achiote, 5g cilantro",
                "TripaMishki.png",
                350,
                28.0,
                3.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con leche",
                "1 porción (150 g)",
                "80g arroz, 50ml leche, 10g azúcar, 5g canela, 5g pasas",
                "ArrozConLeche.png",
                210,
                4.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Salchipapa",
                "1 porción (300 g)",
                "150g papas fritas, 100g salchicha, 30g mayonesa, 20g ketchup",
                "Salchipapa.png",
                500,
                14.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Papipollo",
                "1 porción (350 g)",
                "200g papas fritas, 120g pollo frito, 30g salsa",
                "Papipollo.png",
                620,
                25.0,
                50.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chuzos",
                "2 palitos (200 g)",
                "150g carne de res, 30g pimiento, 20g cebolla",
                "ChuzosCarne.png",
                400,
                30.0,
                8.0
        ));

        platosEcuatorianos.add(new Dish(
                "Naranja",
                "1 unidad (130 g)",
                "130g naranja",
                "Naranja.png",
                62,
                1.2,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Mandarina",
                "1 unidad (120 g)",
                "120g mandarina",
                "Mandarina.png",
                53,
                0.8,
                13.0
        ));

        platosEcuatorianos.add(new Dish(
                "Guayaba",
                "1 unidad (100 g)",
                "100g guayaba",
                "Guayaba.png",
                68,
                2.6,
                14.0
        ));

        platosEcuatorianos.add(new Dish(
                "Guanabana",
                "1 taza (225 g)",
                "225g guanábana",
                "Guanabana.png",
                135,
                2.5,
                34.0
        ));

        platosEcuatorianos.add(new Dish(
                "Maduro",
                "1 unidad (150 g)",
                "150g plátano maduro",
                "Banana.png",
                160,
                1.3,
                37.0
        ));

        platosEcuatorianos.add(new Dish(
                "Kiwi",
                "1 unidad (75 g)",
                "75g kiwi",
                "Kiwi.png",
                42,
                0.8,
                10.0
        ));

        platosEcuatorianos.add(new Dish(
                "Zapote",
                "1 unidad (250 g)",
                "250g zapote",
                "Zapote.png",
                110,
                2.0,
                28.0
        ));

        platosEcuatorianos.add(new Dish(
                "Durazno",
                "1 unidad (150 g)",
                "150g durazno",
                "Durazno.png",
                59,
                1.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sandia",
                "1 taza (150 g)",
                "150g sandía",
                "Sandia.png",
                46,
                0.9,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Melon",
                "1 taza (160 g)",
                "160g melón",
                "Melon.png",
                60,
                1.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tamales",
                "1 unidad (200 g)",
                "150g de masa de maíz, 50g de pollo, 10g de achiote, 5g de cebolla, 5g de ajo, 5g de cilantro, 10g de aceituna, 5g de sal",
                "TamalPollo.png",
                250,
                8.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Humitas",
                "1 unidad (180 g)",
                "150g de maíz tierno molido, 20g de queso fresco, 5g de mantequilla, 5g de azúcar, 5g de sal, hojas de maíz para envolver",
                "Humita.png",
                230,
                7.0,
                33.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tigrillo",
                "1 porción (250 g)",
                "150g de plátano maduro, 50g de queso fresco, 30g de huevo, 10g de cebolla, 10g de mantequilla, 5g de sal",
                "Tigrillo.png",
                400,
                12.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Quimbolitos",
                "1 unidad (150 g)",
                "120g de harina de maíz, 20g de azúcar, 10g de mantequilla, 10g de queso, 5g de levadura, hojas de achira para envolver",
                "Quimbolito.png",
                200,
                4.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Mote sucio",
                "1 porción (200 g)",
                "150g de mote cocido, 30g de chicharrón, 10g de cebolla, 5g de ajo, 5g de achiote, 5g de sal",
                "MoteSucio.png",
                280,
                10.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Bolon",
                "1 unidad (250 g)",
                "200g de plátano verde, 30g de queso fresco, 20g de chicharrón, 5g de mantequilla, 5g de sal",
                "Bolon.png",
                420,
                10.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Empanada de verde",
                "1 unidad (150 g)",
                "120g de plátano verde molido, 30g de queso fresco, 5g de sal, 10g de aceite para freír",
                "EmpanadaVerde.png",
                290,
                6.0,
                28.0
        ));

        platosEcuatorianos.add(new Dish(
                "Empanada de viento",
                "1 unidad (140 g)",
                "130g de masa de harina de trigo, 30g de queso fresco, 5g de sal, 10g de aceite para freír",
                "EmpanadaViento.png",
                320,
                5.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Empanada de yuca",
                "1 unidad (130 g)",
                "120g de masa de yuca, 30g de queso fresco, 5g de sal, 10g de aceite para freír",
                "EmpanadaYuca.png",
                280,
                5.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Llapingachos",
                "2 unidades (200 g)",
                "200g de papa, 50g de queso fresco, 20g de cebolla, 10g de achiote, 10g de mantequilla, 5g de sal",
                "Llapingachos.png",
                360,
                8.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Bollo de pescado",
                "1 unidad (300 g)",
                "200g de pescado, 100g de masa de maíz, 10g de cebolla, 10g de ajo, 5g de achiote, 5g de sal",
                "BolloPescado.png",
                480,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Tostadas",
                "2 unidades (160 g)",
                "160g de tostadas de maíz, 30g de aguacate, 10g de cebolla, 5g de limón, 5g de sal",
                "Tostada.png",
                300,
                8.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Mote con chicharron",
                "1 porción (250 g)",
                "150g de mote cocido, 80g de chicharrón, 10g de cebolla, 5g de achiote, 5g de sal",
                "MoteChicharron.png",
                500,
                15.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pan de yuca",
                "3 unidades (90 g)",
                "90g de masa de yuca, 30g de queso fresco, 5g de mantequilla, 5g de sal",
                "PanYuca.png",
                220,
                5.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Batidos",
                "1 vaso (300 ml)",
                "300ml de fruta (banana, papaya), 150ml de leche, 20g de azúcar",
                "Batido.png",
                180,
                4.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cafe con pan",
                "1 taza + 1 pan (180 g)",
                "1 taza de café negro, 100g de pan dulce, 10g de mantequilla",
                "CafePan.png",
                220,
                4.0,
                28.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche de camaron",
                "1 porción (456 g)",
                "300g de camarón, 50g de cebolla, 30g de tomate, 30g de limón, 10g de cilantro, 10g de sal",
                "CevicheCamaron.png",
                208,
                34.0,
                19.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cevichocho",
                "1 porción (350 g)",
                "200g de chochos, 50g de cebolla, 30g de tomate, 30g de limón, 10g de cilantro, 10g de sal",
                "Cevichocho.png",
                280,
                12.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche de pescado",
                "1 porción (400 g)",
                "250g de pescado, 50g de cebolla, 40g de tomate, 30g de limón, 20g de cilantro, 10g de sal",
                "CevichePescado.png",
                220,
                30.0,
                18.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con menestra y carne",
                "1 porción (400 g)",
                "150g de arroz, 150g de menestra, 100g de carne, 10g de aceite, 5g de sal",
                "ArrozMenestraCarne.png",
                700,
                35.0,
                60.0
        ));

        platosEcuatorianos.add(new Dish(
                "Seco de pollo",
                "1 porción (350 g)",
                "200g de pollo, 100g de arroz, 30g de salsa de tomate, 20g de cebolla, 10g de especias",
                "SecoPollo.png",
                620,
                32.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de pollo",
                "1 plato (350 g)",
                "250g de pollo, 50g de yuca, 20g de cebolla, 10g de cilantro, 10g de ajo, 5g de sal",
                "CaldoPollo.png",
                300,
                25.0,
                10.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de bolas",
                "1 porción (400 g)",
                "200g de bolas de verde, 150g de carne de cerdo, 30g de yuca, 10g de cebolla, 10g de especias",
                "CaldoBola.png",
                450,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de carne",
                "1 plato (350 g)",
                "250g de carne, 50g de yuca, 20g de cebolla, 10g de cilantro, 10g de ajo, 5g de sal",
                "CaldoCarne.png",
                360,
                30.0,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de fideos",
                "1 plato (300 g)",
                "150g de fideos, 100g de caldo de pollo, 20g de zanahoria, 20g de cebolla, 10g de apio",
                "SopaFideo.png",
                220,
                6.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Aguado de gallina",
                "1 porción (400 g)",
                "250g de gallina, 50g de arroz, 30g de cebolla, 20g de tomate, 10g de especias",
                "AguadoGallina.png",
                310,
                20.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de bagre",
                "1 plato (350 g)",
                "250g de bagre, 50g de yuca, 20g de cebolla, 10g de tomate, 10g de especias",
                "CaldoBagre.png",
                340,
                28.0,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de mani",
                "1 plato (300 g)",
                "200g de maní molido, 50g de papa, 30g de carne, 10g de cebolla, 10g de especias",
                "SopaMani.png",
                400,
                10.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Guatita",
                "1 porción (350 g)",
                "200g de mondongo, 100g de papa, 30g de maní, 20g de cebolla, 10g de especias",
                "Guatita.png",
                500,
                22.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz marinero",
                "1 porción (400 g)",
                "200g de arroz, 150g de mariscos mixtos, 30g de cebolla, 20g de tomate, 20g de especias",
                "ArrozMarinero.png",
                580,
                35.0,
                50.0
        ));

        platosEcuatorianos.add(new Dish(
                "Estofado de carne",
                "1 porción (350 g)",
                "250g de carne de res, 50g de papa, 30g de tomate, 20g de cebolla, 10g de especias",
                "EstofadoCarne.png",
                520,
                30.0,
                28.0
        ));

        platosEcuatorianos.add(new Dish(
                "Hornado",
                "1 porción (400 g)",
                "300g de cerdo asado, 50g de mote, 30g de cebolla, 20g de especias",
                "Hornado.png",
                650,
                32.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cuy asado",
                "1 porción (350 g)",
                "300g de cuy, 30g de especias, 20g de aceite, 10g de sal",
                "CuyAsado.png",
                480,
                35.0,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Caldo de pata",
                "1 plato (350 g)",
                "250g de pata de res, 50g de yuca, 30g de cebolla, 10g de especias",
                "CaldoPata.png",
                430,
                22.0,
                20.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con pescado frito",
                "1 porción (400 g)",
                "200g de arroz, 150g de pescado frito, 30g de cebolla, 20g de tomate",
                "ArrozPescadoFrito.png",
                580,
                30.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con Pollo Frito",
                "1 porción (400 g)",
                "200g de arroz, 150g de pollo frito, 30g de cebolla, 20g de especias",
                "ArrozPolloFrito.png",
                650,
                32.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con Carne Frita",
                "1 porción (400 g)",
                "200g de arroz, 150g de carne frita, 30g de cebolla, 25g de especias",
                "ArrozCarneFrita.png",
                700,
                35.0,
                42.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche de concha",
                "1 porción (400 g)",
                "300g de concha, 50g de cebolla, 30g de limón, 20g de tomate, 10g de cilantro",
                "CevicheConcha.png",
                210,
                28.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ensalada de frutas",
                "1 vaso (300 g)",
                "150g de frutas mixtas (banana, mango, papaya), 100ml de jugo natural",
                "EnsaladaFrutas.png",
                180,
                3.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con longaniza",
                "1 porción (400 g)",
                "200g de arroz, 150g de longaniza, 30g de cebolla, 20g de especias",
                "ArrozLonganiza.png",
                680,
                28.0,
                50.0
        ));

        platosEcuatorianos.add(new Dish(
                "Fritada",
                "1 porción (450 g)",
                "300g de cerdo frito, 100g de mote, 30g de cebolla, 20g de especias",
                "Fritada.png",
                720,
                35.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Parrillada",
                "1 porción (500 g)",
                "150g de carne, 150g de pollo, 100g de chorizo, 100g de mote, especias al gusto",
                "Parrillada.png",
                900,
                50.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Corviche",
                "1 unidad (200 g)",
                "150g de pescado, 30g de yuca, 10g de cebolla, 10g de especias",
                "Corviche.png",
                340,
                10.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con pollo",
                "1 porción (400 g)",
                "200g de arroz, 150g de pollo, 30g de cebolla, 20g de tomate, 10g de especias",
                "ArrozConPollo.png",
                600,
                28.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chaulafan",
                "1 porción (400 g)",
                "200g de arroz, 100g de carne o pollo, 50g de verduras, 30g de salsa de soja",
                "Chaulafan.png",
                650,
                30.0,
                55.0
        ));

        platosEcuatorianos.add(new Dish(
                "Menestron",
                "1 plato (350 g)",
                "150g de menestra, 100g de carne, 50g de verduras, 50g de arroz",
                "Menestron.png",
                400,
                12.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Seco de chivo",
                "1 porción (400 g)",
                "200g de carne de chivo, 100g de arroz, 30g de salsa, 20g de especias",
                "SecoChivo.png",
                680,
                32.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche mixto",
                "1 porción (400 g)",
                "150g de pescado, 100g de camarón, 50g de concha, 50g de cebolla, 30g de limón",
                "CevicheMixto.png",
                230,
                30.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cangrejada",
                "1 porción (500 g)",
                "300g de cangrejo, 100g de mote, 50g de ensalada, especias al gusto",
                "Cangrejada.png",
                500,
                35.0,
                20.0
        ));

        platosEcuatorianos.add(new Dish(
                "Repe",
                "1 taza (300 g)",
                "150g de plátano verde, 50g de maní, 50g de cebolla, especias al gusto",
                "Repe.png",
                240,
                6.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Alverjas con cuero",
                "1 porción (350 g)",
                "200g de alverjas, 100g de cuero de cerdo, 30g de cebolla, especias al gusto",
                "AlverjasCuero.png",
                480,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Locro de papa",
                "1 taza (300 g)",
                "200g de papa, 50g de queso, 30g de leche, 20g de cebolla",
                "LocroPapa.png",
                350,
                8.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chivo al hueco",
                "1 porción (400 g)",
                "200g de carne de chivo, 100g de arroz, 30g de salsa, especias al gusto",
                "ChivoHueco.png",
                720,
                35.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de habas",
                "1 taza (300 g)",
                "200g de habas, 50g de carne, 30g de cebolla, 20g de especias",
                "SopaHaba.png",
                320,
                10.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Yahuarlocro",
                "1 plato (350 g)",
                "200g de papa, 100g de sangre de res, 30g de cebolla, especias al gusto",
                "Yahuarlocro.png",
                500,
                20.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Encocado de pescado",
                "1 porción (400 g)",
                "200g de pescado, 100g de coco, 50g de cebolla, 50g de tomate, especias al gusto",
                "EncocadoPescado.png",
                550,
                30.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chanfaina",
                "1 porción (350 g)",
                "200g de carne, 100g de arroz, 30g de cebolla, especias al gusto",
                "Chanfaina.png",
                480,
                25.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de porotos",
                "1 taza (300 g)",
                "200g de porotos, 50g de carne, 30g de cebolla, 20g de especias",
                "SopaPoroto.png",
                330,
                10.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz relleno",
                "1 porción (350 g)",
                "200g de arroz, 100g de carne molida, 50g de pimiento, 30g de cebolla, 20g de zanahoria, 10g de aceitunas, especias al gusto",
                "ArrozRelleno.png",
                550,
                30.0,
                60.0
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