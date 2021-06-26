package com.example.sarahn.waterreminderapp.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import com.example.sarahn.waterreminderapp.Utils.AlarmManagerUtils
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.activities.MainScreen

/**
 * Created by SarahN on 6/19/2017.
 */
object ClsComfirmationDialog {
    @JvmStatic
    fun displayDialog(context: Context): AlertDialog.Builder {
        return AlertDialog.Builder(context)
                .setTitle("Selected Time Span")
                .setMessage("From " + ClsTimePickerDialogBuilder.fromHour +
                        ":" + ClsTimePickerDialogBuilder.fromMin + " To " + ClsTimePickerDialogBuilder.toHour +
                        ":" + ClsTimePickerDialogBuilder.toMin)
                .setNegativeButton("Set Again") { dialog, which -> }
                .setPositiveButton("Confirm") { dialog, which ->
                    dialog.dismiss()
                    AlertDialog.Builder(context)
                            .setTitle("Selected Time Span")
                            .setPositiveButton("Ok") { dialog, which ->
                                dialog.dismiss()
                                AlarmManagerUtils.setStartAlarm()
                                AlarmManagerUtils.setEndAlarm()
                                val intent = Intent()
                                intent.setClass(context, MainScreen::class.java)
                                context.startActivity(intent)
                            }
                            .setMessage("You can always change settings anytime from setting tab! you will get notification every " + SharedPrefUtils.getDuration(context) + " minutes")
                            .show()
                }
                .setNegativeButton("Try Again") { dialog, which ->
                    ClsTimePickerDialogBuilder.showDialog(context).show((context as Activity).fragmentManager, "timepicker")
                    dialog.cancel()
                }
    }

    fun displayWarningDialog(context: Context): AlertDialog.Builder {
        return AlertDialog.Builder(context)
                .setTitle("Re Select")
                .setMessage("start time should be not be less than end time")
                .setPositiveButton("Okay") { dialog, which -> displayDialog(context).show() }
    }

    @JvmStatic
    fun displayWarningDuration(context: Context): AlertDialog.Builder {
        return AlertDialog.Builder(context)
                .setTitle("Unrealistic duration")
                .setMessage("The duration should be atleast of 8 hours")
                .setPositiveButton("set again") { dialog, which -> ClsTimePickerDialogBuilder.showDialog(context).show((context as Activity).fragmentManager, "timepicker") }
                .setNegativeButton("") { dialog, which -> dialog.dismiss() }
    }
}