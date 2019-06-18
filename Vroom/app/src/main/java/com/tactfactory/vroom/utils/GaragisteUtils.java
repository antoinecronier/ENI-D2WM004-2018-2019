package com.tactfactory.vroom.utils;

import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GaragisteUtils {

    public static List<Garagiste> generateGaragiste() {
        List<Garagiste> result = new ArrayList<Garagiste>();

        for (int i = 0; i < 5; i++){
            result.add(new Garagiste("fn"+i,"ln"+i,"super address " + i, "garage" + i,"060606060" + i));
        }

        for (Garagiste garagiste: result) {
            garagiste.setVoitures(VoitureUtils.generateVoituresGaragiste(result.indexOf(garagiste),garagiste));
        }

        return result;
    }
}
