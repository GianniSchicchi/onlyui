package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity12ContactCustomerService extends AppCompatActivity {

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


        LinearLayout linearLayout = viewBar.newLinearLayoutHORIZONTAL();

        linearLayout.addView(viewBar.setButton(mAct, "問題回報", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
        );

        linearLayout.addView(viewBar.setButton(mAct, "回報記錄", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }, Color.RED,Color.WHITE,3,Color.RED)
        );

        viewBar.setLinearLayout2PAddView(linearLayout);


        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "若您遇到任何問題，請隨時與我們聯繫！\n我們會儘快回覆您的問題，回覆內容請至「回報記錄」查看。"));
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "\n聯絡電話"));
        viewBar.setLinearLayout2PAddView(viewBar.setEditText(mAct, "請填入市話或手機號碼"));
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "E-mail"));
        viewBar.setLinearLayout2PAddView(viewBar.setEditText(mAct, "請填入電子郵件"));
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "問題類型"));
        viewBar.setLinearLayout2PAddView(viewBar.setEditText(mAct, "請選擇問題類型"));
        viewBar.setLinearLayout2PAddView(viewBar.setTextView(mAct, "問題描述"));
        viewBar.setLinearLayout2PAddView(viewBar.setEditText(mAct, "請清楚的簡述您的問題"));
        viewBar.setLinearLayout2PAddView(viewBar.setButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }
}
