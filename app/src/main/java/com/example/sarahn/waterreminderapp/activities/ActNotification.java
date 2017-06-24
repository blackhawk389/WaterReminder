package com.example.sarahn.waterreminderapp.activities;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;
import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator;
import com.example.sarahn.waterreminderapp.classes.ClsTimePickerDialogBuilder;

import java.util.Calendar;

public class ActNotification extends Activity implements View.OnClickListener{

    TextView tvNotification;
    Button btnSpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_notification);

        btnSpan = (Button) findViewById(R.id.btn_span);
        btnSpan.setOnClickListener(this);

        tvNotification = (TextView) findViewById(R.id.tv_not);
        tvNotification.setText("Your Water Requirement Is " + ClsRequirementCalculator.calculateRequirement(this)
        + "and glass" + ClsRequirementCalculator.mlToGlass());
    }

    @Override
    public void onClick(View v) {
        ClsTimePickerDialogBuilder.showDialog(this).show(getFragmentManager(), "timepicker");
    }
}
