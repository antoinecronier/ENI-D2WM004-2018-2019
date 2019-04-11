package fr.acos.androkado.utils;

import java.util.ArrayList;
import java.util.List;

import fr.acos.androkado.entities.Utilisateur;

public class UtilisateurStaticDatas {

    public static List<Utilisateur> ITEMS = new ArrayList<Utilisateur>() {
        {
            add(new Utilisateur("Nom1", "Prenom 1"));
            add(new Utilisateur("El", "Roger"));
            add(new Utilisateur("Cronier", "Antoine"));
            add(new Utilisateur("Michel", "Jean"));
            add(new Utilisateur("Kiloutou", "Ivan"));
        }
    };
}
