package com.example.sarahn.waterreminderapp.settings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import com.example.sarahn.waterreminderapp.R
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.Utils.ToastLogger
import com.example.sarahn.waterreminderapp.classes.ClsOnValueChangeListmer
import com.example.sarahn.waterreminderapp.fragments.SettingsFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * Created by SarahN on 7/1/2017.
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

    private fun setText(name: String) {
        SettingsFragment.tvTwo!!.text = name
    }

    companion object {
        var values: Array<String>? = null
        var tv: TextView? = null
    }

    init {
        bottomSheetActivity = BottomSheetDialog(context)
        inflater = LayoutInflater.from(context)
        values = context.resources.getStringArray(R.array.activity)
    }
}