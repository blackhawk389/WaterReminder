package com.example.sarahn.waterreminderapp.classes

import android.app.Application
import android.content.Context

/**
 * Created by SarahN on 6/28/2017.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        //getting things on main thread and application context managment of code
        var context: Context? = null
            private set
    }
}