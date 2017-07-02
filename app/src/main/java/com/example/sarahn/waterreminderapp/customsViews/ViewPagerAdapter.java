package com.example.sarahn.waterreminderapp.customsViews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarahn.waterreminderapp.R;

/**
 * Created by SarahN on 6/6/2017.
 */
public class ViewPagerAdapter extends PagerAdapter implements View.OnClickListener {

    LayoutInflater layoutInflater;
    int[] source;
    String[] title;
    Typeface typeface;
    Context context;


    public ViewPagerAdapter(Context context, int[] source) {
        this.context = context;
        this.source = source;
        layoutInflater = layoutInflater.from(context);
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/gb.otf");
        title = new String[]{"Get" +
                " periodic" +
                " reminder " +
                "to " +
                "drink water", "Drink" +
                " water " +
                "and " +
                "record", "Stay  hydrated!"};
    }

    @Override
    public int getCount() {
        return source.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = layoutInflater.inflate(R.layout.viewpager_layout, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        TextView textView = (TextView) view.findViewById(R.id.tv);

        iv.setImageResource(source[position]);


        textView.setText(title[position]);
        textView.setTypeface(typeface);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View)object);
    }


    @Override
    public void onClick(View v) {

    }


}
