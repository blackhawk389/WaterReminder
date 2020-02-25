package com.example.sarahn.waterreminderapp.dialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;


/**
 * Created by SarahN on 6/30/2017.
 */
public class BackpressedDialog {

    public static AlertDialog.Builder showDialog(final Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder (context)
                .setTitle("Exit Application?")
                .setMessage("Process is incomplete")
                //.setCancelText("Exit")
               .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });
//                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        sweetAlertDialog.cancel();
//                        ((Activity)context).moveTaskToBack(true);
//
//                    }
//                });



        return dialog;
    }
}
