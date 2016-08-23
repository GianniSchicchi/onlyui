package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.appmaster.tools.ViewBar;
import com.appmaster.tools.ViewFactory;

public class Activity15ChangePWD extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;

        setView();

    }


    void setView() {
        viewBar = new ViewBar(mAct);
        viewBar.setTitleStringView(true, "修改密碼");
        viewBar.getView();

        viewBar.setScrollEnable(true);
        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();




        viewBar.setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "臨時密碼",Color.BLACK));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewEditText(mAct, "請輸入臨時密碼"));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "新密碼",Color.BLACK));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewEditText(mAct, "請設定6-20英數字組合"));

        TextView textView = (TextView)ViewFactory.createNewTextView(mAct, "(不可使用特殊字元)");
        textView.setTextSize(10);
        textView.setGravity(Gravity.RIGHT);
        viewBar.setLinearLayout2PAddView(textView);
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "確認新密碼",Color.BLACK));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewEditText(mAct, "請再次輸入新密碼"));
        viewBar.setLinearLayout2PAddView(ViewFactory.createNewButton(mAct, "確認送出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }
}
