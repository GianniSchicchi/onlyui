package com.appmaster.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appmaster.R;
import com.appmaster.data.InfoAnn;

import java.util.List;

/**
 * Created by Gianni on 2016/8/18.
 */

public class AdapterPayList extends BaseAdapter {
    private Context mContext;
    private List<String> mList;

    public AdapterPayList(Context c, List<String> list) {
        mContext = c;
        mList = list;
    }

    public int getCount() {
        return mList.size();
    }

    public Object getItem(int position) {
        return mList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout layout;
        TextView txtTitle;

        FrameLayout frameLayout;
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            layout = new RelativeLayout(mContext);

            txtTitle = new TextView(mContext);

            frameLayout = new FrameLayout(mContext);
            imageView = new ImageView(mContext);

            frameLayout.addView(imageView);


            layout.addView(txtTitle);
            layout.addView(frameLayout);



        } else {
            layout = (RelativeLayout) convertView;

            txtTitle = (TextView) layout.getChildAt(0);
            frameLayout = (FrameLayout) layout.getChildAt(1);
            imageView = (ImageView) frameLayout.getChildAt(0);
        }

        if(position % 2 != 0) {
            layout.setBackgroundColor(Color.parseColor("#F0F0F0"));
        } else {
            layout.setBackgroundColor(Color.WHITE);
        }


        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        frameLayout.setLayoutParams(params);
        frameLayout.setPadding(0,0,20,0);

        imageView.setImageResource(R.mipmap.arrow);


        txtTitle.setTextColor(Color.RED);

        txtTitle.setPadding(20,10,0,10);
        txtTitle.setTextSize(20);

        txtTitle.setText(mList.get(position));
        return layout;
    }



}