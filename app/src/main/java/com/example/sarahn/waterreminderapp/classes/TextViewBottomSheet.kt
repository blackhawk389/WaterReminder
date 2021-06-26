package com.example.sarahn.waterreminderapp.classes

import android.content.Context
import com.example.sarahn.waterreminderapp.ActCalculate
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils

/**
 * Created by SarahN on 7/1/2017.
 */
object TextViewBottomSheet {
    fun setText(context: Context?) {
        val weight = SharedPrefUtils.getWeight(context)
        ActCalculate.tvOne?.text = Integer.toString(weight)
    }
}