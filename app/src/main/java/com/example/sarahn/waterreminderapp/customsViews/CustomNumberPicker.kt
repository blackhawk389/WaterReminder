package com.example.sarahn.waterreminderapp.customsViews

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView
import com.example.sarahn.waterreminderapp.classes.MyApplication

/**
 * Created by SarahN on 7/1/2017.
 */
class CustomNumberPicker : NumberPicker {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun addView(child: View) {
        super.addView(child)
        init(child)
    }

    override fun addView(child: View, index: Int) {
        super.addView(child, index)
        init(child)
    }

    override fun addView(child: View, width: Int, height: Int) {
        super.addView(child, width, height)
        init(child)
    }

    override fun addView(child: View, params: ViewGroup.LayoutParams) {
        super.addView(child, params)
        init(child)
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        super.addView(child, index, params)
        init(child)
    }

    private fun init(child: View) {
        if (child is TextView) {
            val face = Typeface.createFromAsset(MyApplication.context?.getAssets(), "fonts/webcomic.ttf")
            (child as EditText).textSize = 13f
            child.setTextColor(Color.parseColor("#333333"))
            child.setTypeface(face)
        }
    }
}