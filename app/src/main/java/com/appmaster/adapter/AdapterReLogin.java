package com.appmaster.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.appmaster.data.InfoAcconut;
import com.appmaster.layout.ReloginView;

import java.util.List;

/**
 * Created by Gianni on 2016/8/24.
 */

public class AdapterReLogin<T> extends BaseAdapter implements SpinnerAdapter{

    private Context mContext;
    private List<T> mList;

    public AdapterReLogin(Context context, List objects) {
        mContext = context;
        mList = objects;
    }


        @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ReloginView reloginView;
        if (convertView == null) {
            reloginView = new ReloginView(mContext,(InfoAcconut) mList.get(position));
        }else {
            reloginView = (ReloginView) convertView;
        }
        reloginView.setInfo((InfoAcconut) mList.get(position));

        reloginView.getImageViewX().setVisibility(View.GONE);

        return reloginView;
    }

    @Override
    public View getDropDownView(final int position, View convertView, ViewGroup parent) {
        ReloginView reloginView;
        if (convertView == null) {
            reloginView = new ReloginView(mContext,(InfoAcconut) mList.get(position));
        }else {
            reloginView = (ReloginView) convertView;
        }
        reloginView.setInfo((InfoAcconut) mList.get(position));

        reloginView.setXBtnOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "click X " + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        return reloginView;
    }
}
