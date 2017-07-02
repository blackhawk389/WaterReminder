package com.example.sarahn.waterreminderapp.customsViews;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.classes.MyApplication;

import me.grantland.widget.AutofitHelper;

/**
 * Created by SarahN on 7/1/2017.
 */
public class CustomNumberPicker extends NumberPicker {
    public CustomNumberPicker(Context context) {
        super(context);
    }

    public CustomNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        init(child);
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
        init(child);

    }

    @Override
    public void addView(View child, int width, int height) {
        super.addView(child, width, height);
        init(child);

    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        init(child);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        init(child);

    }

    private void init(View child){
        if(child instanceof TextView){
            Typeface face= Typeface.createFromAsset(MyApplication.getContext().getAssets(), "fonts/webcomic.ttf");
            ((EditText) child).setTextSize(13);
            ((EditText) child).setTextColor(Color.parseColor("#333333"));
            ((EditText) child).setTypeface(face);


        }
    }
}
