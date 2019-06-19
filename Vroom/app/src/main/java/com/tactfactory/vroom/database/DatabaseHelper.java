package com.tactfactory.vroom.database;

import android.arch.persistence.room.Room;

import com.tactfactory.vroom.VroomApplication;

public class DatabaseHelper {
    private static final String DB_NAME = "db1";
    private final AppDatabase database;

    private DatabaseHelper() {
        database = Room.databaseBuilder(VroomApplication.getAppContext().getApplicationContext(),AppDatabase.class,DB_NAME).build();
    }

    private static volatile DatabaseHelper sInstance;

    public static DatabaseHelper getInstance() {

        if  (sInstance == null) {
            synchronized (DatabaseHelper.class) {
                if (sInstance == null) {
                    sInstance = new DatabaseHelper();
                }
            }
        }

        return sInstance;
    }

    public AppDatabase getDatabase(){
        return this.database;
    }
}
