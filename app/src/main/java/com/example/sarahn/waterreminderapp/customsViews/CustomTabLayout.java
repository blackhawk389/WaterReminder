package com.example.sarahn.waterreminderapp.customsViews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.Utils.Logging;

/**
 * Created by SarahN on 7/1/2017.
 */
public class CustomTabLayout extends TabLayout {

    Typeface typeface;

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTabLayout(Context context) {
        super(context);
        init();
    }

    @Override
    public void addTab(Tab tab) {
        super.addTab(tab);


            ViewGroup vg = (ViewGroup) getChildAt(0);
            int tabsCount = vg.getChildCount();
            for (int j = 0; j < tabsCount; j++) {
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTypeface(typeface);
                    }
                }
            }

    }

    private void init() {
        typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/webcomic.ttf");
    }
}
