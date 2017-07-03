package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.Logging;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by SarahN on 6/13/2017.
 */
public class ClsRequirementCalculator {

    private static String activity;
    private static String climate;
    public static int calculated;

    public static void calculateRequirement(Context context){

        int climateCal = 0;
        int activityCal = 0;
        float weight = SharedPrefUtils.getWeight(context);
        activity = SharedPrefUtils.getActivityLevel(context);
        climate = SharedPrefUtils.getClimate(context);

        weight = weight /0.024f;

        try {
           climateCal =  ClimateCal();
           activityCal = ActivityLevelCal();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("Exception ", " ----" + e);
           // Toast.makeText(context, "please enter right information" + e, Toast.LENGTH_SHORT).show();
        }


        calculated = waterInmili(weight, climateCal, activityCal);
        SharedPrefUtils.setRequired(MyApplication.getContext(), calculated);
        //return mlToLiter(weight, climateCal, activityCal);

    }

    private static int ActivityLevelCal() throws Exception{

        int activityCal = 0;

        switch (activity){

            case "Basic Daily Movement With No Excercise":
                activityCal = 0;
                break;
            case "Daily Routein With Minimal Excercise Of 0-20 Minutes":
                activityCal = 250;
                break;
            case "Increased Activity With Excercise of 30-60 Minutes":
                activityCal = 500;
                break;
            case "Strenous Aerobic Or WeightLifting of 60 Minutes":
                activityCal = 1000;
                break;
            default:
                Logging.logMessage("Activity  " + activity);
                throw new Exception("No activity level matched");
        }

        return activityCal;

    }

    private static int ClimateCal() throws Exception{

        int climateCal = 0;

        switch (climate){
            case "Hot":
                climateCal = 750;
                break;
            case "Cold":
                climateCal = 250;
                break;
            case "Moderate":
                climateCal = 500;
                break;
            default:
                throw new Exception("No climate case is match");
        }

        return climateCal;

    }


    private final static double mlToLiter(float weight, int activityCal, int climateCal){

        float d = (weight + activityCal + climateCal)/1000;
        DecimalFormat newFormat = new DecimalFormat("#.##");
        double twoDecimal =  Double.valueOf(newFormat.format(d));

        return twoDecimal;
    }

    public final static int mlToGlass(){
        return calculated/250;
    }

    public final static int waterInmili(float weight, int activityLevel, int climate){
        return (int) weight + activityLevel + climate;
    }
}
