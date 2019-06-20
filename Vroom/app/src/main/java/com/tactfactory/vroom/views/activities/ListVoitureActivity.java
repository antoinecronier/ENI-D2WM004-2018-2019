package com.tactfactory.vroom.views.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.fragments.VoitureListFragment;

public class ListVoitureActivity extends AppCompatActivity implements VoitureListFragment.OnListFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    public static final String VOITURE = "voiture";
    private static final String TAG = "MainActiivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_voiture);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_list_voiture);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_voiture);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_list_voiture);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                List<Voiture> voitures = VoitureUtils.generateVoituresAndGaragisteFullMapped();
////                DatabaseHelper.getInstance().getDatabase().voitureDao().insertEager(voitures);
////
////                List<Voiture> voitures1 = DatabaseHelper.getInstance().getDatabase().voitureDao().selectEager();
////
////                List<Garagiste> garagistes = DatabaseHelper.getInstance().getDatabase().garagisteDao().selectEager();
////
////                DatabaseHelper.getInstance().getDatabase().garagisteDao().insertEager(garagistes.get(0));
//
//
//            }
//        }).start();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_voiture_crud_new) {
            Intent navigation = new Intent(this,VoitureDetailsActivity.class);
            this.startActivity(navigation);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_voiture);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_voiture);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onListFragmentInteraction(Voiture item) {
        Intent navigation = new Intent(this,VoitureDetailsActivity.class);
        navigation.putExtra(VOITURE,item);
        this.startActivity(navigation);
    }
}
