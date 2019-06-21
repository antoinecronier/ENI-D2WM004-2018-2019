package com.tactfactory.vroom.database.manager;

import android.arch.persistence.room.Dao;

import com.tactfactory.vroom.database.DatabaseHelper;
import com.tactfactory.vroom.entities.Garagiste;

import java.util.List;

public class GaragisteManager implements IDaoManager<Garagiste> {

    @Override
    public void delete(Garagiste item) {
        DatabaseHelper.getInstance().getDatabase().garagisteDao().delete(item);
    }

    @Override
    public void update(Garagiste item) {
        DatabaseHelper.getInstance().getDatabase().garagisteDao().update(item);
    }

    @Override
    public Garagiste select(Long id) {
        return DatabaseHelper.getInstance().getDatabase().garagisteDao().select(id);
    }

    @Override
    public List<Garagiste> select() {
        return DatabaseHelper.getInstance().getDatabase().garagisteDao().select();
    }

    @Override
    public void insertLazy(List<Garagiste> items) {
        DatabaseHelper.getInstance().getDatabase().garagisteDao().insertLazy(items);
    }

    @Override
    public void insertLazy(Garagiste item) {
        DatabaseHelper.getInstance().getDatabase().garagisteDao().insertLazy(item);
    }

    @Override
    public void insertEager(List<Garagiste> items) {
        DatabaseHelper.getInstance().getDatabase().garagisteDao().insertEager(items);
    }

    @Override
    public void insertEager(Garagiste item) {
        DatabaseHelper.getInstance().getDatabase().garagisteDao().insertEager(item);
    }

    @Override
    public Garagiste selectEager(Long id) {
        return DatabaseHelper.getInstance().getDatabase().garagisteDao().selectEager(id);
    }

    @Override
    public List<Garagiste> selectEager() {
        return DatabaseHelper.getInstance().getDatabase().garagisteDao().selectEager();
    }
}
