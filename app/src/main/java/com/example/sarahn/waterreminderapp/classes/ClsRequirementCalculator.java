package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;

import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;

/**
 * Created by SarahN on 6/13/2017.
 */
public class ClsRequirementCalculator {

    static int activity;
    static int climate;
    public static int calculated;

    public static void calculateRequirement(Context context){
        int weight = SharedPrefUtils.getWeight(context);
        int activity = SharedPrefUtils.getActivityLevel(context);
        int climate = SharedPrefUtils.getClimate(context);

        int act = getActivityLevel();
        calculated = act + (weight/2);
    }

    private static int getActivityLevel(){
        switch (activity){
            case 1:
                activity = 0;
                break;
            case 2:
                activity = 200;
                break;
            case 3:
                activity = 300;
                break;
            case 4:
                activity = 700;
                break;
        }

        return activity;

    }

//    private static int getClimate(){
//
//        switch (climate){
//            case 1:
//                climate = ;
//                break;
//            case 2:
//                climate = ;
//                break;
//            case 3:
//                climate = 300;
//                break;
//
//        }
//
//        return climate;
//    }


}
