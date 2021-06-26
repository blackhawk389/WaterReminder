package com.example.sarahn.waterreminderapp.Utils

import android.widget.Toast
import com.example.sarahn.waterreminderapp.classes.MyApplication

/**
 * Created by SarahN on 7/1/2017.
 */
object ToastLogger {
    @JvmStatic
    fun toastMessage(name: String?) {
        Toast.makeText(MyApplication.context, name, Toast.LENGTH_SHORT).show()
    }
}