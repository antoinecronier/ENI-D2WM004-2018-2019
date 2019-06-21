package com.tactfactory.vroom.database.manager;

import com.tactfactory.vroom.database.DatabaseHelper;
import com.tactfactory.vroom.entities.Voiture;

import java.util.List;

public class VoitureManager implements IDaoManager<Voiture> {
    @Override
    public void delete(Voiture item) {
        DatabaseHelper.getInstance().getDatabase().voitureDao().delete(item);
    }

    @Override
    public void update(Voiture item) {
        DatabaseHelper.getInstance().getDatabase().voitureDao().update(item);
    }

    @Override
    public Voiture select(Long id) {
        return DatabaseHelper.getInstance().getDatabase().voitureDao().select(id);
    }

    @Override
    public List<Voiture> select() {
        return DatabaseHelper.getInstance().getDatabase().voitureDao().select();
    }

    @Override
    public void insertLazy(List<Voiture> items) {
        DatabaseHelper.getInstance().getDatabase().voitureDao().insertLazy(items);
    }

    @Override
    public void insertLazy(Voiture item) {
        DatabaseHelper.getInstance().getDatabase().voitureDao().insertLazy(item);
    }

    @Override
    public void insertEager(List<Voiture> items) {
        DatabaseHelper.getInstance().getDatabase().voitureDao().insertEager(items);
    }

    @Override
    public void insertEager(Voiture item) {
        DatabaseHelper.getInstance().getDatabase().voitureDao().insertLazy(item);
    }

    @Override
    public Voiture selectEager(Long id) {
        return DatabaseHelper.getInstance().getDatabase().voitureDao().select(id);
    }

    @Override
    public List<Voiture> selectEager() {
        return DatabaseHelper.getInstance().getDatabase().voitureDao().selectEager();
    }
}
