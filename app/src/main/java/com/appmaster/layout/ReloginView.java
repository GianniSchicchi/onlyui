package com.appmaster.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appmaster.R;
import com.appmaster.data.InfoAcconut;

/**
 * Created by Gianni on 2016/8/24.
 */

public class ReloginView extends RelativeLayout {
    ImageView imageView;
    TextView textView;
    ImageView imageViewX;
    FrameLayout frameLayoutX;

    public ReloginView(Context context) {
        this(context, new InfoAcconut());
    }

    public ReloginView(Context context, InfoAcconut acconut) {
        super(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayoutX = new FrameLayout(context);
        imageView = new ImageView(context);


        textView = new TextView(context);
        textView.setTextSize(20);
        imageViewX = new ImageView(context);

        imageViewX.setImageResource(R.mipmap.no);

        frameLayout.addView(imageView);
        frameLayoutX.addView(imageViewX);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(80, 80);

        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        frameLayout.setLayoutParams(params);
        frameLayout.setPadding(25, 0, 0, 0);

        RelativeLayout.LayoutParams paramsX = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        paramsX.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsX.addRule(RelativeLayout.CENTER_VERTICAL);
        frameLayoutX.setLayoutParams(paramsX);
        frameLayoutX.setPadding(0, 0, 25, 0);

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params1.addRule(RelativeLayout.CENTER_IN_PARENT);
        params1.addRule(RelativeLayout.CENTER_VERTICAL);
        textView.setLayoutParams(params1);

        setInfo(acconut);

        addView(frameLayout);
        addView(textView);
        addView(frameLayoutX);
    }

    public void setInfo(InfoAcconut acconut) {
        int resID;
        switch (acconut.mAccountType) {
            case TYPE0:
                resID = R.mipmap.icon_1;
                break;
            case TYPE1:
                resID = R.mipmap.icon_3;
                break;
            case TYPE2:
                resID = R.mipmap.icon_4;
                break;
            case TYPE3:
                resID = R.mipmap.icon_5;
                break;
            case TYPE4:
                resID = R.mipmap.icon_6;
                break;
            default:
                resID = R.mipmap.icon_2;
                break;
        }
        imageView.setImageResource(resID);

        textView.setText(acconut.mAccount);
    }

    public TextView getTextView() {
        return textView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public ImageView getImageViewX() {
        return imageViewX;
    }

    public void setXBtnOnClickListener(OnClickListener clickListener) {
        frameLayoutX.setOnClickListener(clickListener);
    }
}
