package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by SarahN on 6/18/2017.
 */
public class ClsTimePickerDialogBuilder{

    public static int fromHour;
    public static int fromMin;
    public static int toHour;
    public static int toMin;
    public static int timeDifference;


    public static TimePickerDialog showDialog(final Context context){
        Calendar now = Calendar.getInstance();

        TimePickerDialog tpd;
        return tpd = TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
                                                      @Override
                                                      public void onTimeSet(RadialPickerLayout radialPickerLayout, int i, int i1, int i2, int i3) {
                                                          fromHour = i;
                                                          fromMin = i1;
                                                          toHour = i2;
                                                          toMin = i3;

                                                        ClsComfirmationDialog.displayDialog(context).show();
                                                          timeDifference = (fromMin - toMin) + ( fromHour - toHour);
                                                          timeDifferenceUtil(timeDifference, context);
                                                      }}, now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false);
    }


    private static void timeDifferenceUtil(float td, Context context){
        if(timeDifference > 0){
            ClsComfirmationDialog.displayWarningDialog(context).show();
        }else if(Math.abs(timeDifference) <= 2 ){
            ClsComfirmationDialog.displayWarningDuration(context).show();
        }
    }

}
