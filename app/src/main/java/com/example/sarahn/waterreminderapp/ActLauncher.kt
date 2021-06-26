package com.example.sarahn.waterreminderapp

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import com.example.sarahn.waterreminderapp.classes.ClsSplashRunnable

class ActLauncher : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_launcher)

        //splash screen
        Handler().postDelayed(ClsSplashRunnable(this), 4000)
    }
}