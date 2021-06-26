package com.example.sarahn.waterreminderapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.sarahn.waterreminderapp.ActCalculate
import com.example.sarahn.waterreminderapp.Utils.ToastLogger.toastMessage
import com.example.sarahn.waterreminderapp.activities.ActTimeSpanChooser
import com.example.sarahn.waterreminderapp.classes.ClimateBottomSheet
import com.example.sarahn.waterreminderapp.classes.ClsBottomSheetActivity
import com.example.sarahn.waterreminderapp.classes.ClsBottomSheetWeight
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator.calculateRequirement
import com.example.sarahn.waterreminderapp.dialogs.BackpressedDialog.showDialog

class ActCalculate : Activity(), View.OnClickListener {
    var btnClaculate: Button? = null
    var textViewOne: String? = null
    var textViewTwo: String? = null
    var textViewThree: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_main)
        tvOne = findViewById<View>(R.id.tv_one) as TextView
        tvTwo = findViewById<View>(R.id.tv_two) as TextView
        tvThree = findViewById<View>(R.id.tv_three) as TextView
        btnClaculate = findViewById<View>(R.id.btn_calculate) as Button
        tvOne!!.setOnClickListener(this)
        tvTwo!!.setOnClickListener(this)
        tvThree!!.setOnClickListener(this)
        btnClaculate!!.setOnClickListener(this)
    }

    override fun onBackPressed() {
        showDialog(this).show()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_one -> {
                val bottomSheet = ClsBottomSheetWeight(this@ActCalculate)
                bottomSheet.showDialog().show()
            }
            R.id.tv_two -> {
                val activityBottomSheet = ClsBottomSheetActivity(this@ActCalculate)
                activityBottomSheet.showDialog().show()
            }
            R.id.tv_three -> {
                val bottomSheetClimate = ClimateBottomSheet(this)
                bottomSheetClimate.showDialog().show()
            }
            R.id.btn_calculate -> {
                calculateRequirement(this@ActCalculate)
                if (validateFeilds()) {
                    val intent = Intent(this@ActCalculate, ActTimeSpanChooser::class.java)
                    startActivity(intent)
                } else {
                    toastMessage("please fill all feilds")
                }
            }
        }
    }

    private fun validateFeilds(): Boolean {
        return !(tvOne!!.text.toString().isEmpty() or
                tvTwo!!.text.toString().isEmpty() or
                tvThree!!.text.toString().isEmpty())
    }

    override fun onResume() {
        super.onResume()
        //        tvOne.setText(textViewOne);
//        tvTwo.setText(textViewTwo);
//        tvThree.setText(textViewThree);

//        tvOne.setText(tvOne.getText());
//        tvTwo.setText(tvTwo.getText());
//        tvThree.setText(tvThree.getText());
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)


//        tvOne.setText(tvOne.getText());
//        tvTwo.setText(tvTwo.getText());
//        tvThree.setText(tvThree.getText());
        textViewOne = tvOne!!.text as String
        textViewTwo = tvTwo!!.text as String
        textViewThree = tvThree!!.text as String
        outState.putString(KEY_WEIGHT, textViewOne)
        outState.putString(KEY_AL, textViewTwo)
        outState.putString(KEY_CLIMATE, textViewThree)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

//        savedInstanceState.getString(KEY_WEIGHT);
//        savedInstanceState.getString(KEY_AL);
//        savedInstanceState.getString(KEY_CLIMATE);
        tvOne!!.text = savedInstanceState.getString(KEY_WEIGHT)
        tvTwo!!.text = savedInstanceState.getString(KEY_AL)
        tvThree!!.text = savedInstanceState.getString(KEY_CLIMATE)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        var tvOne: TextView? = null
        var tvTwo: TextView? = null
        var tvThree: TextView? = null
        const val KEY_WEIGHT = "weight"
        const val KEY_AL = "al"
        const val KEY_CLIMATE = "climate"
    }
}