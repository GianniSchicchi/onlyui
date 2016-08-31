package com.appmaster.tools;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.appmaster.AMResourceWrapper;

/**
 * Created by Gianni on 2016/8/15.
 */

public class ActivityGViewBar extends FragmentActivity {

    public static int TITLEREATIVELAYOUT = 10;

    public Activity mAct;
    public RelativeLayout bgReLayout;
    public LinearLayout linearLayout1;

    public ScrollView scrollView;
    public RelativeLayout contentRelaLayout;
    public RelativeLayout titleReLayout;
    public ImageView titleImgView;
    public ImageView lineImgView;

    public TextView titleTxtView;

    public ImageButton leftImgBtn;
    public ImageButton rightImgBtn;


    public LinearLayout linearLayout2P;
    public LinearLayout linearLayout3L;

    public boolean scrollEnable = false;


    public void setScrollEnable(boolean enable) {
        scrollEnable = enable;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;
        bgReLayout = new RelativeLayout(mAct);
        linearLayout1 = new LinearLayout(mAct);

        lineImgView = new ImageView(mAct);

        titleReLayout = new RelativeLayout(mAct);

        scrollView = new ScrollView(mAct);
        contentRelaLayout = new RelativeLayout(mAct);

    }


    public void setTitleLeftButton(boolean show, String imgName, View.OnClickListener onClickListener) {
        if (show) {
            if (leftImgBtn == null) {
                leftImgBtn = new ImageButton(mAct);
            }

            leftImgBtn.setBackgroundColor(Color.TRANSPARENT);
            leftImgBtn.setImageBitmap(AMResourceWrapper.getInstance().getBitmap(mAct, "btn_back"));
            leftImgBtn.setOnClickListener(onClickListener);
        } else {

        }

        titleReLayout.setId(TITLEREATIVELAYOUT);
        RelativeLayout.LayoutParams left = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        left.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TITLEREATIVELAYOUT);

        left.setMargins(15, 0, 0, 0);
        leftImgBtn.setLayoutParams(left);
        titleReLayout.addView(leftImgBtn);

    }

    public void setTitleRightButton(boolean show, String imgName, View.OnClickListener onClickListener) {
        if (show) {
            if (rightImgBtn == null) {
                rightImgBtn = new ImageButton(mAct);
            }

            rightImgBtn.setBackgroundColor(Color.TRANSPARENT);
            rightImgBtn.setImageBitmap(AMResourceWrapper.getInstance().getBitmap(mAct, "btn_close"));
            rightImgBtn.setOnClickListener(onClickListener);
        } else {

        }

        titleReLayout.setId(TITLEREATIVELAYOUT);
        RelativeLayout.LayoutParams left = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        left.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TITLEREATIVELAYOUT);

        left.setMargins(0, 0, 15, 0);
        rightImgBtn.setLayoutParams(left);
        titleReLayout.addView(rightImgBtn);

    }

    public void setTitleImgView(boolean show, String imgName) {
        titleImgView = new ImageButton(mAct);

        titleImgView.setBackgroundColor(Color.TRANSPARENT);
        titleImgView.setImageBitmap(AMResourceWrapper.getInstance().getBitmap(mAct, "logo"));

        RelativeLayout.LayoutParams center = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        center.addRule(RelativeLayout.CENTER_IN_PARENT, TITLEREATIVELAYOUT);

        titleImgView.setLayoutParams(center);

        titleReLayout.addView(titleImgView);
        setTitleReLayout(true);
    }

    public void setTitleStringView(boolean show, String title) {
        if (show) {
            if (title != null) {
                if (titleTxtView == null) {
                    titleTxtView = new TextView(mAct);
                }
                titleTxtView.setGravity(Gravity.CENTER);
                titleTxtView.setTextColor(Color.RED);
                titleTxtView.setTextSize(40);
                titleTxtView.setText(title);
            }
        }
        setTitleReLayout(true);

        RelativeLayout.LayoutParams center = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        center.addRule(RelativeLayout.CENTER_IN_PARENT, TITLEREATIVELAYOUT);

        titleTxtView.setLayoutParams(center);
        titleReLayout.addView(titleTxtView);


    }

    public void setTitleReLayout(boolean show) {
        if (show) {
            titleReLayout.setVisibility(View.VISIBLE);
        } else {
            titleReLayout.setVisibility(View.INVISIBLE);
        }

        RelativeLayout.LayoutParams setting = new RelativeLayout.LayoutParams(getScreenWidth(mAct) / 4 * 3,
                80);


        titleReLayout.setLayoutParams(setting);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            titleReLayout.setBackground(ViewFactory.setRadius(15, 15, 0, 0, Color.BLACK));
        }

    }

    public void setBottomReLayout() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            contentRelaLayout.setBackground(ViewFactory.setRadius(0, 0, 15, 15, Color.WHITE));
        }

    }


    public void getView() {

        bgReLayout.setGravity(Gravity.CENTER);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getScreenWidth(mAct) * 3 / 4, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout1.setLayoutParams(layoutParams);


        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.addView(titleReLayout);

        lineImgView.setBackgroundColor(Color.RED);
        lineImgView.setMinimumHeight(1);
        lineImgView.setMaxHeight(1);

        lineImgView.setPadding(0, 0, 0, 5);
        linearLayout1.addView(lineImgView);

        setBottomReLayout();


    }


    public void getLinearLayoutPortait2() {

        if (scrollEnable) {
            scrollView.addView(linearLayout2P);
            contentRelaLayout.addView(scrollView);
            linearLayout1.addView(contentRelaLayout);
        } else {
            contentRelaLayout.addView(linearLayout2P);
            linearLayout1.addView(contentRelaLayout);
        }

        bgReLayout.addView(linearLayout1);

    }

    public void getLinearLayoutPortait2Have3() {

        linearLayout2P.addView(linearLayout3L);

        getLinearLayoutPortait2();

    }

    public void setContentRelaLayoutAddView(View view) {
        contentRelaLayout.addView(view);
    }


    public void setLinearLayout2PAddView(View view) {

        linearLayout2P.addView(view);
    }

    public void newLinearLayoutPortait2() {

        linearLayout2P = new LinearLayout(mAct);

        LinearLayout.LayoutParams setting2 = new LinearLayout.LayoutParams(getScreenWidth(mAct) * 3 / 4,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        setting2.setMargins(20, 20, 20, 20);

        linearLayout2P.setVerticalScrollBarEnabled(true);
        linearLayout2P.setLayoutParams(setting2);

        linearLayout2P.setOrientation(LinearLayout.VERTICAL);

        linearLayout2P.setGravity(Gravity.CENTER);

    }


    public void setScreenChange(LinearLayout linearLayout) {
        int iScreenOrientation = ViewFactory.getScreenOrientation(mAct);
        if (iScreenOrientation == 0 || iScreenOrientation == 8) {
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams setting = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            linearLayout.setLayoutParams(setting);
        } else {
            linearLayout.setOrientation(LinearLayout.VERTICAL);
        }
    }

    public void newLinearLayout3() {
        linearLayout3L = new LinearLayout(mAct);
        linearLayout3L.setGravity(Gravity.CENTER);
    }


    public void setLinearLayout3AddView(View view) {

        linearLayout3L.addView(view);
    }


    public void setViewPadding(View view, int left, int top, int right, int bottom) {
        view.setPadding(left, top, right, bottom);

    }


    int getPixels(int sizeInDp) {
        float scale = mAct.getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (sizeInDp * scale + 0.5f);
        return dpAsPixels;
    }


    public int getScreenWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }


}
