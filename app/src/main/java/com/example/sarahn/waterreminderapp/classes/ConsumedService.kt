package com.example.sarahn.waterreminderapp.classes

import android.app.IntentService
import android.content.Intent
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills

/**
 * Created by SarahN on 6/24/2017.
 */
class ConsumedService : IntentService("") {
    override fun onHandleIntent(intent: Intent?) {
        if (intent!!.action == NotificationUtills.ACTION_CANCEL) {
            NotificationUtills.cancelAll(this)
        } else if (intent.action == NotificationUtills.ACTION_INCREMENT_WATER) {
            RemainingRequirement.difference(this)
            NotificationUtills.cancelAll(this)
        }
    }
}