package com.example.sarahn.waterreminderapp.classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;

/**
 * Created by SarahN on 6/19/2017.
 */
public class ClsBroadCastReciver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Time begins" , Toast.LENGTH_SHORT).show();
        SharedPrefUtils.removeConsumed(context);
        ClsSceduler.Scheduler(context);
    }
}
