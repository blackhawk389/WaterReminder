package com.example.sarahn.waterreminderapp.classes;

import android.app.job.JobParameters;
import android.app.job.JobService;

import com.example.sarahn.waterreminderapp.Utils.NotificationUtills;

/**
 * Created by SarahN on 6/18/2017.
 */
public class ClsJobService extends JobService {

    public static JobParameters jobId;

    @Override
    public boolean onStartJob(JobParameters params) {
        jobId = params;
        NotificationUtills.notificationBuilder(getApplicationContext());
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }


}
