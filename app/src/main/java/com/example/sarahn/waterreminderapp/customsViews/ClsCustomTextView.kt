package com.example.sarahn.waterreminderapp.customsViews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.sarahn.waterreminderapp.R

/**
 * Created by SarahN on 6/4/2017.
 */
class ClsCustomTextView : TextView, Animation.AnimationListener {
    constructor(context: Context) : super(context) {
        val face = Typeface.createFromAsset(context.assets, "fonts/Fonty.ttf")
        this.typeface = face
        val animation = AnimationUtils.loadAnimation(context, R.anim.text_slide_out)
        animation.startOffset = 2500
        startAnimation(animation)
        animation.setAnimationListener(this)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val face = Typeface.createFromAsset(context.assets, "fonts/Fonty.ttf")
        this.typeface = face
        val animation = AnimationUtils.loadAnimation(context, R.anim.text_slide_out)
        animation.startOffset = 2500
        startAnimation(animation)
        animation.setAnimationListener(this)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val face = Typeface.createFromAsset(context.assets, "fonts/Fonty.ttf")
        this.typeface = face
        val animation = AnimationUtils.loadAnimation(context, R.anim.text_slide_out)
        animation.startOffset = 2500
        startAnimation(animation)
        animation.setAnimationListener(this)
    }

    override fun onAnimationStart(animation: Animation) {}
    override fun onAnimationEnd(animation: Animation) {
        visibility = GONE
    }

    override fun onAnimationRepeat(animation: Animation) {}
}