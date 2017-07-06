package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.ActCalculate;
import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.Utils.ToastLogger;

/**
 * Created by SarahN on 6/16/2017.
 */
public class ClimateBottomSheet {

    BottomSheetDialog bottomSheetClimate;
    LayoutInflater inflater;
    public static String[] values;
    NumberPicker numberPickerClimate;
    public static TextView tv;
    Context context;

    public ClimateBottomSheet(Context context) {

        this.context = context;
        bottomSheetClimate = new BottomSheetDialog(context);
        inflater = LayoutInflater.from(context);

         values = new String[]{"resource", "resource" ,"resource"};
      //  values =  context.getResources().getStringArray(R.array.climate);


    }

    public BottomSheetDialog showDialog(){
        View sheetView = inflater.inflate(R.layout.bottom_sheet_climate, null);
        numberPickerClimate = (NumberPicker) sheetView.findViewById(R.id.np);
        tv = (TextView) sheetView.findViewById(R.id.tv);
        Button btnSave = (Button) sheetView.findViewById(R.id.btn_save);
        Button btnClose = (Button) sheetView.findViewById(R.id.btn_close);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetClimate.dismiss();
                int climate = numberPickerClimate.getValue()-1;
                SharedPrefUtils.setClimate(context, values[climate]);
                ToastLogger.toastMessage(values[climate]);
                setText(SharedPrefUtils.getClimate(context));
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetClimate.dismiss();
            }
        });

        numberPickerClimate.setMaxValue(3);
        numberPickerClimate.setMinValue(1);

        numberPickerClimate.setDisplayedValues(values);
        numberPickerClimate.setWrapSelectorWheel(false);
        bottomSheetClimate.setContentView(sheetView);


        numberPickerClimate.setOnValueChangedListener(new ClimateValueChangedListener());

        return bottomSheetClimate;
    }

    private void setText(String name){
        ActCalculate.tvThree.setText(name);
    }
}
