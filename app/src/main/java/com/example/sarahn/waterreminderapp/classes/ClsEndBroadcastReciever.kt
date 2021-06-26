package com.example.sarahn.waterreminderapp.classes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.firebase.jobdispatcher.FirebaseJobDispatcher
import com.firebase.jobdispatcher.GooglePlayDriver

/**
 * Created by SarahN on 6/19/2017.
 */
class ClsEndBroadcastReciever : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val dispatcher = FirebaseJobDispatcher(GooglePlayDriver(context))
        dispatcher.cancel("notification")

//        JobScheduler jobScheduler =  (JobScheduler) context.getSystemService (Context.JOB_SCHEDULER_SERVICE);
//        jobScheduler.cancel(0);
        Toast.makeText(context, "End Time", Toast.LENGTH_SHORT).show()
    }
}