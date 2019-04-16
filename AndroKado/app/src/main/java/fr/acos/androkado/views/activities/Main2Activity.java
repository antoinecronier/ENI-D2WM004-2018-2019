package fr.acos.androkado.views.activities;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import fr.acos.androkado.R;
import fr.acos.androkado.entities.Contact;
import fr.acos.androkado.entities.Utilisateur;
import fr.acos.androkado.utils.ProgressableActivity;
import fr.acos.androkado.views.fragments.BlankFragment;
import fr.acos.androkado.views.fragments.MyUtilisateurRecyclerViewAdapter;
import fr.acos.androkado.views.fragments.UtilisateurFragment;

public class Main2Activity extends AppCompatActivity implements UtilisateurFragment.OnListFragmentInteractionListener, ProgressableActivity {

    private static final String TAG = "Main2Activity";
    private ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /* Get progress bar */
        progressBar = this.findViewById(R.id.progressBarActivityMain2);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        UtilisateurFragment fragment = new UtilisateurFragment();
        fragmentTransaction.add(R.id.mainActivity2FragmentContainer, fragment);
        fragmentTransaction.commit();

        ((Button) this.findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.this.startActivity(new Intent(Main2Activity.this,Main5Activity.class));
            }
        });

        if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            contactsCall();
        }

    }

    private void contactsCall() {
        ContentResolver cr = getContentResolver();
        final Cursor cursor = cr.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null);

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        while (cursor.moveToNext()){
            contacts.add(new Contact(){{
                setNom(
                        cursor.getString(
                                cursor.getColumnIndex(
                                        ContactsContract.Contacts.DISPLAY_NAME)));
            }});
        }

        for (Contact contact: contacts) {
            Log.d(TAG,contact.toString());
        }
    }

    @Override
    public void onListFragmentInteraction(Utilisateur item) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public ProgressBar getProgressBar() {
        return this.progressBar;
    }
}
