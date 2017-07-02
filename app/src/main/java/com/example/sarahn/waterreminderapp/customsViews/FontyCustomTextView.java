package com.example.sarahn.waterreminderapp.customsViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import me.grantland.widget.AutofitHelper;

/**
 * Created by SarahN on 6/30/2017.
 */
public class FontyCustomTextView extends TextView {
    public FontyCustomTextView(Context context) {
        super(context);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/webcomic.ttf");
        this.setTypeface(face);
    }

    public FontyCustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/webcomic.ttf");
        this.setTypeface(face);

    }

    public FontyCustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/webcomic.ttf");
        this.setTypeface(face);
    }


}
