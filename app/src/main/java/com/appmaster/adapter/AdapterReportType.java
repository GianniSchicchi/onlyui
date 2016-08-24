package com.appmaster.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Gianni on 2016/8/24.
 */

public class AdapterReportType extends ArrayAdapter {
    public AdapterReportType(Context context, int resource) {
        super(context, resource);
    }

    public AdapterReportType(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
    }

    public AdapterReportType(Context context, int resource, List objects) {
        super(context, resource, objects);
    }


    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        return super.getView(position, convertView, parent);
    }
}
