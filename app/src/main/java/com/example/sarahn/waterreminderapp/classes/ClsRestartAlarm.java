package com.example.sarahn.waterreminderapp.classes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.Utils.Logging;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;

/**
 * Created by SarahN on 7/3/2017.
 */
public class ClsRestartAlarm extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {

            SharedPrefUtils.setIsBoot(context, true);
            Intent i = new Intent(context, BootService.class);
            context.startService(i);
        }
    }
}
