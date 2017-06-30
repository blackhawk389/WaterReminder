package com.example.sarahn.waterreminderapp.classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.sarahn.waterreminderapp.Utils.AlarmManagerUtils;
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills;
import com.example.sarahn.waterreminderapp.activities.MainScreen;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by SarahN on 6/19/2017.
 */
public class ClsComfirmationDialog {




    public static SweetAlertDialog displayDialog(final Context context){

       SweetAlertDialog dialog =  new SweetAlertDialog (context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Selected Time Span")
                .setContentText("From " + ClsTimePickerDialogBuilder.fromHour +
                        ": " + ClsTimePickerDialogBuilder.fromMin + " " + ClsAMOrPM.isAMOrPM(ClsTimePickerDialogBuilder.fromHour) + "To " + ClsTimePickerDialogBuilder.toHour +
                        ": " + ClsTimePickerDialogBuilder.toMin + " " + ClsAMOrPM.isAMOrPM(ClsTimePickerDialogBuilder.fromMin))

                .setCancelText("Set again")
                .setConfirmText("Confirm")
                .showCancelButton(true)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {

                        sweetAlertDialog.cancel();

                        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Selected Time Span")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {

                                        AlarmManagerUtils.setStartAlarm();
                                        AlarmManagerUtils.setEndAlarm();
                                        sweetAlertDialog.cancel();



                                        Intent intent = new Intent();
                                        intent.setClass(context, MainScreen.class);
                                        context.startActivity(intent);
                                    }
                                })
                                .setContentText("You can always change settings anytime from setting tab! duration will be " + NotificationUtills.NotificationCounter() + "min")
                                .show();

                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        ClsTimePickerDialogBuilder.showDialog(context).show(((Activity) context).getFragmentManager(), "timepicker");
                        sDialog.cancel();

                    }
                });
              //  .show();

        return dialog;
    }

    public static SweetAlertDialog displayWarningDialog(final Context context){

        SweetAlertDialog dialog =  new SweetAlertDialog (context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Re Select")
                .setContentText("start time should be not be less than end time")
                .setConfirmText("Okay")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        displayDialog(context).show();
                    }
                });

        return dialog;

    }

    public static SweetAlertDialog displayWarningDuration(final Context context){

        final SweetAlertDialog dialog =  new SweetAlertDialog (context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Unrealistic duration")
                .setContentText("The duration should be atleast of 8 hours")
                .setConfirmText("set again")
                .setCancelText("Okay")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                       ClsTimePickerDialogBuilder.showDialog(context).show(((Activity) context).getFragmentManager(), "timepicker");

                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.cancel();
                    }
                });

        return dialog;

    }
}
