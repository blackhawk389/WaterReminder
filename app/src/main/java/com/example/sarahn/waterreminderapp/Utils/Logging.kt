package com.example.sarahn.waterreminderapp.Utils

import android.util.Log

/**
 * Created by SarahN on 6/30/2017.
 */
object Logging {
    @JvmStatic
    fun logMessage(name: String?) {
        Log.i("MainActivity", name!!)
    }
}