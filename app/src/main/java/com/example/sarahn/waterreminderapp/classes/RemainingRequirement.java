package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.Utils.Logging;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator;

/**
 * Created by SarahN on 6/24/2017.
 */
public class RemainingRequirement {

    //required - consumed
    private static int consumed;
    private static float required;

    public static void difference(final Context context){

        consumed = SharedPrefUtils.getConsumed(MyApplication.getContext());
        required = SharedPrefUtils.getRequired(MyApplication.getContext());


        if(consumed != required){

            Logging.logMessage("is equal requirment " + (consumed != required));
            consumed = consumed + 250;
            SharedPrefUtils.setConsumed(MyApplication.getContext(), consumed);
            SharedPrefUtils.setRemained(MyApplication.getContext(), Math.round(required) - consumed);

            Logging.logMessage("consumed " + consumed);
            Logging.logMessage("required  "+required);

            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                public void run() {
                    Toast.makeText(context, "Total requirement " + (SharedPrefUtils.getRequired(MyApplication.getContext())) / 250
                            +
                            " consumed " + (SharedPrefUtils.getConsumed(MyApplication.getContext())) / 250 +
                            " remained glasses " + (SharedPrefUtils.getRemained(MyApplication.getContext())) / 250, Toast.LENGTH_SHORT).show();
                }
            });


        }else {
            return;
        }




       // required = SharedPrefUtils.getRequired(MyApplication.getContext());
        //return  required - consumed;
    }

//   // public static int remainGlassOfWater(){
//        return (required - consumed)/250;
//    }

//    public static int consumedGlassOfWater(){
//        return consumed / 250;
//    }

}
