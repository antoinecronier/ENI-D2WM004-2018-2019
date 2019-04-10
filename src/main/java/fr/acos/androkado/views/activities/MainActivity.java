package fr.acos.androkado.views.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import fr.acos.androkado.views.fragments.BlankFragment;
import fr.acos.androkado.views.fragments.BlankFragment2;
import fr.acos.androkado.R;

/**
 * Use "implements BlankFragment.OnFragmentInteractionListener" for implementation 1 and 2
 */
public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, BlankFragment2.OnFragmentInteractionListener {
    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Start Fragment implementation 2 */
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        BlankFragment fragment = new BlankFragment();
        fragmentTransaction.add(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
        /* End Fragment implementation 2 */

        Log.d(TAG, "OnCreate");

        Button button = this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

                Intent impliciteIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + "0202020202"));
                MainActivity.this.startActivity(impliciteIntent);
            }
        });

        ((Button) this.findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navigate = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(navigate);
            }
        });
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
//        Intent navigation = new Intent(this,MainActivity5.class);
//        navigation.putExtra(this.getString(R.string.MY_USER_INTENT), new Utilisateur("jean","michel"));
//        this.startActivity(navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment f = this.getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if(f instanceof BlankFragment){
            BlankFragment2 fragment = new BlankFragment2();
            fragmentTransaction.add(R.id.fragmentContainer, fragment);
            fragmentTransaction.detach(f).attach(fragment).commit();
        }else{
            BlankFragment fragment = new BlankFragment();
            fragmentTransaction.add(R.id.fragmentContainer, fragment);
            fragmentTransaction.detach(f).attach(fragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction() {
        Toast.makeText(this,"hi from fragment",Toast.LENGTH_SHORT).show();
    }
}
