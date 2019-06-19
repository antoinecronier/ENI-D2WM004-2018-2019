package com.tactfactory.vroom.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tactfactory.vroom.database.DatabaseHelper;
import com.tactfactory.vroom.entities.Voiture;

import java.util.List;

@Dao
public abstract class VoitureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract Long insertInternal(Voiture voiture);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract Long[] insertInternal(List<Voiture> voitures);

    @Delete
    public abstract void delete(Voiture voiture);

    @Update
    public abstract void update(Voiture voiture);

    @Query("SELECT * FROM voiture WHERE idVoiture = :id")
    public abstract Voiture select(Long id);

    @Query("SELECT * FROM voiture")
    public abstract List<Voiture> select();

    public void insertLazy(List<Voiture> voitures){
        fillItemsWithNewIds(insertInternal(voitures),voitures);
    }

    public void insertLazy(Voiture voiture){
        voiture.setId(insertInternal(voiture));
    }

    public void insertEager(List<Voiture> voitures) {
        for(Voiture voiture: voitures) {

            if (voiture.getGaragisteId() == null){
                if (voiture.getGaragiste() != null){
                    if (voiture.getGaragiste().getId() == null){
                        DatabaseHelper.getInstance().getDatabase().
                                        garagisteDao().insertLazy(voiture.getGaragiste());
                    }
                    voiture.setGaragisteId(voiture.getGaragiste().getId());
                }
            }
        }

        insertLazy(voitures);
    }

    private void fillItemsWithNewIds(Long[] ids, List<Voiture> voitures) {
        for (int i = 0; i < ids.length; i++) {
            voitures.get(i).setId(ids[i]);
        }
    }

    public void insertEager(Voiture voiture) {
        if (voiture.getGaragisteId() == null){
            if (voiture.getGaragiste() != null){
                if (voiture.getGaragiste().getId() == null){
                    DatabaseHelper.getInstance().getDatabase().
                            garagisteDao().insertLazy(voiture.getGaragiste());
                }
                voiture.setGaragisteId(voiture.getGaragiste().getId());
            }
        }
        insertLazy(voiture);
    }

    public List<Voiture> selectEager() {
        List<Voiture> result = select();
        for (Voiture voiture: result) {
            if (voiture.getGaragisteId() != null) {
                voiture.setGaragiste(DatabaseHelper.getInstance().getDatabase().
                        garagisteDao().select(voiture.getGaragisteId()));
            }
        }
        return result;
    }

    @Query("SELECT * FROM voiture WHERE garagisteId = :id")
    public abstract List<Voiture> selectWithGaragisteId(Long id);
}
