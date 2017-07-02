package com.example.sarahn.waterreminderapp.classes;

import android.app.IntentService;
import android.content.Intent;

import com.example.sarahn.waterreminderapp.Utils.NotificationUtills;

/**
 * Created by SarahN on 6/24/2017.
 */
public class ConsumedService extends IntentService {


    public ConsumedService() {
        super("");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if(intent.getAction().equals(NotificationUtills.ACTION_CANCEL)){
            NotificationUtills.cancelAll(this);
        }else if(intent.getAction().equals(NotificationUtills.ACTION_INCREMENT_WATER)){
            int diff = RemainingRequirement.difference(this);
            NotificationUtills.cancelAll(this);
        }

    }
}
