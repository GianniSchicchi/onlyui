package com.appmaster;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.appmaster.adapter.AdapterListViewTxt;
import com.appmaster.data.InfoAnn;
import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity17MissionPrizeList extends ActivityGViewBar {

    List<InfoAnn> mAnnlist =  Collections.synchronizedList(new ArrayList<InfoAnn>());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFalseAnnInfo();
    }
    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }

    void addFalseAnnInfo() {
        if(mAnnlist != null) {
            for (int i = 0; i < 10; i++) {
                mAnnlist.add(new InfoAnn());
            }
        }
    }

    void setView() {
        setTitleStringView(true, "領獎中心");
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


        LinearLayout linearLayout = ViewLayoutFactory.createNewLinearLayoutHORIZONTAL(mAct);

        linearLayout.addView(ViewFactory.createNewButton(mAct, "系統", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
        );

        linearLayout.addView(ViewFactory.createNewButton(mAct, "活動", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }, Color.RED,Color.WHITE,3,Color.RED)
        );

        setLinearLayout2PAddView(linearLayout);


        ListView listView = new ListView(mAct);





        listView.setAdapter(new AdapterListViewTxt(this,mAnnlist));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(mAct, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        setLinearLayout2PAddView(listView);

        getLinearLayoutPortait2Have3();
        setContentView(bgReLayout);
    }
}
