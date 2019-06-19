package com.tactfactory.vroom.views.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.database.AppDatabase;
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
                AppDatabase db = Room.databaseBuilder(MainActivity.this,AppDatabase.class,"db1").build();

                List<Voiture> voitures = VoitureUtils.generateVoitures();
                db.voitureDao().insert(voitures);

                List<Voiture> voitures1 = db.voitureDao().select();

                for (Voiture voiture: voitures1) {
                    Log.d(TAG, voiture.getNom());
                }
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
