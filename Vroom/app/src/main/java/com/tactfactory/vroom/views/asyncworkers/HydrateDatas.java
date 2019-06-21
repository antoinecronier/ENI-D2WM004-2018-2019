package com.tactfactory.vroom.views.asyncworkers;


import android.os.AsyncTask;

import com.tactfactory.vroom.database.DatabaseHelper;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.interfaces.UpdatableItem;

import java.util.List;

public class HydrateDatas extends AsyncTask<Void,Void,List<Voiture>> {
    private final UpdatableItem item;

    public HydrateDatas(UpdatableItem adapter) {
        this.item = adapter;
    }

    @Override
    protected List<Voiture> doInBackground(Void... voids) {
        return DatabaseHelper.getInstance().getDatabase().voitureDao().select();
    }

    @Override
    protected void onPostExecute(List<Voiture> voitures) {
        super.onPostExecute(voitures);
        this.item.update(voitures);
    }
}
