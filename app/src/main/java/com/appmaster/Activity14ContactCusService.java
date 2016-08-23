package com.appmaster;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appmaster.tools.ViewBar;
import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

public class Activity14ContactCusService extends AppCompatActivity {

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
        viewBar.setTitleStringView(true, "聯繫客服");
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

        viewBar.setScrollEnable(true);
        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();


        LinearLayout linearLayout = ViewLayoutFactory.createNewLinearLayoutHORIZONTAL(mAct);

        linearLayout.addView(ViewFactory.createNewTextView(mAct,"客服回覆", Color.WHITE,20,2,Color.parseColor("#981800"),false));

        TextView textView = (TextView) ViewFactory.createNewTextView(mAct,"2015-7-02", Color.WHITE,20,1,Color.parseColor("#e52e2d"),false);
        textView.setGravity(Gravity.RIGHT);
        linearLayout.addView(textView);

        viewBar.linearLayout1.addView(linearLayout);


        viewBar.setLinearLayout2PAddView(ViewFactory.createNewTextView(mAct, "回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容回復內容"));

        viewBar.getLinearLayoutPortait2();
        setContentView(viewBar.bgReLayout);
    }
}
