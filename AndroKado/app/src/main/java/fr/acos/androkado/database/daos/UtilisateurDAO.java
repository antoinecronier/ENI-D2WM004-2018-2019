package fr.acos.androkado.database.daos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import fr.acos.androkado.database.DbOpenHelper;
import fr.acos.androkado.database.contracts.UtilisateurContract;
import fr.acos.androkado.entities.Utilisateur;
import fr.acos.androkado.utils.ProgressableActivity;
import fr.acos.androkado.utils.UpdatableAdapter;

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

    @Override
    public List<Utilisateur> select(ProgressableActivity progressableActivity) {
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

        progressableActivity.getProgressBar().setProgress(0);
        progressableActivity.getProgressBar().setMax(cursor.getCount());
        progressableActivity.getProgressBar().setVisibility(View.VISIBLE);

        while(cursor.moveToNext()){
            result.add(new Utilisateur(){{
                setId(cursor.getLong(cursor.getColumnIndex(UtilisateurContract.COL_ID)));
                setNom(cursor.getString(cursor.getColumnIndex(UtilisateurContract.COL_NOM)));
                setPrenom(cursor.getString(cursor.getColumnIndex(UtilisateurContract.COL_PRENOM)));
            }});
            progressableActivity.getProgressBar().setProgress(
                    progressableActivity.getProgressBar().getProgress()+1);
        }

        progressableActivity.getProgressBar().setVisibility(View.INVISIBLE);
        return result;
//        try {
//            return  new AsyncSelect().execute(progressableActivity).get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    public class AsyncSelect extends AsyncTask<ProgressableActivity,Void,List<Utilisateur>> {

        @Override
        protected List<Utilisateur> doInBackground(ProgressableActivity... progressableActivities) {
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

            progressableActivities[0].getProgressBar().setProgress(0);
            progressableActivities[0].getProgressBar().setMax(cursor.getCount());
            progressableActivities[0].getProgressBar().setVisibility(View.VISIBLE);

            while(cursor.moveToNext()){
                result.add(new Utilisateur(){{
                    setId(cursor.getLong(cursor.getColumnIndex(UtilisateurContract.COL_ID)));
                    setNom(cursor.getString(cursor.getColumnIndex(UtilisateurContract.COL_NOM)));
                    setPrenom(cursor.getString(cursor.getColumnIndex(UtilisateurContract.COL_PRENOM)));
                }});
                progressableActivities[0].getProgressBar().setProgress(progressableActivities[0].getProgressBar().getProgress()+1);
            }

            progressableActivities[0].getProgressBar().setVisibility(View.INVISIBLE);
            return result;
        }
    }
}
