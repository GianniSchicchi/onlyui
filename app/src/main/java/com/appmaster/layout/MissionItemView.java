package com.appmaster.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appmaster.R;
import com.appmaster.data.MissiongPrizeStatus;
import com.appmaster.tools.ViewFactory;
import com.appmaster.tools.ViewLayoutFactory;

/**
 * Created by Gianni on 2016/8/23.
 */

public class MissionItemView extends RelativeLayout {
    ImageView imageView;
    TextView textView;
    Button button;
    public MissionItemView(Context context) {
        super(context);
        AbsListView.LayoutParams params0 = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 110);
        setLayoutParams(params0);

        FrameLayout frameLayout = new FrameLayout(context);
        imageView = new ImageView(context);

        imageView.setImageResource(R.mipmap.icon_23);
        textView = new TextView(context);
        textView.setTextSize(20);
        textView.setText("2222222222");
        button = ViewFactory.createNewButton(context,"",null);

        frameLayout.addView(imageView);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(80, 80);

        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        frameLayout.setLayoutParams(params);
        frameLayout.setPadding(25,0,0,0);

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params1.addRule(RelativeLayout.CENTER_IN_PARENT);
        params1.addRule(RelativeLayout.CENTER_VERTICAL);
        textView.setLayoutParams(params1);

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params2.addRule(RelativeLayout.CENTER_VERTICAL);
        params2.setMargins(0,0,25,0);
        button.setLayoutParams(params2);

        addView(frameLayout);
        addView(textView);
        addView(button);
    }

    public void setInfo(int icon, String text, MissiongPrizeStatus status) {

    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public Button getButton() {
        return button;
    }

}

