package com.tactfactory.vroom.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.database.DatabaseHelper;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.utils.VoitureUtils;
import com.tactfactory.vroom.views.fragments.VoitureListFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements VoitureListFragment.OnListFragmentInteractionListener {

    public static final String VOITURE = "voiture";
    private static final String TAG = "MainActiivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
//                List<Voiture> voitures = VoitureUtils.generateVoituresAndGaragisteFullMapped();
//                DatabaseHelper.getInstance().getDatabase().voitureDao().insertEager(voitures);
//
//                List<Voiture> voitures1 = DatabaseHelper.getInstance().getDatabase().voitureDao().selectEager();
//
//                List<Garagiste> garagistes = DatabaseHelper.getInstance().getDatabase().garagisteDao().selectEager();
//
//                DatabaseHelper.getInstance().getDatabase().garagisteDao().insertEager(garagistes.get(0));


            }
        }).start();

    }

    @Override
    public void onListFragmentInteraction(Voiture item) {
        Intent navigation = new Intent(this,VoitureDetailsActivity.class);
        navigation.putExtra(VOITURE,item);
        this.startActivity(navigation);
    }
}
