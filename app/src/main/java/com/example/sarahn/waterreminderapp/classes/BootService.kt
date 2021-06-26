package com.example.sarahn.waterreminderapp.classes

import android.app.IntentService
import android.content.Intent
import com.example.sarahn.waterreminderapp.Utils.AlarmManagerUtils

/**
 * Created by SarahN on 7/3/2017.
 */
class BootService : IntentService("boot service") {
    override fun onHandleIntent(intent: Intent?) {
        AlarmManagerUtils.setStartAlarm()
        AlarmManagerUtils.setEndAlarm()
    }
}