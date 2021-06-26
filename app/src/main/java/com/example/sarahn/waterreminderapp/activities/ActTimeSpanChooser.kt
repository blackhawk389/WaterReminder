package com.example.sarahn.waterreminderapp.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.sarahn.waterreminderapp.R
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator
import com.example.sarahn.waterreminderapp.classes.MyApplication
import com.example.sarahn.waterreminderapp.dialogs.ClsTimePickerDialogBuilder

class ActTimeSpanChooser : Activity(), View.OnClickListener {
    var tvNotification: TextView? = null
    var btnSpan: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_notification)
        btnSpan = findViewById<View>(R.id.btn_span) as Button
        btnSpan!!.setOnClickListener(this)
        tvNotification = findViewById<View>(R.id.tv_not) as TextView
        tvNotification!!.text = ("Your  Water  Requirement  Is  " + ClsRequirementCalculator.mlToLit
                + "  Liters  equvalent  to  " + SharedPrefUtils.getRequired(MyApplication.context) / 250 + "  glasses")
    }

    override fun onClick(v: View) {
        ClsTimePickerDialogBuilder.showDialog(this).show(fragmentManager, "timepicker")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // BackpressedDialog.showDialog(this).show();
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}