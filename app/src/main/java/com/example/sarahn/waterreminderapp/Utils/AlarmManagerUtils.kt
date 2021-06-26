package com.example.sarahn.waterreminderapp.Utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.sarahn.waterreminderapp.classes.ClsBroadCastReciver
import com.example.sarahn.waterreminderapp.classes.ClsEndBroadcastReciever
import com.example.sarahn.waterreminderapp.classes.MyApplication
import java.util.*

/**
 * Created by SarahN on 6/19/2017.
 */
object AlarmManagerUtils {
    fun setStartAlarm() {
        val alarmManager = MyApplication.context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = Calendar.getInstance()
        time.timeInMillis = System.currentTimeMillis()
        time[Calendar.HOUR_OF_DAY] = SharedPrefUtils.getStartHour(MyApplication.context)
        time[Calendar.MINUTE] = SharedPrefUtils.getStartMin(MyApplication.context)
        time[Calendar.SECOND] = 0
        alarmManager[AlarmManager.RTC_WAKEUP, time.timeInMillis] = pendingIntent(MyApplication.context!!)
    }

    private fun pendingIntent(context: Context): PendingIntent {
        val intent = Intent(context, ClsBroadCastReciver::class.java)
        return PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_ONE_SHOT)
    }

    fun setEndAlarm() {
        val alarmManager = MyApplication.context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = Calendar.getInstance()
        time.timeInMillis = System.currentTimeMillis()
        time[Calendar.HOUR_OF_DAY] = SharedPrefUtils.getEndHour(MyApplication.context)
        time[Calendar.MINUTE] = SharedPrefUtils.getEndMin(MyApplication.context)
        time[Calendar.SECOND] = 0
        alarmManager[AlarmManager.RTC_WAKEUP, time.timeInMillis] = endPendingIntent(MyApplication.context!!)
    }

    private fun endPendingIntent(context: Context): PendingIntent {
        val intent = Intent(context, ClsEndBroadcastReciever::class.java)
        return PendingIntent.getBroadcast(context, 2, intent, PendingIntent.FLAG_ONE_SHOT)
    }
}