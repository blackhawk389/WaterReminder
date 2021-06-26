package com.example.sarahn.waterreminderapp.classes

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.sarahn.waterreminderapp.ActViewPager
import com.example.sarahn.waterreminderapp.R
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.activities.MainScreen

/**
 * Created by SarahN on 6/4/2017.
 */
class ClsSplashRunnable(var context: Context) : Runnable {
    var sharedPrefUtils: SharedPrefUtils? = null
    var intent: Intent? = null
    override fun run() {
        isFirstLaunch
        context.startActivity(intent)
        if (context is Activity) //activity enter of second activity and ending animation of current activity
            (context as Activity).overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out)
    }

    private val isFirstLaunch: Unit
        private get() {
            intent = Intent()
            if (SharedPrefUtils.getIsTrue(context)) {
                intent!!.setClass(context, ActViewPager::class.java)
            } else {
                intent!!.setClass(context, MainScreen::class.java)
            }
        }
}