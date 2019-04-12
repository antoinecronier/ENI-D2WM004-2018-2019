package fr.acos.androkado.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import fr.acos.androkado.database.contracts.UtilisateurContract;

public class DbOpenHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "androkado.db";

    public DbOpenHelper(@Nullable Context context) {
        super(context, this.DB_NAME, null, this.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilisateurContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UtilisateurContract.DROP_TABLE);
        onCreate(db);
    }
}
