package com.tactfactory.vroom.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tactfactory.vroom.database.daos.VoitureDao;
import com.tactfactory.vroom.entities.Voiture;

@Database(entities = {Voiture.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VoitureDao voitureDao();
}

