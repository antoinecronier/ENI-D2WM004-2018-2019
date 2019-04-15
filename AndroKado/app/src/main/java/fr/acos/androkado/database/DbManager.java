package fr.acos.androkado.database;

import android.content.Context;

import fr.acos.androkado.database.daos.BaseDAO;
import fr.acos.androkado.database.daos.UtilisateurDAO;
import fr.acos.androkado.entities.Utilisateur;

public class DbManager {

    private BaseDAO<Utilisateur> userDAO;

    public BaseDAO<Utilisateur> getUserDAO() {
        if (userDAO == null){
            userDAO = new UtilisateurDAO();
        }
        return userDAO;
    }

    public DbManager(){
    }
}
