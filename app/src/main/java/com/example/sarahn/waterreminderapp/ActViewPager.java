package com.example.sarahn.waterreminderapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sarahn.waterreminderapp.Utils.SharedPrefUtils;
import com.example.sarahn.waterreminderapp.customsViews.ViewPagerAdapter;

import me.relex.circleindicator.CircleIndicator;


public class ActViewPager extends Activity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    ViewPager viewPager;
    int[] source;
    Button btnSkip;
    Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_view_pager);
        source = new int[] {R.drawable.water_slide_one, R.drawable.water_slide_three, R.drawable.water_slide_two};
        initViewPager();
    }

    void initViewPager(){
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(this, source));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);

        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);

        viewPager.addOnPageChangeListener(this);

    }

    @Override
    public void onClick(View v) {

        int currentposition = viewPager.getCurrentItem();
        switch (v.getId()){
            case R.id.btn_next:

                viewPager.setCurrentItem(++currentposition, true);

                if(++currentposition == viewPager.getAdapter().getCount()){
                    btnNext.setText("Got It");
                    btnSkip.setVisibility(View.GONE);
                }
                break;



            case R.id.btn_skip:

                    SharedPrefUtils.setIsTrue(false, getApplicationContext());
                    Intent intent = new Intent(this, ActCalculate.class);
                    startActivity(intent);
                    break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        
    }

    @Override
    public void onPageSelected(int position) {

        if(position == viewPager.getAdapter().getCount()){
            btnNext.setText("Got It");
            btnSkip.setVisibility(View.GONE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
