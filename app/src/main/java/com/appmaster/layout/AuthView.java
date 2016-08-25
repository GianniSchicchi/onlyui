package com.appmaster.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appmaster.R;

/**
 * Created by Gianni on 2016/8/23.
 */

public class AuthView extends RelativeLayout {
    ImageView imageView;
    TextView textView;

    public AuthView(Context context, String type) {
        super(context);
        LinearLayout.LayoutParams params0 = new LinearLayout.LayoutParams(250, ViewGroup.LayoutParams.WRAP_CONTENT);
        params0.gravity = Gravity.LEFT;
        params0.setMargins(20, 0, 0, 0);
        setLayoutParams(params0);


        FrameLayout frameLayout = new FrameLayout(context);
        imageView = new ImageView(context);

        if (type.equals("p")) {
            imageView.setImageResource(R.mipmap.phone);

        }
        if (type.equals("e")) {
            imageView.setImageResource(R.mipmap.mail);
        }

        textView = new TextView(context);
        textView.setTextSize(20);
        textView.setText("2222222222");
        textView.setTextColor(Color.BLACK);

        frameLayout.addView(imageView);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        frameLayout.setLayoutParams(params);

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

//        params1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params1.addRule(RelativeLayout.CENTER_VERTICAL);
        textView.setLayoutParams(params1);
        textView.setPadding(30, 0, 0, 0);

        setPadding(25, 0, 0, 0);
        setBackgroundColor(Color.parseColor("#ffc1c1"));
        addView(frameLayout);
        addView(textView);

    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }
}
