package com.example.sarahn.waterreminderapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator;
import com.example.sarahn.waterreminderapp.classes.MyApplication;
import com.example.sarahn.waterreminderapp.dialogs.BackpressedDialog;
import com.example.sarahn.waterreminderapp.dialogs.ClsTimePickerDialogBuilder;

public class ActTimeSpanChooser extends Activity implements View.OnClickListener{

    TextView tvNotification;
    Button btnSpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_notification);

        btnSpan = (Button) findViewById(R.id.btn_span);
        btnSpan.setOnClickListener(this);

        tvNotification = (TextView) findViewById(R.id.tv_not);
        tvNotification.setText("Your  Water  Requirement  Is  " + SharedPrefUtils.getRequired(MyApplication.getContext())/1000
        + "  Liters  equvalent  to  " + SharedPrefUtils.getRequired(MyApplication.getContext())/250 + "  glasses");
    }

    @Override
    public void onClick(View v) {
        ClsTimePickerDialogBuilder.showDialog(this).show(getFragmentManager(), "timepicker");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       // BackpressedDialog.showDialog(this).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
