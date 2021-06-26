package com.example.sarahn.waterreminderapp.dialogs

import android.content.Context
import com.borax12.materialdaterangepicker.time.TimePickerDialog
import com.example.sarahn.waterreminderapp.Utils.Logging
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.classes.MyApplication
import com.example.sarahn.waterreminderapp.dialogs.ClsComfirmationDialog.displayDialog
import com.example.sarahn.waterreminderapp.dialogs.ClsComfirmationDialog.displayWarningDuration
import java.util.*

/**
 * Created by SarahN on 6/18/2017.
 */
object ClsTimePickerDialogBuilder {
    var fromHour = 0
    var fromMin = 0
    var toHour = 0
    var toMin = 0
    @JvmField
    var timeDifference = 0
    @JvmStatic
    fun showDialog(context: Context?): TimePickerDialog {
        val now = Calendar.getInstance()
        val tpd: TimePickerDialog
        tpd = TimePickerDialog.newInstance({ radialPickerLayout, i, i1, i2, i3 ->
            fromHour = i
            fromMin = i1
            toHour = i2
            toMin = i3
            Logging.logMessage("times " + fromHour + toHour + fromMin + toMin)
            SharedPrefUtils.setStartHour(MyApplication.context, i)
            SharedPrefUtils.setEndHour(MyApplication.context, i2)
            SharedPrefUtils.setStartMin(MyApplication.context, i1)
            SharedPrefUtils.setEndMin(MyApplication.context, i3)
            displayDialog(context!!).show()
            val hours = (toHour - fromHour) * 60
            val min = toMin - fromMin
            timeDifference = hours + min
            Logging.logMessage("time difference " + timeDifference)
            NotificationUtills.NotificationCounter()

            //  timeDifference = (toHour - fromHour) - (toMin - fromMin);
            // timeDifferenceUtil(timeDifference, context);
        }, now[Calendar.HOUR_OF_DAY],
                now[Calendar.MINUTE],
                true)
        return tpd
    }

    private fun timeDifferenceUtil(td: Float, context: Context) {
        if (timeDifference > 0) {
            //   ClsComfirmationDialog.displayWarningDialog(context).show();
        } else if (Math.abs(timeDifference) <= 2) {
            displayWarningDuration(context).show()
        }
    }
}