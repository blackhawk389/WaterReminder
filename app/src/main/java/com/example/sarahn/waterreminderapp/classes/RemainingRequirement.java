package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator;

/**
 * Created by SarahN on 6/24/2017.
 */
public class RemainingRequirement {

    //required - consumed
    public static int consumed;
    public static int required;

    public static int difference(final Context context){

        int waterConsumed = 0;
        waterConsumed = waterConsumed + 250;

        SharedPrefUtils.setConsumed(MyApplication.getContext(), waterConsumed);
        consumed = SharedPrefUtils.getConsumed(MyApplication.getContext());

        required = ClsRequirementCalculator.calculated;

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(context, "Total requirement " + ClsRequirementCalculator.calculated
                        +
                        " consumed " + consumed +
                        " remained glasses " + (required - consumed)/250 , Toast.LENGTH_SHORT).show();
            }
        });

        return  required - consumed;
    }

    public static int remainGlassOfWater(){
        return (required - consumed)/250;
    }

    public static int consumedGlassOfWater(){
        return consumed / 250;
    }

}
