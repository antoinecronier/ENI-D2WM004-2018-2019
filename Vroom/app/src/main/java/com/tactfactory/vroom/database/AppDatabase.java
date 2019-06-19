package com.tactfactory.vroom.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.tactfactory.vroom.database.converters.DbConverter;
import com.tactfactory.vroom.database.daos.GaragisteDao;
import com.tactfactory.vroom.database.daos.VoitureDao;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;

@Database(entities = {Voiture.class, Garagiste.class}, version = 1)
@TypeConverters(value = {DbConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract VoitureDao voitureDao();
    public abstract GaragisteDao garagisteDao();
}

