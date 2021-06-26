package com.example.sarahn.waterreminderapp.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import com.example.sarahn.waterreminderapp.ActCalculate
import com.example.sarahn.waterreminderapp.R
import com.example.sarahn.waterreminderapp.Utils.Logging
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.Utils.ToastLogger
import com.example.sarahn.waterreminderapp.fragments.SettingsFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * Created by SarahN on 6/13/2017.
 */
class ClsBottomSheetActivity(var context: Context) {
    var bottomSheetActivity: BottomSheetDialog
    var inflater: LayoutInflater
    var numberPickerActivity: NumberPicker? = null
    fun showDialog(): BottomSheetDialog {
        val sheetView = inflater.inflate(R.layout.bottom_sheet_activity, null)
        numberPickerActivity = sheetView.findViewById<View>(R.id.np) as NumberPicker
        tv = sheetView.findViewById<View>(R.id.tv) as TextView
        val btnSave = sheetView.findViewById<View>(R.id.btn_save) as Button
        val btnClose = sheetView.findViewById<View>(R.id.btn_close) as Button
        btnSave.setOnClickListener {
            bottomSheetActivity.dismiss()
            val activityLevel = numberPickerActivity!!.value - 1
            SharedPrefUtils.setActivityLevel(context, values?.get(activityLevel))
            ToastLogger.toastMessage(values?.get(activityLevel))
            SharedPrefUtils.getActivityLevel(context)?.let { it1 -> setText(it1) }
        }
        btnClose.setOnClickListener { bottomSheetActivity.dismiss() }
        numberPickerActivity!!.maxValue = 4
        numberPickerActivity!!.minValue = 1
        numberPickerActivity!!.displayedValues = values
        numberPickerActivity!!.wrapSelectorWheel = false
        bottomSheetActivity.setContentView(sheetView)
        numberPickerActivity!!.setOnValueChangedListener(ClsOnValueChangeListmer())
        return bottomSheetActivity
    }

    //
    //    private void setText(String name){
    //        ActCalculate.tvTwo.setText(name);
    //    }
    private fun setText(name: String) {
        if (SettingsFragment.isFromSettigBottomSheet) {
            SettingsFragment.tvTwo?.text = name
            Logging.logMessage("from settig bottm sheet")
            SettingsFragment.isFromSettigBottomSheet = false
        } else {
            ActCalculate.tvTwo?.text = name
            Logging.logMessage("from regular bottm sheet")
        }
    }

    companion object {
        @JvmField
        var values: Array<String>? = null
        @JvmField
        var tv: TextView? = null
    }

    init {
        bottomSheetActivity = BottomSheetDialog(context)
        inflater = LayoutInflater.from(context)
        values = context.resources.getStringArray(R.array.activity)
    }
}