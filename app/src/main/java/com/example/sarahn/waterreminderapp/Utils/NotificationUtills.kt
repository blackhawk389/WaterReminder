package com.example.sarahn.waterreminderapp.Utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import com.example.sarahn.waterreminderapp.R
import com.example.sarahn.waterreminderapp.Utils.Logging.logMessage
import com.example.sarahn.waterreminderapp.activities.MainScreen
import com.example.sarahn.waterreminderapp.classes.ConsumedService
import com.example.sarahn.waterreminderapp.classes.MyApplication
import com.example.sarahn.waterreminderapp.dialogs.ClsTimePickerDialogBuilder

/**
 * Created by SarahN on 6/18/2017.
 */
object NotificationUtills {
    const val ACTION_INCREMENT_WATER = "increment_water"
    const val ACTION_CANCEL = "cancel"
    fun notificationBuilder(context: Context) {
        val builder = NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent(context)).setContentTitle("Notification")
                .setContentText("Drink Water").setSmallIcon(R.drawable.notification)
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                .setLights(-0xffff01, 2000, 1000)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM))
                .addAction(incrementWaterCount(context))
                .addAction(cancelNotification(context)) // .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bells))
                .setAutoCancel(true)
        val nManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.notify(1, builder.build())
    }

    private fun pendingIntent(context: Context): PendingIntent {
        val intent = Intent(context, MainScreen::class.java)
        //wrap intent into pending intent
        return PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    private fun incrementWaterCount(context: Context): NotificationCompat.Action {
        val intent = Intent(context, ConsumedService::class.java)
        intent.action = ACTION_INCREMENT_WATER
        val pendingIntent = PendingIntent.getService(context, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT)
        return NotificationCompat.Action(R.drawable.done, "I did it!", pendingIntent)
    }

    private fun cancelNotification(context: Context): NotificationCompat.Action {
        val intent = Intent(context, ConsumedService::class.java)
        intent.action = ACTION_CANCEL
        val pendingIntent = PendingIntent.getService(context, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT)
        return NotificationCompat.Action(R.drawable.clear, "Cancel", pendingIntent)
    }

    fun cancelAll(context: Context) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancelAll()
    }

    fun NotificationCounter() {
        val i: Int
        val diff = ClsTimePickerDialogBuilder.timeDifference
        logMessage("difference $diff")
        logMessage("waterGlass" + SharedPrefUtils.getRequired(MyApplication.context))
        val waterGlass = SharedPrefUtils.getRequired(MyApplication.context) / 250
        //        if(SharedPrefUtils.getEndHour(MyApplication.getContext()) -
//                SharedPrefUtils.getStartHour(MyApplication.getContext()) == 0){
//            i = (Math.abs(diff)) / waterGlass;
//        }else {
//            i = (Math.abs(diff)) * 60 / waterGlass;
//        }
        i = Math.abs(diff) / waterGlass
        logMessage("duration $i")
        SharedPrefUtils.setDuration(MyApplication.context, i)

        // return i / 60;
    }
}