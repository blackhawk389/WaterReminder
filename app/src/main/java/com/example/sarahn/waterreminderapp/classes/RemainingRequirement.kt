package com.example.sarahn.waterreminderapp.classes

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.sarahn.waterreminderapp.Utils.Logging
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.classes.MyApplication

/**
 * Created by SarahN on 6/24/2017.
 */
object RemainingRequirement {
    //required - consumed
    private var consumed = 0
    private var required = 0f
    fun difference(context: Context?) {
        consumed = SharedPrefUtils.getConsumed(MyApplication.context)
        required = SharedPrefUtils.getRequired(MyApplication.context).toFloat()
        if (consumed.toFloat() != required) {
            Logging.logMessage("is equal requirment " + (consumed.toFloat() != required))
            consumed = consumed + 250
            SharedPrefUtils.setConsumed(MyApplication.context, consumed)
            SharedPrefUtils.setRemained(MyApplication.context, Math.round(required) - consumed)
            Logging.logMessage("consumed " + consumed)
            Logging.logMessage("required  " + required)
            val handler = Handler(Looper.getMainLooper())
            handler.post {
                Toast.makeText(context, "Total requirement " + SharedPrefUtils.getRequired(MyApplication.context) / 250 +
                        " consumed " + SharedPrefUtils.getConsumed(MyApplication.context) / 250 +
                        " remained glasses " + SharedPrefUtils.getRemained(MyApplication.context) / 250, Toast.LENGTH_SHORT).show()
            }
        } else {
            return
        }


        // required = SharedPrefUtils.getRequired(MyApplication.getContext());
        //return  required - consumed;
    } //   // public static int remainGlassOfWater(){
    //        return (required - consumed)/250;
    //    }
    //    public static int consumedGlassOfWater(){
    //        return consumed / 250;
    //    }
}