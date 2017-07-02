package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;

import com.example.sarahn.waterreminderapp.ActCalculate;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;

/**
 * Created by SarahN on 7/1/2017.
 */
public class TextViewBottomSheet {

    public static void setText(Context context){
        int weight = SharedPrefUtils.getWeight(context);
        ActCalculate.tvOne.setText(Integer.toString(weight));
    }


}
