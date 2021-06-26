package com.example.sarahn.waterreminderapp.fragments

import android.app.Activity
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sarahn.waterreminderapp.R
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.Utils.ToastLogger
import com.example.sarahn.waterreminderapp.classes.*
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator.calculateRequirement
import com.example.sarahn.waterreminderapp.customsViews.CustomBtnFonty
import com.example.sarahn.waterreminderapp.dialogs.ClsTimePickerDialogBuilder.showDialog

class SettingsFragment : Fragment(), View.OnClickListener {
    private var mListener: OnFragmentInteractionListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        tvOne = view.findViewById<View>(R.id.tv_one) as TextView
        tvTwo = view.findViewById<View>(R.id.tv_two) as TextView
        tvThree = view.findViewById<View>(R.id.tv_three) as TextView
        tvSpan = view.findViewById<View>(R.id.tv_span) as TextView
        btnUpdate = view.findViewById<View>(R.id.recalculate) as CustomBtnFonty
        tvOne!!.text = Integer.toString(SharedPrefUtils.getWeight(context))
        tvTwo!!.text = SharedPrefUtils.getActivityLevel(context)
        tvThree!!.text = SharedPrefUtils.getClimate(context)
        btnUpdate!!.setBackgroundColor(Color.parseColor("#ff0000"))
        tvSpan!!.text = (SharedPrefUtils.getStartHour(MyApplication.context).toString() + ":"
                + SharedPrefUtils.getStartMin(MyApplication.context) + "-" + SharedPrefUtils.getEndHour(MyApplication.context)
                + ":" + SharedPrefUtils.getEndMin(MyApplication.context))
        tvOne!!.setOnClickListener(this)
        tvTwo!!.setOnClickListener(this)
        tvThree!!.setOnClickListener(this)
        tvSpan!!.setOnClickListener(this)
        btnUpdate!!.setOnClickListener(this)
        return view
    }

    fun onButtonPressed(uri: Uri?) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mListener = try {
            activity as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_one -> {
                isFromSettigBottomSheet = true
                val bottomSheet = ClsBottomSheetWeight(requireContext())
                bottomSheet.showDialog().show()
            }
            R.id.tv_two -> {
                isFromSettigBottomSheet = true
                val activityBottomSheet = ClsBottomSheetActivity(requireContext())
                activityBottomSheet.showDialog().show()
            }
            R.id.tv_three -> {
                isFromSettigBottomSheet = true
                val bottomSheetClimate = ClimateBottomSheet(requireContext())
                bottomSheetClimate.showDialog().show()
            }
            R.id.tv_span -> {
                isFromSettings = true
                showDialog(context).show(activity?.fragmentManager, "timepicker")
            }
            R.id.recalculate -> {
                calculateRequirement(context)
                NotificationUtills.NotificationCounter()
                ToastLogger.toastMessage("Updated! new duration " + SharedPrefUtils.getDuration(context))
                ToastLogger.toastMessage("Will be applicable on next span")
            }
        }
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri?)
    }

    companion object {
        var isFromSettings = false
        @JvmField
        var tvOne: TextView? = null
        @JvmField
        var tvTwo: TextView? = null
        @JvmField
        var tvThree: TextView? = null
        var tvSpan: TextView? = null
        var btnUpdate: CustomBtnFonty? = null
        var isFromSettigBottomSheet = false
    }
}