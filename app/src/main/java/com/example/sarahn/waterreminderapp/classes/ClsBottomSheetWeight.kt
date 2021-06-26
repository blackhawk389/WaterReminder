package com.example.sarahn.waterreminderapp.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
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
 * Created by SarahN on 6/12/2017.
 */
class ClsBottomSheetWeight(var context: Context) {
    var inflater: LayoutInflater
    var mBottomSheetDialog: BottomSheetDialog
    fun showDialog(): BottomSheetDialog {
        val sheetView = inflater.inflate(R.layout.bottom_sheet, null)
        minutePicker = sheetView.findViewById<View>(R.id.np) as NumberPicker
        tv = sheetView.findViewById<View>(R.id.tv) as TextView
        val btnSave = sheetView.findViewById<View>(R.id.btn_save) as Button
        val btnClose = sheetView.findViewById<View>(R.id.btn_close) as Button
        btnSave.setOnClickListener {
            mBottomSheetDialog.dismiss()
            val weight = values?.get(minutePicker!!.value - 1)
            weight?.toInt()?.let { it1 -> SharedPrefUtils.setWeight(context, it1) }
            ToastLogger.toastMessage("Weight $weight")
            //maybe using rxjava
            weight?.let { it1 -> setText(it1) }
        }
        btnClose.setOnClickListener { mBottomSheetDialog.dismiss() }
        minutePicker!!.maxValue = 18
        minutePicker!!.minValue = 1
        minutePicker!!.displayedValues = values
        minutePicker!!.wrapSelectorWheel = false
        mBottomSheetDialog.setContentView(sheetView)
        minutePicker!!.showDividers = LinearLayout.SHOW_DIVIDER_NONE
        minutePicker!!.setOnValueChangedListener(ClsCallbackWeight())
        return mBottomSheetDialog
    }

    private fun setText(weight: String) {
        if (SettingsFragment.isFromSettigBottomSheet) {
            SettingsFragment.tvOne?.text = weight
            Logging.logMessage("from settig bottm sheet")
            SettingsFragment.isFromSettigBottomSheet = false
        } else {
            ActCalculate.tvOne?.text = weight
            Logging.logMessage("from regular bottm sheet")
        }
    }

    companion object {
        @JvmField
        var tv: TextView? = null
        var minutePicker: NumberPicker? = null
        @JvmField
        var values: Array<String>? = null
    }

    init {
        mBottomSheetDialog = BottomSheetDialog(context)
        inflater = LayoutInflater.from(context)
        values = arrayOf("30", "35", "40",
                "45", "50", "55", "60",
                "65", "70", "75", "80",
                "86", "90", "95", "100",
                "105", "110", "120")
    }
}