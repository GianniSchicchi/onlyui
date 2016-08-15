package com.appmaster;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Gianni on 2016/8/15.
 */

public class ViewBar {
    RelativeLayout  bgReLayout;
    LinearLayout  linearLayout1;
    RelativeLayout relativeLayout;
    ImageView titleImgView;
    ImageView       lineImgView;

    ViewBar(Context context) {
        bgReLayout = new RelativeLayout(context);
        linearLayout1 = new LinearLayout(context);
        relativeLayout = new RelativeLayout(context);
        titleImgView = new ImageButton(context);
        lineImgView = new ImageButton(context);
        bgReLayout.setGravity(Gravity.CENTER);

        linearLayout1.setOrientation(LinearLayout.VERTICAL);

        titleImgView.setBackgroundColor(Color.BLACK);
        titleImgView.setImageResource(R.mipmap.logo);
        linearLayout1.addView(titleImgView);

        lineImgView.setBackgroundColor(Color.RED);
        lineImgView.setMinimumHeight(1);
        lineImgView.setMaxHeight(1);
        linearLayout1.addView(lineImgView);
    }

}
