package com.example.sarahn.waterreminderapp.customsViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by SarahN on 6/30/2017.
 */
public class CustomBtnFonty extends Button {
    public CustomBtnFonty(Context context) {
        super(context);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/webcomic.ttf");
        this.setTypeface(face);
    }

    public CustomBtnFonty(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/webcomic.ttf");
        this.setTypeface(face);
    }

    public CustomBtnFonty(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/webcomic.ttf");
        this.setTypeface(face);
    }

}
