package com.example.sarahn.waterreminderapp.classes

import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener

/**
 * Created by SarahN on 6/16/2017.
 */
class ClimateValueChangedListener : OnValueChangeListener {
    override fun onValueChange(picker: NumberPicker, oldVal: Int, newVal: Int) {
        if (ClimateBottomSheet.values?.size == 0) {
            return
        } else {
            ClimateBottomSheet.tv!!.text = ClimateBottomSheet.values?.get(newVal - 1) ?: ""
        }
    }
}