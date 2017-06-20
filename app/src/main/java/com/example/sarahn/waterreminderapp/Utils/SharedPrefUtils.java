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



//    public SharedPrefUtils(Context context) {
//        this.context = context;
//        sharedPreferences = this.context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0);
//        editor = sharedPreferences.edit();
//    }

    synchronized public static void setIsTrue(Boolean istrue, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_IS_TRUE, istrue);
        editor.apply();

    }

    public static Boolean getPreference(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(KEY_IS_TRUE, true);
    }

    synchronized public static void setUserData(Context context, int weight, int activity, int climate){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_WEIGHT,weight);
        editor.putInt(KEY_ACTIVITY_LEVEL, activity);
        editor.putInt(KEY_CLIMATE, climate);
        editor.apply();
    }
    synchronized public static void setWeight(Context context, int weight){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_WEIGHT,weight);
        editor.apply();
        Toast.makeText(context, " " + getWeight(context) , Toast.LENGTH_SHORT).show();
    }

    public static int getWeight(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_WEIGHT, DEFAULT_VALUE);
    }

    public static int getActivityLevel(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_ACTIVITY_LEVEL, DEFAULT_VALUE);
    }

    public static int getClimate(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(KEY_CLIMATE, DEFAULT_VALUE);
    }

    synchronized public static void setActivityLevel(Context context,int activity){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_ACTIVITY_LEVEL, activity);
        editor.apply();
        Toast.makeText(context, " " + getActivityLevel(context) , Toast.LENGTH_SHORT).show();
    }

    synchronized public static void setClimate(Context context, int climate){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_CLIMATE, climate);
        editor.apply();
        Toast.makeText(context, " " + getClimate(context) , Toast.LENGTH_SHORT).show();
    }


    public static int[] getUserData(Context context){
        // how to make lines of code follow synchronization, step by step execution
        SharedPreferences prefs =  PreferenceManager.getDefaultSharedPreferences(context);
        int weight = prefs.getInt(KEY_WEIGHT, DEFAULT_VALUE);
        int activity = prefs.getInt(KEY_ACTIVITY_LEVEL, DEFAULT_VALUE);
        int climate = prefs.getInt(KEY_CLIMATE, DEFAULT_VALUE);
        userData = new int[]{weight, activity, climate};

        return userData;
    }
}
