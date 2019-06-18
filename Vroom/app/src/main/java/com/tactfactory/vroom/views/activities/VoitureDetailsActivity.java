package com.tactfactory.vroom.views.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.fragments.VoitureDetailsFragment;

public class VoitureDetailsActivity extends AppCompatActivity implements VoitureDetailsFragment.OnFragmentInteractionListener {

    public static final String FRAGMENT_ITEM = "fragmentItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voiture_details);

        Intent navigation = this.getIntent();
        if (navigation != null && navigation.getSerializableExtra(MainActivity.VOITURE) != null){
            Voiture voiture = (Voiture) navigation.getSerializableExtra(MainActivity.VOITURE);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            VoitureDetailsFragment fragment = new VoitureDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(FRAGMENT_ITEM,voiture);
            fragment.setArguments(bundle);
            fragmentTransaction.add(R.id.fragmentDetailsContainer, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
