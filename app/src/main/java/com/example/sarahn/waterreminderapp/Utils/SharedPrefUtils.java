package com.example.sarahn.waterreminderapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by SarahN on 6/6/2017.
 */
public class SharedPrefUtils {

    private final static String KEY_IS_TRUE = "is_launch_first_time";
    private final static String KEY_WEIGHT = "weight";
    private final static String KEY_ACTIVITY_LEVEL = "activity_level";
    private final static String KEY_CLIMATE = "climate";
    private static int[] userData;
    private final static int DEFAULT_VALUE = 0;
    private final static String DEFUALT_STRING_VALUE = null;
    private final static String KEY_CONSUMED = "consumed";
    private final static String KEY_REMAINED = "remained";
    private final static String KEY_REQUIRED = "required";

    private final static String KEY_START_HOUR = "start_hour";
    private final static String KEY_END_HOUR = "end_hour";
    private final static String KEY_START_MIN = "start_min";
    private final static String KEY_END_MIN = "end_min";

    private final static String KEY_ISBOOT = "is_boot";

    private final static String KEY_DURATION = "duration";


//    public SharedPrefUtils(Context context) {
//        this.context = context;
//        sharedPreferences = this.context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0);
//        editor = sharedPreferences.edit();
//    }

    synchronized public static void setIsTrue(Boolean istrue, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_IS_TRUE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_IS_TRUE, istrue);
        editor.apply();
    }

    public static Boolean getIsTrue(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(KEY_IS_TRUE, true);
    }

//    synchronized public static void setUserData(Context context, int weight, int activity, int climate){
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putInt(KEY_WEIGHT,weight);
//        editor.putInt(KEY_ACTIVITY_LEVEL, activity);
//        editor.putInt(KEY_CLIMATE, climate);
//        editor.apply();
//    }
    synchronized public static void setWeight(Context context, int weight){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_WEIGHT);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_WEIGHT, weight);
        editor.apply();
    }

    public static int getWeight(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_WEIGHT, DEFAULT_VALUE);
    }

    public static String getActivityLevel(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(KEY_ACTIVITY_LEVEL, DEFUALT_STRING_VALUE);
    }

    public static String getClimate(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(KEY_CLIMATE, DEFUALT_STRING_VALUE);
    }

    synchronized public static void setActivityLevel(Context context,String activity){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_ACTIVITY_LEVEL);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_ACTIVITY_LEVEL, activity);
        editor.apply();

    }

    synchronized public static void setClimate(Context context, String climate){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_CLIMATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_CLIMATE, climate);
        editor.apply();

    }

    synchronized public static void setConsumed(Context context, int consume){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_CONSUMED);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_CONSUMED, consume);
        editor.apply();
    }

    public static int getConsumed(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_CONSUMED, DEFAULT_VALUE);
    }

    synchronized public static void setRemained(Context context, int consume){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            prefs.edit().remove(KEY_REMAINED);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_REMAINED, consume);
        editor.apply();
    }

    public static int getRemained(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_REMAINED, DEFAULT_VALUE);
    }

    synchronized public static void setRequired(Context context, int consume){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_REQUIRED);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_REQUIRED, consume);
        editor.apply();
    }

    synchronized public static void setDuration(Context context, int duration){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_DURATION);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_DURATION, duration);
        editor.apply();
    }

    public static int getDuration(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_DURATION, DEFAULT_VALUE);
    }

    public static void removeConsumed(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        //changing from commit to apply
        prefs.edit().remove(KEY_CONSUMED).apply();
        prefs.edit().remove(KEY_REMAINED).apply();
        Logging.logMessage("removed consumed ");
        Logging.logMessage("clear---" + getConsumed(context));
        Logging.logMessage("clear remained ---" + getRemained(context));
    }

    public static boolean getIsBoot(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(KEY_ISBOOT, false);
    }

    synchronized public static void setIsBoot(Context context, boolean boot){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_ISBOOT);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_ISBOOT, boot);
        editor.apply();
    }

    public static int getRequired(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_REQUIRED, DEFAULT_VALUE);
    }

    synchronized public static void setStartHour(Context context, int consume){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_START_HOUR);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_START_HOUR, consume);
        editor.apply();
    }

    public static int getStartHour(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_START_HOUR, DEFAULT_VALUE);
    }
    synchronized public static void setEndHour(Context context, int consume){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_END_HOUR);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_END_HOUR, consume);
        editor.apply();
    }

    public static int getEndHour(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_END_HOUR, DEFAULT_VALUE);
    }
    synchronized public static void setStartMin(Context context, int consume){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_START_MIN);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_START_MIN, consume);
        editor.apply();
    }

    public static int getStartMin(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_START_MIN, DEFAULT_VALUE);
    }
    synchronized public static void setEndMin(Context context, int consume){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(KEY_END_MIN);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_END_MIN, consume);
        editor.apply();
    }

    public static int getEndMin(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_END_MIN, DEFAULT_VALUE);
    }





//    synchronized public static void setRequired(Context context, int climate){
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
//        prefs.edit().remove(KEY_CLIMATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putString(, climate);
//        editor.apply();
//
//    }
//
//    public static int getRequired(){
//
//    }

//    public static int[] getUserData(Context context){
//        // how to make lines of code follow synchronization, step by step execution
//        SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(context);
//        int weight = prefs.getInt(KEY_WEIGHT, DEFAULT_VALUE);
//        int activity = prefs.getInt(KEY_ACTIVITY_LEVEL, DEFAULT_VALUE);
//        int climate = prefs.getInt(KEY_CLIMATE, DEFAULT_VALUE);
//        userData = new int[]{weight, activity, climate};
//
//        return userData;
//    }
}
