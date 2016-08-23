package com.appmaster.tools;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appmaster.R;

/**
 * Created by Gianni on 2016/8/22.
 */

public class ViewFactory {

    public static GradientDrawable setRadius(float top_left_right, float bottom_left_right, int bgColor) {

        return setRadius(top_left_right, top_left_right, bottom_left_right, bottom_left_right, bgColor);
    }


    public static GradientDrawable setRadius(float top_left, float top_right, float bottom_left, float bottom_right, int bgColor) {
        return setRadius(top_left, top_right, bottom_left, bottom_right, bgColor, 0, bgColor);
    }


    public static GradientDrawable setRadius(float top_left, float top_right, float bottom_left, float bottom_right, int bgColor, int strokeWidth, int stroleColor) {
        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setColor(bgColor);
        float[] radius = {top_left, top_left, top_right, top_right, bottom_right, bottom_right, bottom_left, bottom_left};
        gdDefault.setCornerRadii(radius);
        gdDefault.setStroke(strokeWidth, stroleColor);

        return gdDefault;
    }


    public static ImageView createNewLineImageView(Context context) {
        ImageView newImageView = new ImageView(context);
        newImageView.setBackgroundColor(Color.BLACK);
        newImageView.setMinimumHeight(1);
        newImageView.setMaxHeight(1);
        newImageView.setPadding(0, 0, 0, 5);
        return newImageView;
    }


    public static View createNewImageButton(Context context, String text, String imageName, View.OnClickListener listener) {

        RelativeLayout layout = new RelativeLayout(context);
        layout.setGravity(Gravity.LEFT);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(25, 5, 25, 5);

        ImageView imageView = new ImageView(context);

        imageView.setLayoutParams(layoutParams);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 60, Gravity.CENTER);
        imageView.setLayoutParams(params);
        imageView.setPadding(25,10,0,0);

        TextView textView = createNewTextView(context,text);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(25);
        textView.setPadding(175,10,0,0);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setLayoutParams(layoutParams);



        Button button = createNewButton(context, "" ,listener);

        button.setLayoutParams(layoutParams);

        if (imageName.equals("1")) {
            imageView.setImageResource(R.mipmap.icon_14);
        }
        if (imageName.equals("2")) {
            imageView.setImageResource(R.mipmap.icon_15);
        }
        if (imageName.equals("3")) {
            imageView.setImageResource(R.mipmap.icon_16);
        }
        if (imageName.equals("4")) {
            imageView.setImageResource(R.mipmap.icon_17);
        }
        if (imageName.equals("5")) {
            imageView.setImageResource(R.mipmap.icon_18);
        }



        layout.addView(button);
        layout.addView(imageView);
        layout.addView(textView);
        layout.setLayoutParams(layoutParams);

