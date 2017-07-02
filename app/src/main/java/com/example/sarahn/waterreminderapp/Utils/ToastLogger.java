package com.example.sarahn.waterreminderapp.Utils;

import android.widget.Toast;

import com.example.sarahn.waterreminderapp.classes.MyApplication;

/**
 * Created by SarahN on 7/1/2017.
 */
public class ToastLogger {

    public static void toastMessage(String name){
        Toast.makeText(MyApplication.getContext(), name , Toast.LENGTH_SHORT).show();
    }
}
