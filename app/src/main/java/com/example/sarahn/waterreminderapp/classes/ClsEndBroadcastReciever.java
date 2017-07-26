package com.example.sarahn.waterreminderapp.classes;

import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;

/**
 * Created by SarahN on 6/19/2017.
 */
public class ClsEndBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));

        dispatcher.cancel("notification");

//        JobScheduler jobScheduler =  (JobScheduler) context.getSystemService (Context.JOB_SCHEDULER_SERVICE);
//        jobScheduler.cancel(0);

        Toast.makeText(context, "End Time", Toast.LENGTH_SHORT).show();
    }
}
