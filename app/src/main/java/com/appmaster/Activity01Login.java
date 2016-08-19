package com.appmaster;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Activity01Login extends AppCompatActivity {


    View     guestView;
    View     registerView;
    View     fbView;
    View     gplusView;

    Activity mAct;
    ViewBar viewBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;
    }
    @Override
    protected void onResume() {
        super.onResume();
        setView();
    }
    void setView() {
        viewBar = new ViewBar(mAct);
        viewBar.setTitleImgView(true,"logo");
        viewBar.getView();

        viewBar.newLinearLayout3();

        viewBar.newLinearLayoutPortait2();

        viewBar.setScreenChange(viewBar.linearLayout3L);


        guestView = viewBar.setImageView(mAct,"遊客體驗","1",new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        registerView = viewBar.setImageView(mAct, "登入註冊", "2", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mAct,Activity02Register.class);
                startActivity(intent);
            }
        });
        fbView = viewBar.setImageView(mAct,"Facebook","3",new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gplusView = viewBar.setImageView(mAct,"Google","4",new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        LinearLayout layout1 = viewBar.newLinearLayoutHORIZONTAL();
        layout1.addView(guestView);
        layout1.addView(registerView);

        viewBar.setLinearLayout3AddView(layout1);

        LinearLayout layout2 = viewBar.newLinearLayoutHORIZONTAL();
        layout2.addView(fbView);
        layout2.addView(gplusView);

        viewBar.setLinearLayout3AddView(layout2);


        viewBar.getLinearLayoutPortait2Have3();
        setContentView(viewBar.bgReLayout);
    }



}
