package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity11PurchaseHistory extends AppCompatActivity {

    List<PurchaseHistoryInfo> mList =  Collections.synchronizedList(new ArrayList<PurchaseHistoryInfo>());

    Activity mAct;
    ViewBar viewBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;
        addFalseInfo();
    }
    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }

    void addFalseInfo() {
        if(mList != null) {
            for (int i = 0; i < 10; i++) {
                mList.add(new PurchaseHistoryInfo());
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



        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct,"僅供查詢近三個月內的購買記錄", Color.BLACK,20));


        ListView listView = new ListView(mAct);





        listView.setAdapter(new ListTableAdapter(this, mList));


        viewBar.setLinearLayout2PAddView(listView);

        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }
}
