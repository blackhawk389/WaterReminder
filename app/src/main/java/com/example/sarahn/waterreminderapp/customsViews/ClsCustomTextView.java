package com.example.sarahn.waterreminderapp.customsViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.R;

/**
 * Created by SarahN on 6/4/2017.
 */
public class ClsCustomTextView extends TextView implements Animation.AnimationListener{
    public ClsCustomTextView(Context context) {
        super(context);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/Fonty.ttf");
        this.setTypeface(face);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.text_slide_out);
        animation.setStartOffset(2500);
        startAnimation(animation);
        animation.setAnimationListener(this);
    }

    public ClsCustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/Fonty.ttf");
        this.setTypeface(face);

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.text_slide_out);
        animation.setStartOffset(2500);
        startAnimation(animation);
        animation.setAnimationListener(this);
    }

    public ClsCustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/Fonty.ttf");
        this.setTypeface(face);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.text_slide_out);
        animation.setStartOffset(2500);
        startAnimation(animation);
        animation.setAnimationListener(this);
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
            setVisibility(View.GONE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
