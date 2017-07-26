package com.example.sarahn.waterreminderapp.classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.sarahn.waterreminderapp.ActCalculate;
import com.example.sarahn.waterreminderapp.ActViewPager;
import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.Logging;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.activities.MainScreen;

/**
 * Created by SarahN on 6/4/2017.
 */
public class ClsSplashRunnable implements Runnable {

    Context context;
    SharedPrefUtils sharedPrefUtils;
    Intent intent;

    public ClsSplashRunnable(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        isFirstLaunch();
        context.startActivity(intent);
        if(context instanceof Activity)
            //activity enter of second activity and ending animation of current activity
        ((Activity) context).overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
    }


    private void isFirstLaunch(){
        intent = new Intent();
        if(SharedPrefUtils.getIsTrue(context)){
            intent.setClass(context, ActViewPager.class);

        }else{
            intent.setClass(context, MainScreen.class);
        }
    }
}
