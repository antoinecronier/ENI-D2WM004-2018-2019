package fr.acos.androkado;

import android.app.Application;
import android.content.Context;

public class AndrokadoApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        AndrokadoApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return AndrokadoApplication.context;
    }
}
