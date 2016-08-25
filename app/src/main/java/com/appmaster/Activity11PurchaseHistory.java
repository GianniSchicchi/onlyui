package com.appmaster;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.appmaster.adapter.AdapterListTable;
import com.appmaster.data.InfoPurchaseHistory;
import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity11PurchaseHistory extends ActivityGViewBar {

    List<InfoPurchaseHistory> mList = Collections.synchronizedList(new ArrayList<InfoPurchaseHistory>());


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
        if (mList != null) {
            for (int i = 0; i < 10; i++) {
                mList.add(new InfoPurchaseHistory());
            }
        }
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


        setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "僅供查詢近三個月內的購買記錄", Color.BLACK, 20));


        ListView listView = new ListView(mAct);


        listView.setAdapter(new AdapterListTable(this, mList));


        setLinearLayout2PAddView(listView);

        getLinearLayoutPortait2Have3();
        setContentView(bgReLayout);
    }
}
