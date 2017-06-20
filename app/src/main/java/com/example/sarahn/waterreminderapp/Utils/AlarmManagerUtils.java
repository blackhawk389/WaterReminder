package com.example.sarahn.waterreminderapp.Utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.classes.ClsBroadCastReciver;
import com.example.sarahn.waterreminderapp.classes.ClsEndBroadcastReciever;
import com.example.sarahn.waterreminderapp.classes.ClsTimePickerDialogBuilder;

import java.util.Calendar;

/**
 * Created by SarahN on 6/19/2017.
 */
public class AlarmManagerUtils {


    public static void setStartAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(System.currentTimeMillis());
        time.set(Calendar.HOUR_OF_DAY, ClsTimePickerDialogBuilder.fromHour);
        time.set(Calendar.MINUTE, ClsTimePickerDialogBuilder.fromMin);
        time.set(Calendar.SECOND, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingIntent(context));
        Toast.makeText(context, "setstartAlarm" + ClsTimePickerDialogBuilder.fromHour
                +  ClsTimePickerDialogBuilder.fromMin, Toast.LENGTH_SHORT).show();
    }

    private static PendingIntent pendingIntent(Context context){
        Intent intent = new Intent(context, ClsBroadCastReciver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 01, intent, PendingIntent.FLAG_ONE_SHOT);
        return pendingIntent;
    }


    public static void setEndAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(System.currentTimeMillis());
        time.set(Calendar.HOUR_OF_DAY, ClsTimePickerDialogBuilder.toHour);
        time.set(Calendar.MINUTE, ClsTimePickerDialogBuilder.toMin);
        time.set(Calendar.SECOND, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), endPendingIntent(context));
        Toast.makeText(context, "set end alarm"
                + ClsTimePickerDialogBuilder.toHour
                +  ClsTimePickerDialogBuilder.toMin
                , Toast.LENGTH_SHORT).show();
    }

    private static PendingIntent endPendingIntent(Context context){
        Intent intent = new Intent(context, ClsEndBroadcastReciever.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 02, intent, PendingIntent.FLAG_ONE_SHOT);
        return pendingIntent;
    }
}
