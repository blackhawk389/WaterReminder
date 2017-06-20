package com.example.sarahn.waterreminderapp.classes;

import android.widget.NumberPicker;

/**
 * Created by SarahN on 6/13/2017.
 */
public class ClsCallbackWeight implements NumberPicker.OnValueChangeListener {

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        ClsBottomSheetWeight.tv.setText(ClsBottomSheetWeight.values[newVal-1]);
    }
}
