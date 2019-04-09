package fr.acos.androkado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fr.acos.androkado.entities.Utilisateur;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Intent mainActivityIntent = this.getIntent();

        Utilisateur myUser = (Utilisateur) mainActivityIntent.getParcelableExtra(
                this.getString(R.string.MY_USER_INTENT));

        Toast.makeText(this, myUser.toString(), Toast.LENGTH_LONG).show();
    }
}
