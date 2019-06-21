package com.tactfactory.vroom.views.asyncworkers;


import android.os.AsyncTask;

import com.tactfactory.vroom.database.manager.IDaoManager;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.interfaces.UpdatableItem;

import java.util.List;

public class HydrateDatas<T> extends AsyncTask<Void,Void,List<T>> {
    private final UpdatableItem item;
    private final IDaoManager dao;

    public HydrateDatas(UpdatableItem adapter, IDaoManager dao) {
        this.item = adapter;
        this.dao = dao;
    }

    @Override
    protected List<T> doInBackground(Void... voids) {
        return dao.select();
    }

    @Override
    protected void onPostExecute(List<T> items) {
        super.onPostExecute(items);
        this.item.update(items);
    }
}
