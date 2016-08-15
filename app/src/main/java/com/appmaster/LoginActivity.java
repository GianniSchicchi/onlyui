package com.appmaster;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;

    //    RelativeLayout  bgReLayout;
//    LinearLayout  linearLayout1;
//    RelativeLayout relativeLayout;
    LinearLayout  linearLayout2;
    LinearLayout  linearLayout3;

//    ImageView       titleImgView;
//    ImageView       lineImgView;

    View     guestView;
    View     registerView;
    View     fbView;
    View     gplusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAct = this;
        Log.d("Unity - AMGameBarView", "switch btn to ambtn_new");

        setView();

//        AMResourceWrapper.getInstance().setImageResource(act, mStartBtn, "ambtn_new");

    }

    @Override
    protected void onResume() {
        super.onResume();
        setView();

    }


    void setView() {
        setLoginViewLayout(this);
        int iScreenOrientation = ViewBar.getScreenOrientation(mAct);
        if(iScreenOrientation == 0 || iScreenOrientation == 8) {
            setLoginViewLayoutLandscape();
        }else {
            setLoginViewLayoutPortait();
        }
        setClickListener();
    }

    void setClickListener() {
        guestView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        registerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mAct,RegisterActivity.class);
                startActivityForResult(intent,0);

            }
        });
        fbView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gplusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    void setLoginViewLayout(Context context) {
        viewBar = new ViewBar(context);
        viewBar.setTitleImgView(true,"logo");
        viewBar.getView();

        linearLayout2 = new LinearLayout(context);
        linearLayout3 = new LinearLayout(context);
        guestView = viewBar.setImageView(context,"遊客體驗","1");
        registerView = viewBar.setImageView(context,"登入註冊","2");
        fbView = viewBar.setImageView(context,"Facebook","3");
        gplusView = viewBar.setImageView(context,"Google","4");

        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout3.setOrientation(LinearLayout.HORIZONTAL);


    }

    void setLoginViewLayoutPortait() {


        linearLayout2.addView(guestView);
        linearLayout2.addView(registerView);

        linearLayout3.addView(fbView);
        linearLayout3.addView(gplusView);

        viewBar.relativeLayout.setId(1);
        linearLayout2.setId(2);
        linearLayout3.setId(3);
        RelativeLayout.LayoutParams up = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams down = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        up.addRule(RelativeLayout.BELOW, 1);
        linearLayout2.setLayoutParams(up);


        down.addRule(RelativeLayout.BELOW,2);
        linearLayout3.setLayoutParams(down);

        viewBar.setViewPadding(linearLayout2,2,0);
        viewBar.setViewPadding(linearLayout3,2,0);

        viewBar.relativeLayout.addView(linearLayout2);
        viewBar.relativeLayout.addView(linearLayout3);

        viewBar.linearLayout1.addView(viewBar.relativeLayout);


        viewBar.bgReLayout.addView(viewBar.linearLayout1);

        setContentView(viewBar.bgReLayout);

    }

    void setLoginViewLayoutLandscape() {

        linearLayout2.addView(guestView);
        linearLayout2.addView(registerView);
        linearLayout2.addView(fbView);
        linearLayout2.addView(gplusView);

        viewBar.relativeLayout.setId(1);
        linearLayout2.setId(2);
        RelativeLayout.LayoutParams up = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        up.addRule(RelativeLayout.BELOW, 1);
        linearLayout2.setLayoutParams(up);

        viewBar.setViewPadding(linearLayout2,2,0);

        viewBar.relativeLayout.addView(linearLayout2);

        viewBar.linearLayout1.addView(viewBar.relativeLayout);


        viewBar.bgReLayout.addView(viewBar.linearLayout1);

        setContentView(viewBar.bgReLayout);
    }



}
