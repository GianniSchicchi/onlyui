package com.appmaster;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gianni on 2016/8/18.
 */

public class AdapterListViewReportHistory extends BaseAdapter {
    private Context mContext;
    private List<InfoReport> mList;

    public AdapterListViewReportHistory(Context c, List<InfoReport> list) {
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

        LinearLayout linearLayoutH1;
        TextView txtDate;
        TextView txtRead;

        LinearLayout linearLayoutH2;
        TextView txtTitleType;
        TextView txtTitlePriority;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            linearLayoutP = new LinearLayout(mContext);
            linearLayoutP.setOrientation(LinearLayout.VERTICAL);

            linearLayoutH1 = new LinearLayout(mContext);
            linearLayoutH1.setOrientation(LinearLayout.HORIZONTAL);


            linearLayoutH2 = new LinearLayout(mContext);
            linearLayoutH2.setOrientation(LinearLayout.HORIZONTAL);

            txtDate = new TextView(mContext);
            txtRead = new TextView(mContext);

            txtTitleType = new TextView(mContext);
            txtTitlePriority = new TextView(mContext);

            linearLayoutH1.addView(txtDate);
            linearLayoutH1.addView(txtRead);

            linearLayoutH2.addView(txtTitleType);
            linearLayoutH2.addView(txtTitlePriority);

            linearLayoutP.addView(linearLayoutH1);
            linearLayoutP.addView(linearLayoutH2);


        } else {
            linearLayoutP = (LinearLayout) convertView;


            linearLayoutH1 = (LinearLayout) linearLayoutP.getChildAt(0);
            txtDate = (TextView) linearLayoutH1.getChildAt(0);
            txtRead = (TextView) linearLayoutH1.getChildAt(1);


            linearLayoutH2 = (LinearLayout) linearLayoutP.getChildAt(1);
            txtTitleType = (TextView) linearLayoutH2.getChildAt(0);
            txtTitlePriority = (TextView) linearLayoutH2.getChildAt(1);
        }

        if(position % 2 != 0) {
            linearLayoutP.setBackgroundColor(Color.parseColor("#F0F0F0"));
        } else {
            linearLayoutP.setBackgroundColor(Color.WHITE);
        }

        txtTitleType.setTextColor(Color.RED);

        txtDate.setTextSize(20);
        txtRead.setTextSize(20);


        txtTitleType.setTextSize(20);
        txtTitlePriority.setTextSize(20);


        txtDate.setText(mList.get(position).mDate);


        txtRead.setText(mList.get(position).mIsRead?"    已回復":"    未回復");
        if (mList.get(position).mIsRead) {
            txtRead.setTextColor(Color.parseColor("#7700BB"));
        } else {
            txtRead.setTextColor(Color.parseColor("#00BBFF"));
        }



        txtTitleType.setText("【" + mList.get(position).mTitleType + "】");
        txtTitlePriority.setText("" + mList.get(position).mTitlePriority + "");

        return linearLayoutP;
    }



}