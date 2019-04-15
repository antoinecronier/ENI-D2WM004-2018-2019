package fr.acos.androkado.database.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.acos.androkado.AndrokadoApplication;
import fr.acos.androkado.database.DbOpenHelper;
import fr.acos.androkado.database.contracts.UtilisateurContract;
import fr.acos.androkado.entities.Utilisateur;

public class UtilisateurDAO implements BaseDAO<Utilisateur> {

    private SQLiteDatabase db = null;

    public UtilisateurDAO(){
        db = DbOpenHelper.getInstance().getDb();
    }

    @Override
    public Utilisateur select(Long id) {
        Utilisateur result = null;

        Cursor cursor = db.query(
                UtilisateurContract.TABLE_NAME,
                UtilisateurContract.ALL_SELECT,
                UtilisateurContract.COL_ID + "=?",
                new String[]{id.toString()},
                null,
                null,
                null
                );
        if(cursor.moveToNext()){
            result = new Utilisateur();
            result.setId(id);
            result.setNom(cursor.getString(cursor.getColumnIndex(UtilisateurContract.COL_NOM)));
            result.setPrenom(cursor.getString(2));
        }
        return result;
    }

    @Override
    public List<Utilisateur> select() {
        List<Utilisateur> result = new ArrayList<Utilisateur>();

        final Cursor cursor = db.query(
                UtilisateurContract.TABLE_NAME,
                UtilisateurContract.ALL_SELECT,
                null,
                null,
                null,
                null,
                null
        );
        while(cursor.moveToNext()){
            result.add(new Utilisateur(){{
                setId(cursor.getLong(cursor.getColumnIndex(UtilisateurContract.COL_ID)));
                setNom(cursor.getString(cursor.getColumnIndex(UtilisateurContract.COL_NOM)));
                setPrenom(cursor.getString(cursor.getColumnIndex(UtilisateurContract.COL_PRENOM)));
            }});
        }
        return result;
    }

    @Override
    public boolean update(Utilisateur item) {
        ContentValues values = new ContentValues();
        values.put(UtilisateurContract.COL_NOM,item.getNom());
        values.put(UtilisateurContract.COL_PRENOM,item.getPrenom());
        String[] whereDatas = new String[1];
        whereDatas[0] = item.getId().toString();
        int result = db.update(UtilisateurContract.TABLE_NAME,values,
                UtilisateurContract.COL_ID + "=?",whereDatas);
        if (result == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        String[] whereDatas = new String[1];
        whereDatas[0] = id.toString();
        int result = db.delete(UtilisateurContract.TABLE_NAME,
                UtilisateurContract.COL_ID + "=?",whereDatas);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Utilisateur insert(Utilisateur item) {
        ContentValues values = new ContentValues();
        values.put(UtilisateurContract.COL_NOM,item.getNom());
        values.put(UtilisateurContract.COL_PRENOM,item.getPrenom());
        item.setId(db.insert(UtilisateurContract.TABLE_NAME,null,values));
        return item;
    }
}
