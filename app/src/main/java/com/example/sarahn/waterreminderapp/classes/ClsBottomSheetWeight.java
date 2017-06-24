package com.example.sarahn.waterreminderapp.classes;


import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;

/**
 * Created by SarahN on 6/12/2017.
 */
public class ClsBottomSheetWeight {
    public static TextView tv;
    LayoutInflater inflater;
    BottomSheetDialog mBottomSheetDialog;
    public static NumberPicker minutePicker;
    Context context;
    public static String[] values;

    public ClsBottomSheetWeight(Context context) {
        this.context = context;
        mBottomSheetDialog = new BottomSheetDialog(context);
        inflater = LayoutInflater.from(context);
        values = new String[] {"30","35", "40",
                "45", "50", "55", "60",
                "65", "70","75", "80",
                "86", "90","95", "100",
                "105", "110", "120"};
    }

    public BottomSheetDialog showDialog(){
        View sheetView = inflater.inflate(R.layout.bottom_sheet, null);
        minutePicker = (NumberPicker) sheetView.findViewById(R.id.np);
        tv = (TextView) sheetView.findViewById(R.id.tv);
        Button btnSave = (Button) sheetView.findViewById(R.id.btn_save);
        Button btnClose = (Button) sheetView.findViewById(R.id.btn_close);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();
                String weight = values[minutePicker.getValue()-1];
                SharedPrefUtils.setWeight(context, Integer.parseInt(weight));
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();
            }
        });

        minutePicker.setMaxValue(18);
        minutePicker.setMinValue(1);

        minutePicker.setDisplayedValues(values);
        minutePicker.setWrapSelectorWheel(false);

        mBottomSheetDialog.setContentView(sheetView);
        minutePicker.setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        minutePicker.setOnValueChangedListener(new ClsCallbackWeight());

        return mBottomSheetDialog;
    }
}
