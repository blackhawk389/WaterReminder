package com.example.sarahn.waterreminderapp.classes;

/**
 * Created by SarahN on 6/19/2017.
 */
public class ClsAMOrPM {

    public static String isAMOrPM(int hour){

        String AMOrPM;

        if(hour >= 12 || hour < 24){
            AMOrPM = "PM";
        }else{
            AMOrPM = "AM";
        }

        return AMOrPM;
    }

}
