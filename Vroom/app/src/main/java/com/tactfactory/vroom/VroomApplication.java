package com.tactfactory.vroom;

import android.app.Application;
import android.content.Context;

public class VroomApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        VroomApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return VroomApplication.context;
    }
}
