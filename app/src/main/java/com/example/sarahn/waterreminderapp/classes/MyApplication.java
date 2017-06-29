package com.example.sarahn.waterreminderapp.classes;

import android.app.Application;
import android.content.Context;

/**
 * Created by SarahN on 6/28/2017.
 */
public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }

    //getting things on main thread and application context managment of code
}
