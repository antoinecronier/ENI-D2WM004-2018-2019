package fr.acos.androkado.views.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        this.dataContent = this.findViewById(R.id.viewContainer);
        this.editText = this.findViewById(R.id.urltoFind);
    }

    public void btn6Clicked(View view) throws JSONException {
        Utilisateur u = new Utilisateur("jean","michel");
        u.setId(10L);
        JSONObject json = new JSONObject(gson.toJson(u));
        this.populateView(json);
    }

    public void btn5Clicked(View view) throws JSONException, ExecutionException, InterruptedException {

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni != null && ni.isConnected()){
            /* API load */
            String url = this.editText.getText().toString();

            String result = new AccesDatas().execute(url).get();

            this.populateView2(new JSONObject(result));
        }else{
            Toast.makeText(this,"Not connected to network",Toast.LENGTH_SHORT).show();
        }
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

    private class AccesDatas extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            String urlView = strings[0];

            HttpURLConnection httpURLConnection = null;

            StringBuffer stringBuffer = new StringBuffer();

            try {
                URL url = new URL(urlView);

                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int charItem;

                while ((charItem = inputStreamReader.read()) != -1){
                    stringBuffer.append((char)charItem);
                }

                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return stringBuffer.toString();
        }
    }
}
