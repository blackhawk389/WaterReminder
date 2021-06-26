package com.example.sarahn.waterreminderapp.dialogs

import android.app.AlertDialog
import android.content.Context

/**
 * Created by SarahN on 6/30/2017.
 */
object BackpressedDialog {
    @JvmStatic
    fun showDialog(context: Context?): AlertDialog.Builder {
        //                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        sweetAlertDialog.cancel();
//                        ((Activity)context).moveTaskToBack(true);
//
//                    }
//                });
        return AlertDialog.Builder(context)
                .setTitle("Exit Application?")
                .setMessage("Process is incomplete") //.setCancelText("Exit")
                .setPositiveButton("Ok") { dialog, which -> dialog.dismiss() }
    }
}