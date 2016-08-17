package com.appmaster;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LoginActivity extends AppCompatActivity {

    Activity mAct;
    ViewBar viewBar;

    LinearLayout  linearLayout2;
    LinearLayout  linearLayout3;

    View     guestView;
    View     registerView;
    View     fbView;
    View     gplusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAct = this;
        Log.d("Unity - AMGameBarView", "switch btn to ambtn_new");


//        AMResourceWrapper.getInstance().setImageResource(act, mStartBtn, "ambtn_new");

    }

    @Override
    protected void onResume() {
        super.onResume();
        setView();

    }


    void setView() {
        setLoginViewLayout(this);
        int iScreenOrientation = viewBar.getScreenOrientation(mAct);
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

    void setLoginViewLayout(Activity activity) {
        viewBar = new ViewBar(activity);
//        viewBar.setTitleImgView(true,"logo");
        viewBar.setTitleStringView(true,"登入 / 註冊");
        viewBar.setTitleLeftButton(true,"",null);
        viewBar.setTitleRightButton(true,"",null);

        viewBar.getView();

        linearLayout2 = new LinearLayout(activity);
        linearLayout3 = new LinearLayout(activity);
        guestView = viewBar.setImageView(activity,"遊客體驗","1");
        registerView = viewBar.setImageView(activity,"登入註冊","2");
        fbView = viewBar.setImageView(activity,"Facebook","3");
        gplusView = viewBar.setImageView(activity,"Google","4");

        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout3.setOrientation(LinearLayout.HORIZONTAL);


    }

    void setLoginViewLayoutPortait() {


        linearLayout2.addView(guestView);
        linearLayout2.addView(registerView);

        linearLayout3.addView(fbView);
        linearLayout3.addView(gplusView);

        viewBar.contentRelaLayout.setId(1);
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

        viewBar.contentRelaLayout.addView(linearLayout2);
        viewBar.contentRelaLayout.addView(linearLayout3);

        viewBar.linearLayout1.addView(viewBar.contentRelaLayout);


        viewBar.bgReLayout.addView(viewBar.linearLayout1);

        setContentView(viewBar.bgReLayout);

    }

    void setLoginViewLayoutLandscape() {

        linearLayout2.addView(guestView);
        linearLayout2.addView(registerView);
        linearLayout2.addView(fbView);
        linearLayout2.addView(gplusView);

        viewBar.contentRelaLayout.setId(1);
        linearLayout2.setId(2);
        RelativeLayout.LayoutParams up = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        up.addRule(RelativeLayout.BELOW, 1);
        linearLayout2.setLayoutParams(up);

        viewBar.setViewPadding(linearLayout2,2,0);


        viewBar.contentRelaLayout.addView(linearLayout2);

        viewBar.linearLayout1.addView(viewBar.contentRelaLayout);


        viewBar.bgReLayout.addView(viewBar.linearLayout1);

        setContentView(viewBar.bgReLayout);
    }



}
