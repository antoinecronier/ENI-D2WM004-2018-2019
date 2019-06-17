package com.tactfactory.vroom.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.fragments.VoitureListFragment;

public class MainActivity extends AppCompatActivity implements VoitureListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(Voiture item) {
        Toast.makeText(this,item.getNom(),Toast.LENGTH_SHORT).show();
    }
}
