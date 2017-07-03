package com.example.sarahn.waterreminderapp.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.Logging;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.classes.AnimationHelper;
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator;
import com.example.sarahn.waterreminderapp.classes.MyApplication;
import com.example.sarahn.waterreminderapp.classes.RemainingRequirement;
import com.gelitenight.waveview.library.WaveView;

public class TodayFragment extends Fragment {

    private AnimationHelper mWaveHelper;
    private TextView tvInfo;
    private int calculated;
    private int consumed;
    private int remained;

    private OnFragmentInteractionListener mListener;

    public TodayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_today, container, false);
        final WaveView waveView = (WaveView) view.findViewById(R.id.wave);
        tvInfo = (TextView) view.findViewById(R.id.tv_info);
        waveView.setWaveColor(Color.parseColor("#add8e6"), Color.parseColor("#8aacb8"));
        waveView.setShowWave(true);

        tvInfo.setText("Requirement  is  " +
                        SharedPrefUtils.getRequired(MyApplication.getContext())/250
                        + "  Glasses,  Consumed  " + SharedPrefUtils.getConsumed(MyApplication.getContext())/250
                + "  Glasses  " +" Remained  " + SharedPrefUtils.getRemained(MyApplication.getContext())/250 + "  Glasses");
      //  waveView.setBorder(mBorderWidth, mBorderColor);
        mWaveHelper = new AnimationHelper(waveView);

        waveView.setShapeType(WaveView.ShapeType.SQUARE);

        mWaveHelper.start();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        calculated = ClsRequirementCalculator.mlToGlass();
//        consumed = RemainingRequirement.consumedGlassOfWater();
//        remained = RemainingRequirement.remainGlassOfWater();

    }
}
