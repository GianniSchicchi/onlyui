package com.appmaster.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appmaster.R;

/**
 * Created by Gianni on 2016/8/18.
 */

public class AdapterGridViewImgTxt extends BaseAdapter {
    private Context mContext;
    // references to our images
    private Integer[] mThumbIds = {
            R.mipmap.icon_12,
            R.mipmap.icon_8,
            R.mipmap.icon_10,
            R.mipmap.icon_11,
            R.mipmap.icon_13,
            R.mipmap.icon_9
    };
    private String[] mStrings = {
            "帳號綁定",
            "活動任務",
            "遊戲論壇",
            "公告資訊",
            "購買記錄",
            "聯繫客服"
    };

    public AdapterGridViewImgTxt(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            linearLayout = new LinearLayout(mContext);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setGravity(Gravity.CENTER);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            layoutParams.setMargins(15, 15, 15, 15);
            linearLayout.setLayoutParams(layoutParams);

            imageView = new ImageView(mContext);
            textView = new TextView(mContext);
            textView.setGravity(Gravity.CENTER);

            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

            linearLayout.addView(imageView);
            linearLayout.addView(textView);


            imageView.setImageResource(mThumbIds[position]);
            textView.setText(mStrings[position]);
        } else {
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            textView = (TextView) linearLayout.getChildAt(1);
        }

        imageView.setImageResource(mThumbIds[position]);
        textView.setText(mStrings[position]);
        return linearLayout;
    }

}