package com.example.sarahn.waterreminderapp.classes;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.ActCalculate;
import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.Utils.ToastLogger;

/**
 * Created by SarahN on 6/13/2017.
 */
public class ClsBottomSheetActivity {

    BottomSheetDialog bottomSheetActivity;
    LayoutInflater inflater;
    public static String[] values;
    NumberPicker numberPickerActivity;
    static TextView tv;
    Context context;

    public ClsBottomSheetActivity(Context context) {

        this.context = context;
        bottomSheetActivity = new BottomSheetDialog(context);
        inflater = LayoutInflater.from(context);

        values =  context.getResources().getStringArray(R.array.activity);
    }

    public BottomSheetDialog showDialog(){
        View sheetView = inflater.inflate(R.layout.bottom_sheet_activity, null);
        numberPickerActivity = (NumberPicker) sheetView.findViewById(R.id.np);
        tv = (TextView) sheetView.findViewById(R.id.tv);
        Button btnSave = (Button) sheetView.findViewById(R.id.btn_save);
        Button btnClose = (Button) sheetView.findViewById(R.id.btn_close);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetActivity.dismiss();
                int activityLevel = numberPickerActivity.getValue()-1;
                SharedPrefUtils.setActivityLevel(context, values[activityLevel]);
                ToastLogger.toastMessage(values[activityLevel]);
                setText(SharedPrefUtils.getActivityLevel(context));
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetActivity.dismiss();
            }
        });

        numberPickerActivity.setMaxValue(4);
        numberPickerActivity.setMinValue(1);

        numberPickerActivity.setDisplayedValues(values);
        numberPickerActivity.setWrapSelectorWheel(false);
        bottomSheetActivity.setContentView(sheetView);


        numberPickerActivity.setOnValueChangedListener(new ClsOnValueChangeListmer());

        return bottomSheetActivity;
    }

    private void setText(String name){
        ActCalculate.tvTwo.setText(name);
    }
}
