package com.example.sarahn.waterreminderapp.classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by SarahN on 7/3/2017.
 */
public class ClsRestartAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {

            Intent i = new Intent(context, BootService.class);
            context.startService(i);
        }
    }
}
