package fr.acos.androkado.views.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fr.acos.androkado.R;
import fr.acos.androkado.entities.Utilisateur;
import fr.acos.androkado.views.fragments.BlankFragment;
import fr.acos.androkado.views.fragments.MyUtilisateurRecyclerViewAdapter;
import fr.acos.androkado.views.fragments.UtilisateurFragment;

public class Main2Activity extends AppCompatActivity implements UtilisateurFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        UtilisateurFragment fragment = new UtilisateurFragment();
        fragmentTransaction.add(R.id.mainActivity2FragmentContainer, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(Utilisateur item) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();
    }
}
