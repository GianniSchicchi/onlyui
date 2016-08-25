package com.appmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.appmaster.tools.ActivityGViewBar;
import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

public class Activity01Login extends ActivityGViewBar {


    View guestView;
    View registerView;
    View fbView;
    View gplusView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }

    void setView() {
        setTitleImgView(true, "logo");
        getView();

        newLinearLayout3();

        newLinearLayoutPortait2();

        setScreenChange(linearLayout3L);


        guestView = ViewFactory.createNewImageView(mAct, "遊客體驗", "1", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        registerView = ViewFactory.createNewImageView(mAct, "登入註冊", "2", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mAct, Activity02Register.class);
                startActivity(intent);
            }
        });
        fbView = ViewFactory.createNewImageView(mAct, "Facebook", "3", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gplusView = ViewFactory.createNewImageView(mAct, "Google", "4", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        LinearLayout layout1 = ViewLayoutFactory.createNewLinearLayoutHORIZONTAL(mAct);
        layout1.addView(guestView);
        layout1.addView(registerView);

        setLinearLayout3AddView(layout1);

        LinearLayout layout2 = ViewLayoutFactory.createNewLinearLayoutHORIZONTAL(mAct);
        layout2.addView(fbView);
        layout2.addView(gplusView);

        setLinearLayout3AddView(layout2);


        getLinearLayoutPortait2Have3();
        setContentView(bgReLayout);
    }


}
