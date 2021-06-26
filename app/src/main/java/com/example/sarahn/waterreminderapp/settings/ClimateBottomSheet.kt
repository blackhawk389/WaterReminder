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
import com.example.sarahn.waterreminderapp.classes.ClimateValueChangedListener
import com.example.sarahn.waterreminderapp.fragments.SettingsFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * Created by SarahN on 7/1/2017.
 */
class ClimateBottomSheet(var context: Context) {
    var bottomSheetClimate: BottomSheetDialog
    var inflater: LayoutInflater
    var numberPickerClimate: NumberPicker? = null
    fun showDialog(): BottomSheetDialog {
        val sheetView = inflater.inflate(R.layout.bottom_sheet_climate, null)
        numberPickerClimate = sheetView.findViewById<View>(R.id.np) as NumberPicker
        tv = sheetView.findViewById<View>(R.id.tv) as TextView
        val btnSave = sheetView.findViewById<View>(R.id.btn_save) as Button
        val btnClose = sheetView.findViewById<View>(R.id.btn_close) as Button
        btnSave.setOnClickListener {
            bottomSheetClimate.dismiss()
            val climate = numberPickerClimate!!.value - 1
            SharedPrefUtils.setClimate(context, values?.get(climate))
            ToastLogger.toastMessage(values?.get(climate))
            SharedPrefUtils.getClimate(context)?.let { it1 -> setText(it1) }
        }
        btnClose.setOnClickListener { bottomSheetClimate.dismiss() }
        numberPickerClimate!!.maxValue = 3
        numberPickerClimate!!.minValue = 1
        numberPickerClimate!!.displayedValues = values
        numberPickerClimate!!.wrapSelectorWheel = false
        bottomSheetClimate.setContentView(sheetView)
        numberPickerClimate!!.setOnValueChangedListener(ClimateValueChangedListener())
        return bottomSheetClimate
    }

    private fun setText(name: String) {
        SettingsFragment.tvThree!!.text = name
    }

    companion object {
        var values: Array<String>? = null
        var tv: TextView? = null
    }

    init {
        bottomSheetClimate = BottomSheetDialog(context)
        inflater = LayoutInflater.from(context)

        // values = new String[]{"resource", "resource" ,"resource"};
        values = context.resources.getStringArray(R.array.climate)
    }
}