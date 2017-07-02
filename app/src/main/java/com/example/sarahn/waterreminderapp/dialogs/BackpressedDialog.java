package com.example.sarahn.waterreminderapp.dialogs;

import android.app.Activity;
import android.content.Context;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by SarahN on 6/30/2017.
 */
public class BackpressedDialog {

    public static SweetAlertDialog showDialog(final Context context){
        SweetAlertDialog dialog = new SweetAlertDialog (context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Exit Application?")
                .setContentText("Process is incomplete")
                .setCancelText("Exit")
                .setConfirmText("Go back")
                .showCancelButton(true)

                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.cancel();

                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.cancel();
                        ((Activity)context).moveTaskToBack(true);

                    }
                });



        return dialog;
    }
}
