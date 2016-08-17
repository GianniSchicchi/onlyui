package com.appmaster;

import android.app.Activity;
import android.app.Dialog;
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
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Gianni on 2016/8/15.
 */

public class ViewBar {

    public static int TITLEREATIVELAYOUT = 10;

    Activity mAct;
    RelativeLayout bgReLayout;
    LinearLayout linearLayout1;
    RelativeLayout contentRelaLayout;
    RelativeLayout titleReLayout;
    ImageView titleImgView;
    ImageView lineImgView;

    TextView titleTxtView;

    ImageButton leftImgBtn;
    ImageButton rightImgBtn;


    ViewBar(Activity activity) {
        mAct = activity;
        bgReLayout = new RelativeLayout(mAct);
        linearLayout1 = new LinearLayout(mAct);

        lineImgView = new ImageButton(mAct);

        titleReLayout = new RelativeLayout(mAct);

        contentRelaLayout = new RelativeLayout(mAct);
    }

    void setTitleLeftButton(boolean show, String imgName, View.OnClickListener onClickListener) {
        if (show) {
            if (leftImgBtn == null) {
                leftImgBtn = new ImageButton(mAct);
            }

            leftImgBtn.setBackgroundColor(Color.TRANSPARENT);
            leftImgBtn.setImageResource(R.mipmap.btn_back);
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

    void setTitleRightButton(boolean show, String imgName, View.OnClickListener onClickListener) {
        if (show) {
            if (rightImgBtn == null) {
                rightImgBtn = new ImageButton(mAct);
            }

            rightImgBtn.setBackgroundColor(Color.TRANSPARENT);
            rightImgBtn.setImageResource(R.mipmap.btn_close);
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

    void setTitleImgView(boolean show, String imgName) {
        titleImgView = new ImageButton(mAct);

        titleImgView.setBackgroundColor(Color.TRANSPARENT);
        titleImgView.setImageResource(R.mipmap.logo);

        RelativeLayout.LayoutParams center = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        center.addRule(RelativeLayout.CENTER_IN_PARENT, TITLEREATIVELAYOUT);

        titleImgView.setLayoutParams(center);

        titleReLayout.addView(titleImgView);
        setTitleReLayout(true);
    }

    void setTitleStringView(boolean show, String title) {
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

    void setTitleReLayout(boolean show) {
        if (show) {
            titleReLayout.setVisibility(View.VISIBLE);
        } else {
            titleReLayout.setVisibility(View.INVISIBLE);
        }

        RelativeLayout.LayoutParams setting = new RelativeLayout.LayoutParams(getScreenWidth(mAct) / 4 * 3,
                80);


        titleReLayout.setLayoutParams(setting);
//        titleReLayout.setGravity(Gravity.CENTER);
//        titleReLayout.setMinimumWidth(mWidth/2);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            titleReLayout.setBackground(setRadius(15, 15, 0, 0, Color.BLACK));
        }

    }

    void setBottomReLayout() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            contentRelaLayout.setBackground(setRadius(0, 0, 15, 15, Color.WHITE));
        }

    }

    GradientDrawable setRadius(float top_left_right, float bottom_left_right, int bgColor) {

        return setRadius(top_left_right, top_left_right, bottom_left_right, bottom_left_right, bgColor);
    }


    GradientDrawable setRadius(float top_left, float top_right, float bottom_left, float bottom_right, int bgColor) {
        return setRadius(top_left, top_right, bottom_left, bottom_right, bgColor, 0, bgColor);
    }


    GradientDrawable setRadius(float top_left, float top_right, float bottom_left, float bottom_right, int bgColor, int strokeWidth, int stroleColor) {
        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setColor(bgColor);
        float[] radius = {top_left, top_left, top_right, top_right, bottom_right, bottom_right, bottom_left, bottom_left};
        gdDefault.setCornerRadii(radius);
        gdDefault.setStroke(strokeWidth, stroleColor);

        return gdDefault;
    }




    void getView() {

        bgReLayout.setGravity(Gravity.CENTER);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getScreenWidth(mAct) * 3 / 4, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout1.setLayoutParams(layoutParams);


        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.addView(titleReLayout);

        lineImgView.setBackgroundColor(Color.RED);
        lineImgView.setMinimumHeight(1);
        lineImgView.setMaxHeight(1);

        lineImgView.setPadding(0,0,0,5);
        linearLayout1.addView(lineImgView);

        setBottomReLayout();
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


        return linearLayout;
    }

    View setTextView(Context context, String text) {
        TextView textView = new TextView(context);
        textView.setText(text);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 15, 5, 5);
        textView.setLayoutParams(layoutParams);

        return textView;
    }

    EditText setEditText(Context context, String hintText) {
        EditText editText = new EditText(context);
        editText.setHint(hintText);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 15, 5, 5);
        editText.setLayoutParams(layoutParams);

        return editText;
    }


