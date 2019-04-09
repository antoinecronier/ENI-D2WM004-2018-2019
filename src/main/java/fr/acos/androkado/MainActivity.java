package fr.acos.androkado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import fr.acos.androkado.entities.Utilisateur;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"OnCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"OnStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"OnResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroy");
        Log.d("Test","coucou");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"OnPause");
    }

    public void onImageButtonClicked(View view) {
        for (int i = 0; i < 3; i++) {
            Toast.makeText(this, "This is a Toast message " + i, Toast.LENGTH_SHORT).show();
        }

        Intent navigation = new Intent(this,Main2Activity.class);
        navigation.putExtra(this.getString(R.string.MY_USER_INTENT), new Utilisateur("jean","michel"));
        this.startActivity(navigation);
    }
}
