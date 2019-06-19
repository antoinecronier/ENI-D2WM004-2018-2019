package com.tactfactory.vroom.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tactfactory.vroom.entities.Voiture;

import java.util.List;

@Dao
public interface VoitureDao {

    @Insert
    void insert(Voiture voiture);

    @Insert
    void insert(List<Voiture> voitures);

    @Delete
    void delete(Voiture voiture);

    @Update
    void update(Voiture voiture);

    @Query("SELECT * FROM voiture WHERE id = :id")
    Voiture select(Long id);

    @Query("SELECT * FROM voiture")
    List<Voiture> select();
}
