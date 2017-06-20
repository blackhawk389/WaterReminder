package com.example.sarahn.waterreminderapp.classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SarahN on 6/19/2017.
 */
public class ClsBroadCastReciver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "fired start" , Toast.LENGTH_SHORT).show();
        ClsSceduler.Scheduler(context);
    }
}
