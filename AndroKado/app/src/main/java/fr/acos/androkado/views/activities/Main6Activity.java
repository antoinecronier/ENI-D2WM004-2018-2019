package fr.acos.androkado.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.acos.androkado.R;
import fr.acos.androkado.entities.Utilisateur;

public class Main6Activity extends AppCompatActivity {

    private final static String JSON =
            "{\"Pays\":" +
                "[" +
                    "\"France\"," +
                    "\"Afrique du sud\"," +
                    "\"Burkina Faso\"," +
                    "\"Irlande\"," +
                    "\"Palestine\"," +
                    "\"Portugal\"," +
                    "\"Suisse\"" +
                "]" +
            "}";
    private static final String TAG = "Main6Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        try {
            JSONObject jsonObject = new JSONObject(JSON);

            JSONArray jsonArray = jsonObject.getJSONArray("Pays");

            Log.d(TAG,jsonObject.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                Log.d(TAG,jsonArray.get(i).toString());

            }

            Gson gson = new Gson();
            String jsonUtilisateur = gson.toJson(new Utilisateur("jean","michel"));
            Log.d(TAG,jsonUtilisateur.toString());

            String jsonUtilisateur1 = gson.toJson(new Utilisateur());
            Log.d(TAG,jsonUtilisateur1.toString());

            Utilisateur parsedUser1 = gson.fromJson(jsonUtilisateur,Utilisateur.class);
            Log.d(TAG,parsedUser1.toString());

            Utilisateur parsedUser2 = gson.fromJson(jsonUtilisateur1,Utilisateur.class);
            Log.d(TAG,parsedUser2.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
