package com.appmaster;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Gianni on 2016/8/15.
 */

public class ViewBar {
    Context mContext;
    RelativeLayout bgReLayout;
    LinearLayout linearLayout1;
    RelativeLayout relativeLayout;
    RelativeLayout titleReLayout;
    ImageView titleImgView;
    ImageView lineImgView;

    TextView titleTxtView;

    ImageButton leftImgBtn;
    ImageButton rightImgBtn;

    ViewBar(Context context) {
        mContext = context;
        bgReLayout = new RelativeLayout(mContext);
        linearLayout1 = new LinearLayout(mContext);
        relativeLayout = new RelativeLayout(mContext);
        lineImgView = new ImageButton(mContext);

        titleReLayout = new RelativeLayout(mContext);
    }

    void setTitleLeftButton(boolean show, String imgName, View.OnClickListener onClickListener) {
        if (show) {
            if (leftImgBtn == null) {
                leftImgBtn = new ImageButton(mContext);
            }

            leftImgBtn.setImageResource(R.mipmap.btn_back);
            leftImgBtn.setOnClickListener(onClickListener);
        } else {

        }

    }

    void setTitleRightButton(boolean show, String imgName, View.OnClickListener onClickListener) {

    }

    void setTitleImgView(boolean show, String imgName) {
        titleImgView = new ImageButton(mContext);

        titleImgView.setBackgroundColor(Color.TRANSPARENT);
        titleImgView.setImageResource(R.mipmap.logo);


        titleReLayout.addView(titleImgView);
        setTitleReLayout(true);
    }

    void setTitleStringView(boolean show, String title) {
        if(show) {
            if(title != null) {
                if(titleTxtView == null) {
                    titleTxtView = new TextView(mContext);
                }
                titleTxtView.setGravity(Gravity.CENTER);
                titleTxtView.setTextColor(Color.RED);
                titleTxtView.setTextSize(40);
                titleTxtView.setText(title);
            }
        }
        setTitleReLayout(true);
        titleReLayout.addView(titleTxtView);


    }

    void setTitleReLayout(boolean show) {
        if (show) {
            titleReLayout.setVisibility(View.VISIBLE);
        } else {
            titleReLayout.setVisibility(View.INVISIBLE);
        }

        RelativeLayout.LayoutParams setting = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                80);

        titleReLayout.setLayoutParams(setting);
        titleReLayout.setGravity(Gravity.CENTER);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            titleReLayout.setBackground(setRadius(15,15,0,0));
        }

    }


    GradientDrawable setRadius(float top_left,float top_right,float bottom_right, float bottom_left) {
        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setColor(Color.BLACK);
        float[] radius = {top_left,top_left,top_right,top_right,bottom_right,bottom_right,bottom_left,bottom_left};
        gdDefault.setCornerRadii(radius);
        gdDefault.setStroke(3, Color.BLACK);
        return gdDefault;
    }


    void getView() {

        bgReLayout.setGravity(Gravity.CENTER);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.addView(titleReLayout);

        lineImgView.setBackgroundColor(Color.RED);
        lineImgView.setMinimumHeight(1);
        lineImgView.setMaxHeight(1);
        linearLayout1.addView(lineImgView);
    }


    View setImageView(Context context, String text, String imageName) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        ImageView imageView = new ImageView(context);
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);

        if (imageName.equals("1")) {
            imageView.setImageResource(R.mipmap.icon_1);
        }
        if (imageName.equals("2")) {
            imageView.setImageResource(R.mipmap.icon_2);
        }
        if (imageName.equals("3")) {
            imageView.setImageResource(R.mipmap.icon_4);
        }
        if (imageName.equals("4")) {
            imageView.setImageResource(R.mipmap.icon_5);
        }

        linearLayout.addView(imageView);
        linearLayout.addView(textView);


        setViewPadding(linearLayout, 1, 1);
        return linearLayout;
    }

    void setViewPadding(View view, int left_right, int top_bottom) {
        setViewPadding(view, left_right, top_bottom, left_right, top_bottom);
    }

    void setViewPadding(View view, int left, int top, int right, int bottom) {
        int sizeInDp = 15;
        int dpAsPixels = getPixels(sizeInDp);

        view.setPadding(dpAsPixels * left, dpAsPixels * top, dpAsPixels * right, dpAsPixels * bottom);
//        return view;

    }

    int getPixels(int sizeInDp) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (sizeInDp * scale + 0.5f);
        return dpAsPixels;
    }


    public static int getScreenOrientation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int orientation;
        // if the device's natural orientation is portrait:
        if ((rotation == Surface.ROTATION_0
                || rotation == Surface.ROTATION_180) && height > width ||
                (rotation == Surface.ROTATION_90
                        || rotation == Surface.ROTATION_270) && width > height) {
            switch (rotation) {
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
            switch (rotation) {
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
