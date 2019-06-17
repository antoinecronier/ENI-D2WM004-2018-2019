package com.tactfactory.vroom.utils;

import com.tactfactory.vroom.entities.Voiture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VoitureUtils {

    public static List<Voiture> generateVoitures() {
        List<Voiture> result = new ArrayList<Voiture>();

        for (int i = 0; i < 10; i++){
            result.add(new Voiture(4,"testPlaque"+i,"couleur"+i,"marque"+i,LocalDate.now(),"nom"+i));
        }

        return result;
    }
}
