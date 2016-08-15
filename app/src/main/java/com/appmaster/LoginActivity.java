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
        if(getScreenOrientation() == 0 || getScreenOrientation() == 8) {
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
        bgReLayout = new RelativeLayout(context);
        linearLayout1 = new LinearLayout(context);
        relativeLayout = new RelativeLayout(context);
        linearLayout2 = new LinearLayout(context);
        linearLayout3 = new LinearLayout(context);
        titleImgView = new ImageButton(context);
        lineImgView = new ImageButton(context);
        guestView = setImageView(context,"遊客體驗","1");
        registerView = setImageView(context,"登入註冊","2");
        fbView = setImageView(context,"Facebook","3");
        gplusView = setImageView(context,"Google","4");
        bgReLayout.setGravity(Gravity.CENTER);

        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout3.setOrientation(LinearLayout.HORIZONTAL);

        titleImgView.setBackgroundColor(Color.BLACK);
        titleImgView.setImageResource(R.mipmap.logo);
        linearLayout1.addView(titleImgView);

        lineImgView.setBackgroundColor(Color.RED);
        lineImgView.setMinimumHeight(getPixels(0));
        lineImgView.setMaxHeight(getPixels(0));
        linearLayout1.addView(lineImgView);

    }

    void setLoginViewLayoutPortait() {


        linearLayout2.addView(guestView);
        linearLayout2.addView(registerView);

        linearLayout3.addView(fbView);
        linearLayout3.addView(gplusView);

        relativeLayout.setId(1);
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

        setViewPadding(linearLayout2,2,0);
        setViewPadding(linearLayout3,2,0);

        relativeLayout.addView(linearLayout2);
        relativeLayout.addView(linearLayout3);

        linearLayout1.addView(relativeLayout);


        bgReLayout.addView(linearLayout1);

        setContentView(bgReLayout);

    }

    void setLoginViewLayoutLandscape() {

        linearLayout2.addView(guestView);
        linearLayout2.addView(registerView);
        linearLayout2.addView(fbView);
        linearLayout2.addView(gplusView);

        relativeLayout.setId(1);
        linearLayout2.setId(2);
        RelativeLayout.LayoutParams up = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        up.addRule(RelativeLayout.BELOW, 1);
        linearLayout2.setLayoutParams(up);

        setViewPadding(linearLayout2,2,0);

        relativeLayout.addView(linearLayout2);

        linearLayout1.addView(relativeLayout);


        bgReLayout.addView(linearLayout1);

        setContentView(bgReLayout);
    }

    void setViewPadding(View view,int left_right, int top_bottom) {
        setViewPadding(view,left_right,top_bottom,left_right,top_bottom);
    }

    void setViewPadding(View view,int left, int top, int right, int bottom) {
        int sizeInDp = 15;
        int dpAsPixels = getPixels(sizeInDp);

        view.setPadding(dpAsPixels * left,dpAsPixels * top,dpAsPixels * right,dpAsPixels * bottom);
//        return view;

    }

    int getPixels(int sizeInDp) {
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (sizeInDp*scale + 0.5f);
        return  dpAsPixels;
    }


    View setImageView(Context context, String text, String imageName) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        ImageView     imageView = new ImageView(context);
        TextView    textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);

        if(imageName.equals("1")) {
            imageView.setImageResource(R.mipmap.icon_1);
        }
        if(imageName.equals("2")) {
            imageView.setImageResource(R.mipmap.icon_2);
        }
        if(imageName.equals("3")) {
            imageView.setImageResource(R.mipmap.icon_4);
        }
        if(imageName.equals("4")) {
            imageView.setImageResource(R.mipmap.icon_5);
        }

        linearLayout.addView(imageView);
        linearLayout.addView(textView);


        setViewPadding(linearLayout,1,1);
        return linearLayout;
    }


    private int getScreenOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int orientation;
        // if the device's natural orientation is portrait:
        if ((rotation == Surface.ROTATION_0
                || rotation == Surface.ROTATION_180) && height > width ||
                (rotation == Surface.ROTATION_90
                        || rotation == Surface.ROTATION_270) && width > height) {
            switch(rotation) {
                case Surface.ROTATION_0:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                    break;
                case Surface.ROTATION_90:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                    break;
                case Surface.ROTATION_180:
                    orientation =
                            ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                    break;
                case Surface.ROTATION_270:
                    orientation =
                            ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                    break;
                default:
                    Log.d("Unity - AMLoginView", "Unknown screen orientation. Defaulting to " +
                            "portrait.");
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                    break;
            }
        }
        // if the device's natural orientation is landscape or if the device
        // is square:
        else {
            switch(rotation) {
                case Surface.ROTATION_0:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                    break;
                case Surface.ROTATION_90:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                    break;
                case Surface.ROTATION_180:
                    orientation =
                            ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                    break;
                case Surface.ROTATION_270:
                    orientation =
                            ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                    break;
                default:
                    Log.d("Unity - AMLoginView", "Unknown screen orientation. Defaulting to " +
                            "landscape.");
                    orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                    break;
            }
        }

        return orientation;
    }
}