        return layout;
    }


    public static View createNewImageView(Context context, String text, String imageName, View.OnClickListener listener) {


        return createNewImageView(context, text, imageName, listener, LinearLayout.VERTICAL);
    }


    public static View createNewImageView(Context context, String text, String imageName, View.OnClickListener listener, int iOrientation) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(iOrientation);
        linearLayout.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams layoutParams;
        if (iOrientation == LinearLayout.HORIZONTAL) {
            layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        layoutParams.setMargins(15, 15, 15, 15);
        linearLayout.setLayoutParams(layoutParams);
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
        if (imageName.equals("5")) {
            imageView.setImageResource(R.mipmap.icon_3);
        }
        if (imageName.equals("6")) {
            imageView.setImageResource(R.mipmap.icon_6);
        }


        linearLayout.addView(imageView);
        linearLayout.addView(textView);

        linearLayout.setOnClickListener(listener);

        return linearLayout;
    }

    public static TextView createNewTextView(Context context, String text) {

        return createNewTextView(context, text, Color.GRAY);
    }

    public static TextView createNewTextView(Context context, String text, int textColor) {
        return createNewTextView(context, text, textColor, 5566);
    }

    public static TextView createNewTextView(Context context, String text, int textColor, int bgColor) {
        return createNewTextView(context, text, textColor, 5566, 5566, bgColor, true);
    }

    public static TextView createNewTextView(Context context, String text, int textColor, float txtSize) {
        return createNewTextView(context, text, textColor, txtSize, 5566);
    }

    public static TextView createNewTextView(Context context, String text, int textColor, float txtSize, int weight) {
        return createNewTextView(context, text, textColor, txtSize, weight, 5566);
    }

    public static TextView createNewTextView(Context context, String text, int textColor, float txtSize, int weight, int bgColor) {
        return createNewTextView(context, text, textColor, txtSize, weight, bgColor, true);
    }

    public static TextView createNewTextView(Context context, String text, int textColor, float txtSize, int weight, int bgColor, boolean margin) {
        TextView textView = new TextView(context);
        textView.setText(text);
        if (txtSize == 5566) {
            txtSize = textView.getTextSize();
        }
        textView.setTextSize(txtSize);
        LinearLayout.LayoutParams layoutParams;
        if (weight == 5566) {
            layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        } else {
            layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, weight);
        }

        if (margin) {
            layoutParams.setMargins(15, 15, 5, 5);
        }

        textView.setLayoutParams(layoutParams);
        textView.setTextColor(textColor);
        if (bgColor != 5566) {
            textView.setBackgroundColor(bgColor);
        }

        return textView;
    }

    public static EditText createNewEditText(Context context, String hintText) {
        EditText editText = new EditText(context);
        editText.setHint(hintText);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 15, 5, 5);
        editText.setLayoutParams(layoutParams);

        return editText;
    }


    public static CheckBox createNewCheckBox(Context context, String text, CompoundButton.OnCheckedChangeListener checkedChangeListener) {
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

    public static Button createNewButton(Context context, String text, View.OnClickListener clickListener) {
        return createNewButton(context, text, clickListener, Color.WHITE, Color.RED);
    }

    public static Button createNewButton(Context context, String text, View.OnClickListener clickListener, int textColor, int bgColor) {
        Button button = new Button(context);
        button.setText(text);
        button.setTextColor(textColor);
        button.setOnClickListener(clickListener);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        layoutParams.setMargins(15, 15, 5, 5);
        button.setLayoutParams(layoutParams);


        button.setBackgroundDrawable(ViewFactory.setRadius(15, 15, 15, 15, bgColor));
        return createNewButton(context, text, clickListener, textColor, bgColor, 0, bgColor);
    }

    public static Button createNewButton(Context context, String text, View.OnClickListener clickListener, int textColor, int bgColor, int strokeWidth, int stroleColo) {
        Button button = new Button(context);
        button.setText(text);
        button.setTextColor(textColor);
        button.setOnClickListener(clickListener);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        layoutParams.setMargins(15, 15, 5, 5);
        button.setLayoutParams(layoutParams);


        button.setBackgroundDrawable(ViewFactory.setRadius(15, 15, 15, 15, bgColor, strokeWidth, stroleColo));
        return button;
    }

    public static void createNewConfirmDialog(Context context, String text, View.OnClickListener cancelclickListener, View.OnClickListener okclickListener) {
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

        Button cancelBtn = (Button) createNewButton(context, "取消", cancelclickListener, Color.RED, Color.WHITE);
        cancelBtn.setBackgroundDrawable(ViewFactory.setRadius(15, 15, 15, 15, Color.WHITE, 3, Color.RED));

        Button okBtn = (Button) createNewButton(context, "確認", okclickListener, Color.WHITE, Color.RED);

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

        bglinLayout.setBackgroundDrawable(ViewFactory.setRadius(15, 15, Color.WHITE));

        dialog.setContentView(bglinLayout);

        dialog.show();

    }


    public static int getScreenOrientation(Activity activity) {
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
