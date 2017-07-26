package com.example.sarahn.waterreminderapp.classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.Utils.Logging;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.fragments.SettingsFragment;

/**
 * Created by SarahN on 6/19/2017.
 */
public class ClsBroadCastReciver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Time begins" , Toast.LENGTH_SHORT).show();

                    if(SettingsFragment.isFromSettings){
                        ClsSceduler.Scheduler(context);
                        Logging.logMessage("from setting");
                    }else if(SharedPrefUtils.getIsBoot(context)){
                        ClsSceduler.Scheduler(context);
                        Logging.logMessage("from boot ");
                        SharedPrefUtils.setIsBoot(context, false);
                    }else{
                        SharedPrefUtils.removeConsumed(context);
                        ClsSceduler.Scheduler(context);
                        Logging.logMessage("from regular ");
                        SettingsFragment.isFromSettings = false;
                    }
    }
}
