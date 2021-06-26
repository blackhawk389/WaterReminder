package com.example.sarahn.waterreminderapp.classes

import android.content.Context
import android.content.Intent
import androidx.legacy.content.WakefulBroadcastReceiver
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils

/**
 * Created by SarahN on 7/3/2017.
 */
class ClsRestartAlarm : WakefulBroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if ("android.intent.action.BOOT_COMPLETED" == intent.action) {
            SharedPrefUtils.setIsBoot(context, true)
            val i = Intent(context, BootService::class.java)
            context.startService(i)
        }
    }
}