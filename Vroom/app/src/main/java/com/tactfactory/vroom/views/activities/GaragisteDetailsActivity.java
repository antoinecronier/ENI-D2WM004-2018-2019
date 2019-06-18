package com.tactfactory.vroom.views.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.fragments.GaragisteDetailsFragment;
import com.tactfactory.vroom.views.fragments.VoitureDetailsFragment;
import com.tactfactory.vroom.views.fragments.VoitureListFragment;

public class GaragisteDetailsActivity extends AppCompatActivity implements GaragisteDetailsFragment.OnFragmentInteractionListener, VoitureListFragment.OnListFragmentInteractionListener {

    public static final String FRAGMENT_ITEM = "fragmentItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garagistre_details);

        Intent navigation = this.getIntent();
        if (navigation != null && navigation.getSerializableExtra(VoitureDetailsActivity.GARAGISTE) != null){
            Garagiste garagiste = (Garagiste) navigation.getSerializableExtra(VoitureDetailsActivity.GARAGISTE);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            GaragisteDetailsFragment fragment = new GaragisteDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(FRAGMENT_ITEM,garagiste);
            fragment.setArguments(bundle);
            fragmentTransaction.add(R.id.fragmentDetailsGaragisteContainer, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }

    @Override
    public void onListFragmentInteraction(Voiture item) {

    }
}
