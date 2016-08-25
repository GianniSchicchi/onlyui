package com.appmaster.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.appmaster.R;
import com.appmaster.data.InfoMission;
import com.appmaster.layout.MissionItemView;
import com.appmaster.tools.ViewFactory;

import java.util.List;

/**
 * Created by Gianni on 2016/8/18.
 */

public class AdapterListMission extends BaseAdapter {
    private Context mContext;
    private List<InfoMission> mList;

    public AdapterListMission(Context c, List<InfoMission> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        MissionItemView view;
        if (convertView == null) {
            view = new MissionItemView(mContext);

        } else {
            view = (MissionItemView) convertView;

        }

        if (position % 2 != 0) {
            view.setBackgroundColor(Color.parseColor("#F0F0F0"));
        } else {
            view.setBackgroundColor(Color.WHITE);
        }

        switch (mList.get(position).mIConType) {
            case 0:
                view.getImageView().setImageResource(R.mipmap.icon_20);
                break;
            case 1:
                view.getImageView().setImageResource(R.mipmap.icon_21);
                break;
            case 2:
                view.getImageView().setImageResource(R.mipmap.icon_22);
                break;
            case 3:
                view.getImageView().setImageResource(R.mipmap.icon_23);
                break;
        }

        switch (mList.get(position).mStatus) {
            case Error:
                view.getButton().setClickable(false);
                break;
            case Error1:
                view.getButton().setClickable(false);
                break;
            case NotYet:
                view.getButton().setClickable(false);
                view.getButton().setBackgroundDrawable(ViewFactory.setRadius(15, 15, 15, 15, Color.GRAY));
                break;
            case Complete:
                view.getButton().setClickable(true);
                view.getButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "" + position,
                                Toast.LENGTH_SHORT).show();
                    }
                });
                view.getButton().setBackgroundDrawable(ViewFactory.setRadius(15, 15, 15, 15, Color.parseColor("#961800")));
                break;
            case Geted:
                view.getButton().setClickable(false);
                view.getButton().setBackgroundDrawable(ViewFactory.setRadius(15, 15, 15, 15, Color.BLACK));
                break;


        }

        view.getButton().setText("領取");
        view.getTextView().setText(mList.get(position).mText);

        return view;
    }


}