package com.example.sarahn.waterreminderapp.classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.sarahn.waterreminderapp.ActViewPager;
import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;

/**
 * Created by SarahN on 6/4/2017.
 */
public class ClsSplashRunnable implements Runnable {

    Context context;
    SharedPrefUtils sharedPrefUtils;

    public ClsSplashRunnable(Context context) {

        this.context = context;

    }

    @Override
    public void run() {

        Intent intent = new Intent(context, ActViewPager.class);
//        if(sharedPrefUtils.getPreference() == true){
//            intent.setClass(context, ActViewPager.class);
//        }else{
//            intent.setClass(context, ActCalculate.class);
//        }
        context.startActivity(intent);
        if(context instanceof Activity)
            //activity enter of second activity and ending animation of current activity
        ((Activity) context).overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
    }


}
