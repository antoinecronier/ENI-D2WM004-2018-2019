package fr.acos.androkado.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import fr.acos.androkado.AndrokadoApplication;
import fr.acos.androkado.database.contracts.UtilisateurContract;
import fr.acos.androkado.entities.Utilisateur;

public class DbOpenHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "androkado.db";

    /** Instance unique non préinitialisée */
    private static DbOpenHelper INSTANCE = null;

    /** Point d'accès pour l'instance unique du singleton */
    public static synchronized DbOpenHelper getInstance()
    {
        if (INSTANCE == null)
        {   INSTANCE = new DbOpenHelper(AndrokadoApplication.getAppContext());
        }
        return INSTANCE;
    }

    private SQLiteDatabase db;

    private DbOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilisateurContract.CREATE_TABLE);
        this.db = db;
        DbManager manager = new DbManager();

        for (int i = 0; i < 10; i++) {
            manager.getUserDAO().insert(new Utilisateur("nom"+i,"prenom"+i));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UtilisateurContract.DROP_TABLE);
        onCreate(db);
    }

    public SQLiteDatabase getDb() {
        if (db == null){
            db = this.getWritableDatabase();
        }
        return db;
    }
}
