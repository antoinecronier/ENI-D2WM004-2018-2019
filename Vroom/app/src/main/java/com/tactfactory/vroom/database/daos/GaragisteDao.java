package com.tactfactory.vroom.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tactfactory.vroom.database.DatabaseHelper;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class GaragisteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract Long insertInternal(Garagiste garagiste);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract Long[] insertInternal(List<Garagiste> garagistes);

    @Delete
    public abstract void delete(Garagiste voiture);

    @Update
    public abstract void update(Garagiste voiture);

    @Query("SELECT * FROM garagiste WHERE idGaragiste = :id")
    public abstract Garagiste select(Long id);

    @Query("SELECT * FROM garagiste")
    public abstract List<Garagiste> select();

    public void insertLazy(List<Garagiste> garagistes){
        fillItemsWithNewIds(insertInternal(garagistes),garagistes);
    }

    public void insertLazy(Garagiste garagiste){
        garagiste.setId(insertInternal(garagiste));
    }

    public void insertEager(List<Garagiste> garagistes) {
        for (Garagiste garagiste : garagistes) {
            if (garagiste.getVoitures() != null) {
                for (Voiture voiture : garagiste.getVoitures()) {
                    if (voiture.getGaragisteId() == null || voiture.getGaragisteId() != garagiste.getId()) {
                        voiture.setGaragisteId(garagiste.getId());
                        DatabaseHelper.getInstance().getDatabase().
                                voitureDao().insertLazy(voiture);
                    }
                }

            }
        }
        insertLazy(garagistes);
    }

    private void fillItemsWithNewIds(Long[] ids, List<Garagiste> garagistes) {
        for (int i = 0; i < ids.length; i++) {
            garagistes.get(i).setId(ids[i]);
        }
    }

    public void insertEager(Garagiste garagiste) {
        if (garagiste.getVoitures() != null) {
            for (Voiture voiture : garagiste.getVoitures()) {
                if (voiture.getGaragisteId() == null || voiture.getGaragisteId() != garagiste.getId()) {
                    voiture.setGaragisteId(garagiste.getId());
                    DatabaseHelper.getInstance().getDatabase().
                            voitureDao().insertLazy(voiture);
                }
            }

        }
        insertLazy(garagiste);
    }

    public Garagiste selectEager(Long id) {
        Garagiste result = select(id);
        result.setVoitures(DatabaseHelper.getInstance().getDatabase().
                voitureDao().selectWithGaragisteId(result.getId()));

        if (result.getVoitures() == null) {
            result.setVoitures(new ArrayList<Voiture>());
        }
        return result;
    }

    public List<Garagiste> selectEager() {
        List<Garagiste> result = select();
        for (Garagiste garagiste : result) {
            garagiste.setVoitures(DatabaseHelper.getInstance().getDatabase().
                    voitureDao().selectWithGaragisteId(garagiste.getId()));

            if (garagiste.getVoitures() == null) {
                garagiste.setVoitures(new ArrayList<Voiture>());
            }
        }
        return result;
    }
}
