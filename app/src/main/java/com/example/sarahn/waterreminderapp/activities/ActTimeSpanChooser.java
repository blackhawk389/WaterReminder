package com.example.sarahn.waterreminderapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.ClsRequirementCalculator;
import com.example.sarahn.waterreminderapp.classes.ClsTimePickerDialogBuilder;

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
        tvNotification.setText("Your  Water  Requirement  Is " + ClsRequirementCalculator.calculateRequirement(this)
        + "  equvalent  to  " + ClsRequirementCalculator.mlToGlass() + "  glasses");
    }

    @Override
    public void onClick(View v) {
        ClsTimePickerDialogBuilder.showDialog(this).show(getFragmentManager(), "timepicker");
    }
}
