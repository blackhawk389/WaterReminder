package com.example.sarahn.waterreminderapp.customsViews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.Button

/**
 * Created by SarahN on 6/30/2017.
 */
class CustomBtnFonty : Button {
    constructor(context: Context) : super(context) {
        val face = Typeface.createFromAsset(context.assets, "fonts/webcomic.ttf")
        this.typeface = face
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val face = Typeface.createFromAsset(context.assets, "fonts/webcomic.ttf")
        this.typeface = face
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val face = Typeface.createFromAsset(context.assets, "fonts/webcomic.ttf")
        this.typeface = face
    }
}