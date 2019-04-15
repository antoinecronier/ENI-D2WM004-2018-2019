package fr.acos.androkado.database.contracts;

public class UtilisateurContract {

    public static final String TABLE_NAME = "utilisateur";

    public static final String COL_ID = "id";
    public static final String COL_NOM = "nom";
    public static final String COL_PRENOM = "prenom";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_NOM,
            COL_PRENOM
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_NOM + " TEXT," +
                    COL_PRENOM + " TEXT" +
            ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

}
