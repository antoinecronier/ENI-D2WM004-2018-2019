package fr.acos.androkado.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import fr.acos.androkado.R;
import fr.acos.androkado.entities.Utilisateur;

public class Main6Activity extends AppCompatActivity {

    private static final String TAG = "Main6Activity";
    
    private static final String WEB_DATA = 
            "{" +
                "\"userId\": 1," +
                "\"id\": 1," +
                "\"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\"," +
                "\"body\": \"quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto\"" +
            "}";

    private LinearLayout dataContent = null;
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        this.dataContent = this.findViewById(R.id.viewContainer);
    }

    public void btn6Clicked(View view) throws JSONException {
        Utilisateur u = new Utilisateur("jean","michel");
        u.setId(10L);
        JSONObject json = new JSONObject(gson.toJson(u));
        this.populateView(json);
    }

    public void btn5Clicked(View view) throws JSONException {
        this.populateView2(new JSONObject(WEB_DATA));
    }

    public void btn4Clicked(View view) {
        dataContent.removeAllViews();
    }

    public void populateView(JSONObject json) throws JSONException {
        for (Iterator<String> it = json.keys(); it.hasNext(); ) {
            String key = it.next();

            if(json.get(key) instanceof Integer
                    || json.get(key) instanceof Double
                    || json.get(key) instanceof String
                    || json.get(key) instanceof Boolean
                    || json.get(key) instanceof Long){
                TextView txtV = new TextView(this);
                txtV.setText(json.get(key).toString());
                dataContent.addView(txtV);
            } else if(json.get(key) instanceof List){
            } else {
            }
        }
    }

    public void populateView2(JSONObject json) throws JSONException {
        for (Iterator<String> it = json.keys(); it.hasNext(); ) {
            String key = it.next();
            if(json.get(key) instanceof Integer){

            } else if(json.get(key) instanceof Double){

            } else if(json.get(key) instanceof Boolean){

            } else if(json.get(key) instanceof String){

            }

            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView txtVKey = new TextView(this);
            txtVKey.setText(key + " : ");

            TextView txtVData = new TextView(this);
            txtVData.setPadding(20,0,0,0);
            txtVData.setText(json.get(key).toString());

            linearLayout.addView(txtVKey);
            linearLayout.addView(txtVData);

            dataContent.addView(linearLayout);
        }
    }
}
