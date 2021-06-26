package com.example.sarahn.waterreminderapp.customsViews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.tabs.TabLayout

/**
 * Created by SarahN on 7/1/2017.
 */
class CustomTabLayout : TabLayout {
    var typeface: Typeface? = null

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?) : super(context!!) {
        init()
    }

    override fun addTab(tab: Tab) {
        super.addTab(tab)
        val vg = getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount
        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup
            val tabChildsCount = vgTab.childCount
            for (i in 0 until tabChildsCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {
                    tabViewChild.typeface = typeface
                }
            }
        }
    }

    private fun init() {
        typeface = Typeface.createFromAsset(context.assets, "fonts/webcomic.ttf")
    }
}