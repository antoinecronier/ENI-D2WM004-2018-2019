package com.tactfactory.vroom.views.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.fragments.VoitureDetailsFragment;
import com.tactfactory.vroom.views.interfaces.EditableView;

public class VoitureDetailsActivity extends AppCompatActivity implements VoitureDetailsFragment.OnFragmentInteractionListener {

    public static final String FRAGMENT_ITEM = "fragmentItem";
    public static final String GARAGISTE = "garagiste";
    private EditableView voitureFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voiture_details);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        VoitureDetailsFragment fragment = new VoitureDetailsFragment();

        Intent navigation = this.getIntent();
        if (navigation != null && navigation.getSerializableExtra(ListVoitureActivity.VOITURE) != null){
            Voiture voiture = (Voiture) navigation.getSerializableExtra(ListVoitureActivity.VOITURE);

            Bundle bundle = new Bundle();
            bundle.putSerializable(FRAGMENT_ITEM,voiture);
            fragment.setArguments(bundle);
        }

        fragmentTransaction.add(R.id.fragmentDetailsContainer, fragment);
        fragmentTransaction.commit();
        voitureFragment = fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.activity_details_voiture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_voiture_details_save:
                this.voitureFragment.save();
                this.startActivity(new Intent(this,ListVoitureActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Garagiste garagiste) {
        Intent navigation = new Intent(this,GaragisteDetailsActivity.class);
        navigation.putExtra(GARAGISTE,garagiste);
        this.startActivity(navigation);
    }
}
