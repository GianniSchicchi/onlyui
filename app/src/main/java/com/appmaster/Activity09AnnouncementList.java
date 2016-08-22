package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity09AnnouncementList extends AppCompatActivity {


    List<InfoAnn> mAnnlist =  Collections.synchronizedList(new ArrayList<InfoAnn>());

    Activity mAct;
    ViewBar viewBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;
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
        viewBar = new ViewBar(mAct);
        viewBar.setTitleStringView(true, "公告訊息");
        viewBar.setTitleLeftButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewBar.setTitleRightButton(true, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewBar.getView();

        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();


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

        viewBar.setLinearLayout2PAddView(linearLayout);


        ListView listView = new ListView(mAct);





        listView.setAdapter(new AdapterListViewTxt(this,mAnnlist));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(mAct, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        viewBar.setLinearLayout2PAddView(listView);

        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }
}
