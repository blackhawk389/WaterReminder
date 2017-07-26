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
    Button btnGot;


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
        btnGot = (Button) findViewById(R.id.btn_got);

        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        btnGot.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {

        int currentposition = viewPager.getCurrentItem();
        switch (v.getId()){

            case R.id.btn_next:
                viewPager.setCurrentItem(++currentposition, true);

                if(++currentposition == viewPager.getAdapter().getCount()){
                    btnNext.setVisibility(View.GONE);
                    btnSkip.setVisibility(View.GONE);
                    btnGot.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.btn_skip:
                    SharedPrefUtils.setIsTrue(false, this);
                    Intent intent = new Intent(this, ActCalculate.class);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
            case R.id.btn_got:
                SharedPrefUtils.setIsTrue(false, this);
                Intent gotIntent = new Intent(this, ActCalculate.class);
            //    gotIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(gotIntent);
                break;

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        if(++position == viewPager.getAdapter().getCount()){
            btnSkip.setVisibility(View.GONE);
            btnNext.setVisibility(View.GONE);
            btnGot.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
