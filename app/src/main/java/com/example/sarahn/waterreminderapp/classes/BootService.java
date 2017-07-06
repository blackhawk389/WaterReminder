package com.example.sarahn.waterreminderapp.classes;

import android.app.IntentService;
import android.content.Intent;

import com.example.sarahn.waterreminderapp.Utils.AlarmManagerUtils;
import com.example.sarahn.waterreminderapp.Utils.Logging;

import java.util.Date;

/**
 * Created by SarahN on 7/3/2017.
 */
public class BootService extends IntentService {

    public BootService() {
        super("boot service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        AlarmManagerUtils.setStartAlarm();
        AlarmManagerUtils.setEndAlarm();
    }
}
