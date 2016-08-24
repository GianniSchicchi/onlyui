package com.appmaster;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.appmaster.adapter.AdapterPayList;
import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity22PaymentList extends ActivityGViewBar {

    List<String> list =  Collections.synchronizedList(new ArrayList<String>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;

        addPayInfo();
        setView();

    }

    void addPayInfo() {
        if(list != null) {
            list.add("信用卡付款");
            list.add("ATM轉帳付款");
            list.add("全家條碼立即儲");
            list.add("電信帳單小額付款");
            list.add("X2GAME平台點數付款");
            list.add("支付寶付款");
            list.add("財富通付款");
            list.add("OMG行動遊戲卡");
            list.add("MyCard行動遊戲卡");

        }
    }

    void setView() {
        setTitleStringView(true, "請選擇付款方式");
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

//        setScrollEnable(true);
        newLinearLayout3();

        newLinearLayoutPortait2();


        LinearLayout linearLayout = ViewLayoutFactory.createNewLinearLayoutHORIZONTAL(mAct);

        linearLayout.addView(ViewFactory.createNewTextView(mAct,"購買", Color.WHITE,20,2,Color.parseColor("#981800"),false));

        TextView textView = ViewFactory.createNewTextView(mAct,"XXXX(NT$XXX)", Color.WHITE,20,1,Color.parseColor("#e52e2d"),false);
        textView.setGravity(Gravity.RIGHT);
        linearLayout.addView(textView);

        linearLayout1.addView(linearLayout);


        ListView listView = new ListView(mAct);





        listView.setAdapter(new AdapterPayList(this, list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(mAct, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        setLinearLayout2PAddView(listView);

        getLinearLayoutPortait2();
        setContentView(bgReLayout);
    }
}
