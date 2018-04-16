package com.example.preferences.shared.sharedpreferences.myApp;

import android.app.Application;
import android.os.SystemClock;


/*Esta clase tambien se puede usar para el tiempo de vista del splash*/
public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        SystemClock.sleep(5000);
    }
}
