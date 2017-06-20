package com.example.sarahn.waterreminderapp.Utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.activities.ActMainScreen;

/**
 * Created by SarahN on 6/18/2017.
 */
public class NotificationUtills {

    public static void notificationBuilder(Context context){


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent(context)).setContentTitle("Notification")
                .setContentText("Im notification").setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                .setLights(0xFF0000FF, 4000, 1000)

                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM))

               // .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bells))
                .setAutoCancel(true);

        NotificationManager nManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.notify(001, builder.build());
    }

    private static PendingIntent pendingIntent(Context context){
        Intent intent = new Intent(context, ActMainScreen.class);
        //wrap intent into pending intent
        return PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

}
