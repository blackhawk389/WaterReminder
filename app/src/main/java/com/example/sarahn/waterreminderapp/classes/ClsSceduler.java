package com.example.sarahn.waterreminderapp.classes;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.Utils.NotificationUtills;

/**
 * Created by SarahN on 6/20/2017.
 */
public class ClsSceduler {

    public static void Scheduler(Context context){

        int duration = NotificationUtills.NotificationCounter();
       // duration = duration * 1000;

        Log.i("MainActivity ","duration " + duration);

        ComponentName componentName = new ComponentName(context , ClsJobService.class);

        JobInfo.Builder builder =  new JobInfo.Builder(0, componentName)
               // .setPeriodic(300000);

                .setPeriodic(duration * 60 * 1000);
        //2:06


        JobScheduler jobScheduler =  (JobScheduler) context.getSystemService (Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());


    }

}
