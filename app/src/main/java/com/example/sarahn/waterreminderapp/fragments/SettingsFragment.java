package com.example.sarahn.waterreminderapp.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.R;
import com.example.sarahn.waterreminderapp.Utils.NotificationUtills;
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.Utils.ToastLogger;
import com.example.sarahn.waterreminderapp.classes.ClimateBottomSheet;
import com.example.sarahn.waterreminderapp.classes.ClsAMOrPM;
import com.example.sarahn.waterreminderapp.classes.ClsRequirementCalculator;
import com.example.sarahn.waterreminderapp.classes.MyApplication;
import com.example.sarahn.waterreminderapp.dialogs.ClsTimePickerDialogBuilder;
import com.example.sarahn.waterreminderapp.customsViews.CustomBtnFonty;
import com.example.sarahn.waterreminderapp.settings.ClsBottomSheetActivity;
import com.example.sarahn.waterreminderapp.settings.ClsBottomSheetWeight;

public class SettingsFragment extends Fragment  implements OnClickListener {

    private OnFragmentInteractionListener mListener;

    public static TextView tvOne;
    public static TextView tvTwo;
    public static TextView tvThree;
    public static TextView tvSpan;
    public static CustomBtnFonty btnUpdate;
    public static boolean isFromSettings;




    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        tvOne = (TextView) view.findViewById(R.id.tv_one);
        tvTwo = (TextView) view.findViewById(R.id.tv_two);
        tvThree = (TextView) view.findViewById(R.id.tv_three);
        tvSpan = (TextView) view.findViewById(R.id.tv_span);
        btnUpdate = (CustomBtnFonty) view.findViewById(R.id.recalculate);

        tvOne.setText(Integer.toString(SharedPrefUtils.getWeight(getContext())));
        tvTwo.setText(SharedPrefUtils.getActivityLevel(getContext()));
        tvThree.setText(SharedPrefUtils.getClimate(getContext()));
        btnUpdate.setBackgroundColor(Color.parseColor("#ff0000"));

        tvSpan.setText(SharedPrefUtils.getStartHour(getContext())+":"
        + SharedPrefUtils.getStartMin(getContext())+ "-" + SharedPrefUtils.getEndHour(getContext())
        +":" + SharedPrefUtils.getEndMin(getContext()));


        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThree.setOnClickListener(this);
        tvSpan.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        return view;
    }


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

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_one:
                ClsBottomSheetWeight bottomSheet = new ClsBottomSheetWeight(getContext());
                bottomSheet.showDialog().show();
                //make the bellow line of code only works when it return from bottomsheet
                // tvOne.setText(Integer.toString(SharedPrefUtils.getWeight(this)));
                break;

            case R.id.tv_two:
                ClsBottomSheetActivity activityBottomSheet = new ClsBottomSheetActivity(getContext());
                activityBottomSheet.showDialog().show();
                break;

            case R.id.tv_three:
                ClimateBottomSheet bottomSheetClimate = new ClimateBottomSheet(getContext());
                bottomSheetClimate.showDialog().show();
                break;

            case R.id.tv_span:
                isFromSettings = true;
                ClsTimePickerDialogBuilder.showDialog(getContext()).show(getActivity().getFragmentManager(), "timepicker");
                break;
            case R.id.recalculate:
                ClsRequirementCalculator.calculateRequirement(getContext());
                NotificationUtills.NotificationCounter();
                ToastLogger.toastMessage("Updated");
                break;
        }

    }


    public interface OnFragmentInteractionListener {
        
        public void onFragmentInteraction(Uri uri);
    }

}
