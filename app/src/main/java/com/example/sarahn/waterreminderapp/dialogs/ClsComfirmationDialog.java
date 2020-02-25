package com.example.sarahn.waterreminderapp.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.sarahn.waterreminderapp.Utils.AlarmManagerUtils;
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.activities.MainScreen;
import com.example.sarahn.waterreminderapp.dialogs.ClsTimePickerDialogBuilder;


/**
 * Created by SarahN on 6/19/2017.
 */
public class ClsComfirmationDialog {

    public static AlertDialog.Builder displayDialog(final Context context){

        AlertDialog.Builder dialog =  new AlertDialog.Builder (context)
                .setTitle("Selected Time Span")
                .setMessage("From " + ClsTimePickerDialogBuilder.fromHour +
                        ":" + ClsTimePickerDialogBuilder.fromMin + " To " + ClsTimePickerDialogBuilder.toHour +
                        ":" + ClsTimePickerDialogBuilder.toMin)

                .setNegativeButton("Set Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
               .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                       new AlertDialog.Builder(context)
                               .setTitle("Selected Time Span")
                               .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {
                                       dialog.dismiss();
                                       AlarmManagerUtils.setStartAlarm();
                                       AlarmManagerUtils.setEndAlarm();
                                       Intent intent = new Intent();
                                       intent.setClass(context, MainScreen.class);
                                       context.startActivity(intent);
                                   }
                               })
                               .setMessage("You can always change settings anytime from setting tab! you will get notification every " + SharedPrefUtils.getDuration(context) + " minutes")
                               .show();
                   }
               })
                .setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ClsTimePickerDialogBuilder.showDialog(context).show(((Activity) context).getFragmentManager(), "timepicker");
                        dialog.cancel();
                    }
                });

        return dialog;
    }

    public static AlertDialog.Builder displayWarningDialog(final Context context){

        AlertDialog.Builder dialog =  new  AlertDialog.Builder (context)
                .setTitle("Re Select")
                .setMessage("start time should be not be less than end time")
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        displayDialog(context).show();
                    }
                });


        return dialog;

    }

    public static AlertDialog.Builder displayWarningDuration(final Context context){

        final AlertDialog.Builder dialog =  new AlertDialog.Builder (context)
                .setTitle("Unrealistic duration")
                .setMessage("The duration should be atleast of 8 hours")
                .setPositiveButton("set again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ClsTimePickerDialogBuilder.showDialog(context).show(((Activity) context).getFragmentManager(), "timepicker");

                    }
                })
                .setNegativeButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        return dialog;
    }
}
