package com.tactfactory.vroom.utils;

import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VoitureUtils {

    public static List<Voiture> generateVoitures() {
        List<Voiture> result = new ArrayList<Voiture>();

        for (int i = 0; i < 25; i++){
            result.add(new Voiture(4,"testPlaque"+i,"couleur"+i,"marque"+i,LocalDate.now(),"nom"+i));
        }

        return result;
    }

    public static List<Voiture> generateVoituresWithGaragiste() {
        List<Voiture> result = new ArrayList<Voiture>();

        Garagiste garagiste1 = new Garagiste("jean","michel","la boisière", "interflora","0606060606");
        for (int i = 0; i < 5; i++){
            result.add(new Voiture(4,"testPlaque"+i,"couleur"+i,"marque"+i,LocalDate.now(),"nom"+i,garagiste1));
        }

        Garagiste garagiste2 = new Garagiste("hervé","duchesne","rennes", "vroom mobile","0607210606");
        for (int i = 5; i < 10; i++){
            result.add(new Voiture(4,"testPlaque"+i,"couleur"+i,"marque"+i,LocalDate.now(),"nom"+i,garagiste2));
        }

        Garagiste garagiste3 = new Garagiste("jean", "jean", "france", "Super car", "0202365982");
        for (int i = 10; i < 15; i++){
            result.add(new Voiture(4,"testPlaque"+i,"couleur"+i,"marque"+i,LocalDate.now(),"nom"+i,garagiste3));
        }

        return result;
    }

    public static List<Voiture> generateVoituresGaragiste(int i, Garagiste garagiste) {
        List<Voiture> result = new ArrayList<Voiture>();

        for (int j = 0; i < 10; i++){
            result.add(new Voiture(4,"testPlaque"+i+""+j,"couleur"+i+""+j,"marque"+i+""+j,LocalDate.now(),"nom"+i+""+j,garagiste));
        }

        return result;
    }

    public static List<Voiture> generateVoituresAndGaragisteFullMapped() {
        List<Voiture> result = new ArrayList<Voiture>();

        for (Garagiste garagiste: GaragisteUtils.generateGaragiste()) {
            result.addAll(garagiste.getVoitures());
        }

        return result;
    }
}
