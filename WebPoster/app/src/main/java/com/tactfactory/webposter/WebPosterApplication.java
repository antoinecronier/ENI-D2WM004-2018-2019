package com.tactfactory.webposter;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WebPosterApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        WebPosterApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return WebPosterApplication.context;
    }
}
