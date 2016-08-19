package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity09AnnouncementList extends AppCompatActivity {


    List<AnnInfo> mAnnlist =  Collections.synchronizedList(new ArrayList<AnnInfo>());

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
                mAnnlist.add(new AnnInfo());
            }
        }
    }

    void setView() {
        viewBar = new ViewBar(mAct);
        viewBar.setTitleStringView(true, "公告訊息");
        viewBar.setTitleLeftButton(true, "", null);
        viewBar.setTitleRightButton(true, "", null);
        viewBar.getView();

        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();




        TableLayoutPurchaseHistory tableLayoutPurchaseHistory = new TableLayoutPurchaseHistory(mAct);
        tableLayoutPurchaseHistory.init();

        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct,"僅供查詢近三個月內的購買記錄"));




        viewBar.setLinearLayout2PAddView(tableLayoutPurchaseHistory.getTableLayout());

        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }



}
