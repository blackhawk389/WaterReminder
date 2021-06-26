package com.example.sarahn.waterreminderapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.sarahn.waterreminderapp.ActCalculate
import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils.setIsTrue
import com.example.sarahn.waterreminderapp.customsViews.ViewPagerAdapter
import me.relex.circleindicator.CircleIndicator

class ActViewPager : Activity(), View.OnClickListener, OnPageChangeListener {
    var viewPager: ViewPager? = null
    var source: IntArray? = null
    var btnSkip: Button? = null
    var btnNext: Button? = null
    var btnGot: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_view_pager)
        source = intArrayOf(R.drawable.water_slide_one, R.drawable.water_slide_three, R.drawable.water_slide_two)
        initViewPager()
    }

    fun initViewPager() {
        viewPager = findViewById<View>(R.id.view_pager) as ViewPager
        viewPager!!.adapter = source?.let { ViewPagerAdapter(this, it) }
        val indicator = findViewById<View>(R.id.indicator) as CircleIndicator
        indicator.setViewPager(viewPager)
        btnSkip = findViewById<View>(R.id.btn_skip) as Button
        btnNext = findViewById<View>(R.id.btn_next) as Button
        btnGot = findViewById<View>(R.id.btn_got) as Button
        btnNext!!.setOnClickListener(this)
        btnSkip!!.setOnClickListener(this)
        btnGot!!.setOnClickListener(this)
        viewPager!!.addOnPageChangeListener(this)
    }

    override fun onClick(v: View) {
        var currentposition = viewPager!!.currentItem
        when (v.id) {
            R.id.btn_next -> {
                viewPager!!.setCurrentItem(++currentposition, true)
                if (++currentposition == viewPager!!.adapter!!.count) {
                    btnNext!!.visibility = View.GONE
                    btnSkip!!.visibility = View.GONE
                    btnGot!!.visibility = View.VISIBLE
                }
            }
            R.id.btn_skip -> {
                setIsTrue(false, this)
                val intent = Intent(this, ActCalculate::class.java)
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent)
            }
            R.id.btn_got -> {
                setIsTrue(false, this)
                val gotIntent = Intent(this, ActCalculate::class.java)
                //    gotIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(gotIntent)
            }
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {
        var position = position
        if (++position == viewPager!!.adapter!!.count) {
            btnSkip!!.visibility = View.GONE
            btnNext!!.visibility = View.GONE
            btnGot!!.visibility = View.VISIBLE
        }
    }

    override fun onPageScrollStateChanged(state: Int) {}
}