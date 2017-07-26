package com.example.sarahn.waterreminderapp.classes;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.Utils.Logging;
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

import java.util.concurrent.TimeUnit;

/**
 * Created by SarahN on 6/20/2017.
 */
public class ClsSceduler {

    public static void Scheduler(Context context){

        int duration = SharedPrefUtils.getDuration(context);

        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));

        Job job = dispatcher.newJobBuilder()
                .setService(ClsJobService.class) // the JobService that will be called
                .setTag("notification")        // uniquely identifies the job
                .setTrigger(Trigger.executionWindow(duration * 60, duration * 60))
                .setLifetime(Lifetime.FOREVER)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                .setRecurring(true)
                .build();



        dispatcher.mustSchedule(job);

//        ComponentName componentName = new ComponentName(context , ClsJobService.class);
//
//        Logging.logMessage("duration " + duration);
//        JobInfo.Builder builder =  new JobInfo.Builder(0, componentName)
//              //  .setPeriodic(120000);
//
//               .setPeriodic(duration * 60 * 1000);
//        //2:06
//        JobScheduler jobScheduler =  (JobScheduler) context.getSystemService (Context.JOB_SCHEDULER_SERVICE);
//        jobScheduler.schedule(builder.build());

    }
}
