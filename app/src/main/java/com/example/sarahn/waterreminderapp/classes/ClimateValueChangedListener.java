package com.example.sarahn.waterreminderapp.classes;

import android.widget.NumberPicker;

/**
 * Created by SarahN on 6/16/2017.
 */
public class ClimateValueChangedListener implements NumberPicker.OnValueChangeListener {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        if(ClimateBottomSheet.values.length == 0){
            return;
        }else{
            ClimateBottomSheet.tv.setText(ClimateBottomSheet.values[newVal-1]);
        }

    }
}
