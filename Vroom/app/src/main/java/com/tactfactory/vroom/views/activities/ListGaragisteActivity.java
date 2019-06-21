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
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.views.fragments.GaragisteListFragment;
import com.tactfactory.vroom.views.fragments.VoitureListFragment;

public class ListGaragisteActivity extends AppCompatActivity implements GaragisteListFragment.OnListFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener{

    public static final String GARAGISTE = "garagiste";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_garagiste);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_list_garagiste);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_garagiste);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_list_garagiste);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_garagiste_crud_new) {
            Intent navigation = new Intent(this,GaragisteDetailsActivity.class);
            this.startActivity(navigation);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_list_garagiste);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(Garagiste item) {
        Intent navigation = new Intent(this,GaragisteDetailsActivity.class);
        navigation.putExtra(GARAGISTE,item);
        this.startActivity(navigation);
    }
}
