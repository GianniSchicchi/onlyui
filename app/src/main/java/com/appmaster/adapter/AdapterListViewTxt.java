package com.appmaster.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appmaster.data.InfoAnn;

import java.util.List;

/**
 * Created by Gianni on 2016/8/18.
 */

public class AdapterListViewTxt extends BaseAdapter {
    private Context mContext;
    private List<InfoAnn> mList;

    public AdapterListViewTxt(Context c, List<InfoAnn> list) {
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
        LinearLayout linearLayoutP;
        LinearLayout linearLayoutH;
        TextView txtDate;
        TextView txtTitleType;
        TextView txtTitlePriority;
        TextView txtTitleContent;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            linearLayoutP = new LinearLayout(mContext);
            linearLayoutP.setOrientation(LinearLayout.VERTICAL);
            linearLayoutH = new LinearLayout(mContext);
            linearLayoutH.setOrientation(LinearLayout.HORIZONTAL);

            txtDate = new TextView(mContext);
            txtTitleType = new TextView(mContext);
            txtTitlePriority = new TextView(mContext);
            txtTitleContent = new TextView(mContext);

            linearLayoutH.addView(txtTitleType);
            linearLayoutH.addView(txtTitlePriority);
            linearLayoutH.addView(txtTitleContent);

            linearLayoutP.addView(txtDate);
            linearLayoutP.addView(linearLayoutH);


        } else {
            linearLayoutP = (LinearLayout) convertView;

            txtDate = (TextView) linearLayoutP.getChildAt(0);

            linearLayoutH = (LinearLayout) linearLayoutP.getChildAt(1);
            txtTitleType = (TextView) linearLayoutH.getChildAt(0);
            txtTitlePriority = (TextView) linearLayoutH.getChildAt(1);
            txtTitleContent = (TextView) linearLayoutH.getChildAt(2);
        }

        if(position % 2 != 0) {
            linearLayoutP.setBackgroundColor(Color.parseColor("#F0F0F0"));
        } else {
            linearLayoutP.setBackgroundColor(Color.WHITE);
        }

        txtTitleType.setTextColor(Color.RED);

        txtDate.setTextSize(20);
        txtTitleType.setTextSize(20);
        txtTitlePriority.setTextSize(20);
        txtTitleContent.setTextSize(20);

        txtTitleContent.setSingleLine();
        txtTitleContent.setEllipsize(TextUtils.TruncateAt.END);

        txtDate.setText(mList.get(position).mDate);
        txtTitleType.setText("【" + mList.get(position).mTitleType + "】");
        txtTitlePriority.setText("【" + mList.get(position).mTitlePriority + "】");
        txtTitleContent.setText(mList.get(position).mTitleContent);
        return linearLayoutP;
    }



}