    View setCheckBox(Context context, String text, CompoundButton.OnCheckedChangeListener checkedChangeListener) {
        CheckBox checkBox = new CheckBox(context);
        checkBox.setText(text);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 15, 5, 5);
        checkBox.setLayoutParams(layoutParams);

        checkBox.setDrawingCacheBackgroundColor(Color.RED);
        checkBox.setBackgroundColor(Color.WHITE);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);
        return checkBox;
    }

    View setButton(Context context, String text, View.OnClickListener clickListener) {
        return setButton(context, text, clickListener, Color.WHITE, Color.RED);
    }

    View setButton(Context context, String text, View.OnClickListener clickListener, int textColor, int bgColor) {
        Button button = new Button(context);
        button.setText(text);
        button.setTextColor(textColor);
        button.setOnClickListener(clickListener);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
        layoutParams.setMargins(15, 15, 5, 5);
        button.setLayoutParams(layoutParams);


        button.setBackgroundDrawable(setRadius(15, 15, 15, 15, bgColor));
        return button;
    }

    void setConfirmDialog(Context context, String text, View.OnClickListener cancelclickListener, View.OnClickListener okclickListener) {
        Dialog dialog = new Dialog(context);
        dialog.setCanceledOnTouchOutside(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        TextView textView1 = new TextView(context);
        textView1.setText("請確認是否使用");
        TextView textView2 = new TextView(context);
        textView2.setTextColor(Color.BLUE);
        textView2.setText(text);
        TextView textView3 = new TextView(context);
        textView3.setText("為您的會員帳號");
        textView1.setTextSize(20);
        textView2.setTextSize(20);
        textView3.setTextSize(20);

        Button cancelBtn = (Button) setButton(context, "取消", cancelclickListener, Color.RED, Color.WHITE);
        cancelBtn.setBackgroundDrawable(setRadius(15, 15, 15, 15, Color.WHITE, 3, Color.RED));

        Button okBtn = (Button) setButton(context, "確認", okclickListener, Color.WHITE, Color.RED);

        LinearLayout bglinLayout = new LinearLayout(context);
        bglinLayout.setOrientation(LinearLayout.VERTICAL);
        textView1.setGravity(Gravity.CENTER);
        textView2.setGravity(Gravity.CENTER);
        textView3.setGravity(Gravity.CENTER);
        bglinLayout.addView(textView1);
        bglinLayout.addView(textView2);
        bglinLayout.addView(textView3);

        LinearLayout linLayout = new LinearLayout(context);
        linLayout.setOrientation(LinearLayout.HORIZONTAL);

        linLayout.addView(cancelBtn);
        linLayout.addView(okBtn);

        bglinLayout.addView(linLayout);

        bglinLayout.setBackgroundDrawable(setRadius(15, 15, Color.WHITE));

        dialog.setContentView(bglinLayout);

        dialog.show();

    }


    void setViewPadding(View view, int left_right, int top_bottom) {
        setViewPadding(view, left_right, top_bottom, left_right, top_bottom);
    }

    void setViewPadding(View view, int left, int top, int right, int bottom) {
        int sizeInDp = 15;
        int dpAsPixels = getPixels(sizeInDp);

//        view.setPadding(dpAsPixels * left, dpAsPixels * top, dpAsPixels * right, dpAsPixels * bottom);
        view.setPadding(left, top, right, bottom);
//        return view;

    }


    int getPixels(int sizeInDp) {
        float scale = mAct.getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (sizeInDp * scale + 0.5f);
        return dpAsPixels;
    }


    int getScreenWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    int getScreenHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    int getScreenOrientation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        Log.e("GetWandH", "width:" + width + " , height:" + height);
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
