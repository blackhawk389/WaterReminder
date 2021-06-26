package com.example.sarahn.waterreminderapp.customsViews

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.sarahn.waterreminderapp.R

/**
 * Created by SarahN on 6/6/2017.
 */
class ViewPagerAdapter(var context: Context, var source: IntArray) : PagerAdapter(), View.OnClickListener {
    var layoutInflater: LayoutInflater
    var title: Array<String>
    var typeface: Typeface
    override fun getCount(): Int {
        return source.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = layoutInflater.inflate(R.layout.viewpager_layout, null)
        val iv = view.findViewById<View>(R.id.iv) as ImageView
        val textView = view.findViewById<View>(R.id.tv) as TextView
        iv.setImageResource(source[position])
        textView.text = title[position]
        textView.typeface = typeface
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun onClick(v: View) {}

    init {
        layoutInflater = LayoutInflater.from(context)
        typeface = Typeface.createFromAsset(context.assets, "fonts/gb.otf")
        title = arrayOf("Get" +
                " periodic" +
                " reminder " +
                "to " +
                "drink water", "Drink" +
                " water " +
                "and " +
                "record", "Stay  hydrated!")
    }
}