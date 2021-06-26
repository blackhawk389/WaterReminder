package com.example.sarahn.waterreminderapp.classes

import com.example.sarahn.waterreminderapp.Utils.Logging
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService

/**
 * Created by SarahN on 6/18/2017.
 */
class ClsJobService : JobService() {
    override fun onStartJob(params: JobParameters): Boolean {
        return if (SharedPrefUtils.getRequired(applicationContext) == SharedPrefUtils.getConsumed(applicationContext)) {
            Logging.logMessage("requirement is equal to consumed")
            false
        } else {
            NotificationUtills.notificationBuilder(applicationContext)
            Logging.logMessage("requirement is not equal to consumed")
            true
        }
    }

    override fun onStopJob(params: JobParameters): Boolean {
        return false
    }

    companion object {
        var jobId: JobParameters? = null
    }
}