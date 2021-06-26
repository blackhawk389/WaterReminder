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
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils
import com.example.sarahn.waterreminderapp.classes.AnimationHelper
import com.example.sarahn.waterreminderapp.classes.MyApplication
import com.gelitenight.waveview.library.WaveView

class TodayFragment : Fragment() {
    private var mWaveHelper: AnimationHelper? = null
    private var tvInfo: TextView? = null
    private val calculated = 0
    private val consumed = 0
    private val remained = 0
    var duration: TextView? = null
    private var mListener: OnFragmentInteractionListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_today, container, false)
        val waveView = view.findViewById<View>(R.id.wave) as WaveView
        tvInfo = view.findViewById<View>(R.id.tv_info) as TextView
        duration = view.findViewById<View>(R.id.tv_duration) as TextView
        waveView.setWaveColor(Color.parseColor("#add8e6"), Color.parseColor("#8aacb8"))
        waveView.isShowWave = true
        tvInfo!!.text = "Requirement  is  " + SharedPrefUtils.getRequired(MyApplication.context) / 250 + "  Glasses,  Consumed  " + SharedPrefUtils.getConsumed(MyApplication.context) / 250 + "  Glasses  " + " Remained  " + SharedPrefUtils.getRemained(MyApplication.context) / 250 + "  Glasses"
        //  waveView.setBorder(mBorderWidth, mBorderColor);
        duration!!.text = SharedPrefUtils.getDuration(context).toString() + ""
        //tomany notification
        mWaveHelper = AnimationHelper(waveView)
        waveView.setShapeType(WaveView.ShapeType.SQUARE)
        mWaveHelper!!.start()
        return view
    }

    override fun onStart() {
        super.onStart()
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri?)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        //        calculated = ClsRequirementCalculator.mlToGlass();
//        consumed = RemainingRequirement.consumedGlassOfWater();
//        remained = RemainingRequirement.remainGlassOfWater();
    }
}