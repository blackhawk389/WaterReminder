package com.example.sarahn.waterreminderapp.classes

import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener

/**
 * Created by SarahN on 6/13/2017.
 */
class ClsOnValueChangeListmer : OnValueChangeListener {
    override fun onValueChange(picker: NumberPicker, oldVal: Int, newVal: Int) {
        if (ClsBottomSheetActivity.values?.size == 0) {
            return
        } else {
            ClsBottomSheetActivity.tv!!.text = ClsBottomSheetActivity.values?.get(newVal - 1) ?: ""
        }
    }
}