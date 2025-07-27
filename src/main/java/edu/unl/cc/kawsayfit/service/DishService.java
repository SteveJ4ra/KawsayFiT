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
                "Piña",
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
                "Guanábana",
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
                "Sandía",
                "1 taza (150 g)",
                "150g sandía",
                "Sandia.png",
                46,
                0.9,
                12.0
        ));

        platosEcuatorianos.add(new Dish(
                "Melón",
                "1 taza (160 g)",
                "160g melón",
                "Melon.png",
                60,
                1.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche de concha",
                "1 porción (400 g)",
                "200g concha negra, 100g cebolla morada, 50g tomate, 20g cilantro, 10g limón, 20g ají",
                "CevicheConcha.png",
                210,
                28.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ensalada de frutas",
                "1 vaso (300 g)",
                "80g piña, 70g papaya, 60g manzana, 40g sandía, 30g uvas, 20g jugo de naranja",
                "EnsaladaFrutas.png",
                180,
                3.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con longaniza",
                "1 porción (400 g)",
                "200g arroz cocido, 120g longaniza frita, 50g cebolla, 30g pimiento",
                "ArrozLonganiza.png",
                680,
                28.0,
                50.0
        ));

        platosEcuatorianos.add(new Dish(
                "Fritada",
                "1 porción (450 g)",
                "200g carne de cerdo, 100g mote, 80g maduro frito, 50g curtido de cebolla, 20g ají",
                "Fritada.png",
                720,
                35.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Parrillada",
                "1 porción (500 g)",
                "150g carne de res, 100g chorizo, 80g pollo, 50g riñón, 70g papa, 50g ensalada",
                "Parrillada.png",
                900,
                50.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Corviche",
                "1 unidad (200 g)",
                "120g plátano verde, 60g pescado, 10g maní, 10g cebolla",
                "Corviche.png",
                340,
                10.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz con pollo frito",
                "1 porción (400 g)",
                "200g arroz, 150g pollo frito, 30g ensalada, 20g cebolla",
                "ArrozPolloFrito.png",
                600,
                28.0,
                45.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chaulafán",
                "1 porción (400 g)",
                "200g arroz frito, 80g pollo, 50g jamón, 30g camarones, 20g cebolla, 20g huevo",
                "Chaulafan.png",
                650,
                30.0,
                55.0
        ));

        platosEcuatorianos.add(new Dish(
                "Menestrón",
                "1 plato (350 g)",
                "100g fréjol, 100g papa, 50g zanahoria, 50g fideos, 30g repollo, 20g cebolla",
                "Menestron.png",
                400,
                12.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Seco de chivo",
                "1 porción (400 g)",
                "200g carne de chivo, 100g arroz, 60g menestra, 40g plátano maduro",
                "SecoChivo.png",
                680,
                32.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Ceviche mixto",
                "1 porción (400 g)",
                "100g camarón, 100g pescado, 80g calamar, 80g cebolla, 20g cilantro, 20g limón",
                "CevicheMixto.png",
                230,
                30.0,
                15.0
        ));

        platosEcuatorianos.add(new Dish(
                "Cangrejada",
                "1 porción (500 g)",
                "300g cangrejo cocido, 100g yuca, 50g cebolla, 30g limón, 20g ají",
                "Cangrejada.png",
                500,
                35.0,
                20.0
        ));

        platosEcuatorianos.add(new Dish(
                "Repe",
                "1 taza (300 g)",
                "150g guineo verde, 80g leche, 40g queso, 20g cebolla, 10g cilantro",
                "Repe.png",
                240,
                6.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Alverjas con cuero",
                "1 porción (350 g)",
                "150g alverjas, 100g cuero de cerdo, 50g papa, 30g arroz, 20g cebolla",
                "AlverjasCuero.png",
                480,
                20.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Locro de papa",
                "1 taza (300 g)",
                "150g papa, 50g leche, 30g queso, 20g cebolla, 20g aguacate, 10g cilantro",
                "LocroPapa.png",
                350,
                8.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chivo al hueco",
                "1 porción (400 g)",
                "250g carne de chivo, 100g yuca, 50g ensalada de cebolla y tomate",
                "ChivoHueco.png",
                720,
                35.0,
                40.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de habas",
                "1 taza (300 g)",
                "100g habas, 80g papa, 50g leche, 30g queso, 20g cebolla, 20g cilantro",
                "SopaHaba.png",
                320,
                10.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Yahuarlocro",
                "1 plato (350 g)",
                "150g papa, 100g mondongo, 50g sangre frita, 30g cebolla, 20g aguacate",
                "Yahuarlocro.png",
                500,
                20.0,
                30.0
        ));

        platosEcuatorianos.add(new Dish(
                "Encocado de pescado",
                "1 porción (400 g)",
                "200g pescado, 100g leche de coco, 50g pimiento, 30g cebolla, 20g arroz",
                "EncocadoPescado.png",
                550,
                30.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Chanfaina",
                "1 porción (350 g)",
                "200g vísceras de res, 80g arroz, 40g cebolla, 20g pimiento, 10g achiote",
                "Chanfaina.png",
                480,
                25.0,
                25.0
        ));

        platosEcuatorianos.add(new Dish(
                "Sopa de porotos",
                "1 taza (300 g)",
                "150g porotos, 80g papa, 30g zanahoria, 20g cebolla, 20g cilantro",
                "SopaPoroto.png",
                330,
                10.0,
                35.0
        ));

        platosEcuatorianos.add(new Dish(
                "Arroz relleno",
                "1 porción (400 g)",
                "200g de arroz cocido, 80g de pechuga de pollo desmenuzada, 30g de pimiento, 30g de cebolla perla, 20g de zanahoria, 10g de arvejas, 10g de pasas, 10g de aceitunas, 5g de ajo, 5g de sal, 5g de aceite, 5g de condimentos (comino, pimienta)",
                "ArrozRelleno.png",
                620,
                25.0,
                55.0
        ));

        platosEcuatorianos.add(new Dish(
                "Pan",
                "1 unidad (50 g)",
                "50g de harina de trigo, 2g de levadura, 1g de sal, 5g de azúcar, 5g de manteca o aceite, 30ml de agua",
                "Pan.png",
                135,
                4.0,
                25.0
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