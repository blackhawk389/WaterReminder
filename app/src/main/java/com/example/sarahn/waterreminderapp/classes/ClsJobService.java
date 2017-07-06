package com.example.sarahn.waterreminderapp.classes;

import android.app.job.JobParameters;
import android.app.job.JobService;

import com.example.sarahn.waterreminderapp.Utils.Logging;
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;

/**
 * Created by SarahN on 6/18/2017.
 */
public class ClsJobService extends JobService {

    public static JobParameters jobId;

    @Override
    public boolean onStartJob(JobParameters params) {

        if(SharedPrefUtils.getRequired(getApplicationContext()) == SharedPrefUtils.getConsumed(getApplicationContext())){
            Logging.logMessage("requirement is equal to consumed");
            return false;
        }else{
            NotificationUtills.notificationBuilder(getApplicationContext());
            Logging.logMessage("requirement is not equal to consumed");
            return true;
        }


    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }


}
