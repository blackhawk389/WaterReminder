package com.example.sarahn.waterreminderapp.classes

import android.content.Context
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.classes.ClsJobService
import com.firebase.jobdispatcher.*

/**
 * Created by SarahN on 6/20/2017.
 */
object ClsSceduler {
    fun Scheduler(context: Context?) {
        val duration = SharedPrefUtils.getDuration(context)
        val dispatcher = FirebaseJobDispatcher(GooglePlayDriver(context))
        val job = dispatcher.newJobBuilder()
                .setService(ClsJobService::class.java) // the JobService that will be called
                .setTag("notification") // uniquely identifies the job
                .setTrigger(Trigger.executionWindow(duration * 60, duration * 60))
                .setLifetime(Lifetime.FOREVER)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                .setRecurring(true)
                .build()
        dispatcher.mustSchedule(job)

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