package com.appmaster;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.appmaster.data.InfoNews;
import com.appmaster.layout.NewsItemView;
import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

public class Activity10NewsDetail extends ActivityGViewBar {


    InfoNews info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        info = new InfoNews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }


    void setView() {
        setTitleStringView(true, "公告訊息");
        setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTitleRightButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getView();

        newLinearLayout3();

        newLinearLayoutPortait2();


        LinearLayout linearLayout = ViewLayoutFactory.createNewLinearLayoutVERTICAL(mAct);

        NewsItemView newsItemView = new NewsItemView(mAct);
        newsItemView.setInfo(info);
        newsItemView.getTxtDate().setVisibility(View.GONE);
        newsItemView.getTxtTitleType().setVisibility(View.GONE);
        linearLayout.addView(newsItemView);


        setLinearLayout2PAddView(linearLayout);

        TextView textView = ViewFactory.createNewTextView(mAct, info.mDate);
        textView.setBackgroundColor(Color.parseColor("#F0F0F0"));
        textView.setTextColor(Color.BLACK);
        setLinearLayout2PAddView(textView);

        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文內文"));

        ListView listView = new ListView(mAct);


        getLinearLayoutPortait2Have3();
        setContentView(bgReLayout);
    }
}
