package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;
import android.widget.NumberPicker;

/**
 * Created by SarahN on 6/13/2017.
 */
public class ClsOnValueChangeListmer implements NumberPicker.OnValueChangeListener {


    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        ClsBottomSheetActivity.tv.setText(ClsBottomSheetActivity.values[newVal-1]);
    }
}
