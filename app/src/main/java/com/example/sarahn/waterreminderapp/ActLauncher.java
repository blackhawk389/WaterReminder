package com.example.sarahn.waterreminderapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.example.sarahn.waterreminderapp.classes.ClsSplashRunnable;


public class ActLauncher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_launcher);

        new Handler().postDelayed(new ClsSplashRunnable(this), 4000);
    }

}
