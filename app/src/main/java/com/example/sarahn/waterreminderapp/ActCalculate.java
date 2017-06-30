package com.example.sarahn.waterreminderapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.activities.ActNotification;
import com.example.sarahn.waterreminderapp.classes.BackpressedDialog;
import com.example.sarahn.waterreminderapp.classes.ClimateBottomSheet;
import com.example.sarahn.waterreminderapp.classes.ClsBottomSheetWeight;
import com.example.sarahn.waterreminderapp.classes.ClsBottomSheetActivity;
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator;


public class ActCalculate extends Activity implements View.OnClickListener{

    public static TextView tvOne;
    public static TextView tvTwo;
    public static TextView tvThree;
    Button btnClaculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main);

        tvOne = (TextView) findViewById(R.id.tv_one);
        tvTwo = (TextView) findViewById(R.id.tv_two);
        tvThree = (TextView) findViewById(R.id.tv_three);
        btnClaculate = (Button) findViewById(R.id.btn_calculate);

        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThree.setOnClickListener(this);
        btnClaculate.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        BackpressedDialog.showDialog(this).show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_one:
                ClsBottomSheetWeight bottomSheet = new ClsBottomSheetWeight(ActCalculate.this);
                bottomSheet.showDialog().show();
                //make the bellow line of code only works when it return from bottomsheet
               // tvOne.setText(Integer.toString(SharedPrefUtils.getWeight(this)));
                break;

            case R.id.tv_two:
                ClsBottomSheetActivity activityBottomSheet = new ClsBottomSheetActivity(ActCalculate.this);
                activityBottomSheet.showDialog().show();
                break;

            case R.id.tv_three:
                ClimateBottomSheet bottomSheetClimate = new ClimateBottomSheet(this);
                bottomSheetClimate.showDialog().show();
                break;

            case R.id.btn_calculate:
                ClsRequirementCalculator.calculateRequirement(ActCalculate.this);
                Intent intent = new Intent(ActCalculate.this, ActNotification.class);
                startActivity(intent);
                break;
        }

    }
}
