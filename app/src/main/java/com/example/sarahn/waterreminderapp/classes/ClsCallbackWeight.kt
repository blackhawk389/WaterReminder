package com.example.sarahn.waterreminderapp.classes

import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener

/**
 * Created by SarahN on 6/13/2017.
 */
class ClsCallbackWeight : OnValueChangeListener {
    override fun onValueChange(picker: NumberPicker, oldVal: Int, newVal: Int) {
        if (ClsBottomSheetWeight.values?.size == 0) {
            return
        } else {
            ClsBottomSheetWeight.tv!!.text = ClsBottomSheetWeight.values?.get(newVal - 1) ?: ""
        }
    }
}