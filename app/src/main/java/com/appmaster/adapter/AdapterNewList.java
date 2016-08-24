package com.appmaster.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.appmaster.data.InfoAnn;
import com.appmaster.layout.NewsItemView;

import java.util.List;

/**
 * Created by Gianni on 2016/8/18.
 */

public class AdapterNewList extends BaseAdapter {
    private Context mContext;
    private List<InfoAnn> mList;

    public AdapterNewList(Context c, List<InfoAnn> list) {
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

    public View getView(int position, View convertView, ViewGroup parent) {
        NewsItemView itemView;
        if (convertView == null) {
            itemView = new NewsItemView(mContext);
        } else {
            itemView = (NewsItemView) convertView;
        }
        if (position % 2 != 0) {
            itemView.setBackgroundColor(Color.parseColor("#F0F0F0"));
        } else {
            itemView.setBackgroundColor(Color.WHITE);
        }
        itemView.setInfo(mList.get(position));
        return itemView;
    }
}