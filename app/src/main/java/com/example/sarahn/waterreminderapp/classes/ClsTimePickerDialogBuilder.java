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
    public static float timeDifference;


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

                                                          Log.i("hour ########## " + fromHour + " " + fromMin, " to "
                                                                  + toHour + " " + toMin);

                                                        ClsComfirmationDialog.displayDialog(context).show();
                                                          timeDifference = (fromMin - toMin) + ( fromHour - toHour);
                                                          if(timeDifference > 0){
                                                              ClsComfirmationDialog.displayWarningDialog(context).show();
                                                          }else if(Math.abs(timeDifference) <= 2 ){
                                                              ClsComfirmationDialog.displayWarningDuration(context).show();
                                                          }
                                                          Log.i("difference ------ ", " " + timeDifference);
                                                      }}, now.get(Calendar.HOUR),
                now.get(Calendar.MINUTE),
                false);
    }





}
