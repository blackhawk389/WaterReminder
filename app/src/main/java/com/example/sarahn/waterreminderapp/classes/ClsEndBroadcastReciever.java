package com.example.sarahn.waterreminderapp.classes;

import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SarahN on 6/19/2017.
 */
public class ClsEndBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        JobScheduler jobScheduler =  (JobScheduler) context.getSystemService (Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.cancel(0);

//        Intent endjob = new Intent(context, CancelSchedular.class);
//        context.startService(endjob);

        Toast.makeText(context, "end alarm reciver", Toast.LENGTH_SHORT).show();
    }
}
