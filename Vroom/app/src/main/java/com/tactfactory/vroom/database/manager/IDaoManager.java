package com.tactfactory.vroom.database.manager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tactfactory.vroom.database.DatabaseHelper;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;

import java.util.ArrayList;
import java.util.List;

public interface IDaoManager<T>{
    public void delete(T item);
    public void update(T item);
    public T select(Long id);
    public List<T> select();
    public void insertLazy(List<T> items);
    public void insertLazy(T item);
    public void insertEager(List<T> items);
    public void insertEager(T item);
    public T selectEager(Long id);
    public List<T> selectEager();
}
