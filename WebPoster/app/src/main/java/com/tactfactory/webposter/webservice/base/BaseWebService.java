package com.tactfactory.webposter.webservice.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import com.tactfactory.webposter.WebPosterApplication;
import com.tactfactory.webposter.webservice.WebServicable;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class BaseWebService<T extends WebServicable, K> extends AsyncTask<Void,Void,K> {
    private String resourceUrl;

    public BaseWebService(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Override
    protected K doInBackground(Void... voids) {

        ConnectivityManager cm = (ConnectivityManager) WebPosterApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni != null && ni.isConnected()){
            HttpURLConnection httpURLConnection = null;

            StringBuffer stringBuffer = new StringBuffer();

            try {
                URL url = new URL(resourceUrl);

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

            try {
                return parseDatas(stringBuffer.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    protected abstract K parseDatas(String s) throws JSONException;
}
