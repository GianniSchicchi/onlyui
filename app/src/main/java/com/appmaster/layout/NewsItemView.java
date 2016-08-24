package com.appmaster.layout;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appmaster.data.InfoAnn;

/**
 * Created by Gianni on 2016/8/24.
 */

public class NewsItemView extends RelativeLayout {
    TextView txtDate;
    TextView txtTitleType;
    TextView txtTitlePriority;
    TextView txtTitleContent;

    public NewsItemView(Context context) {
        super(context);

        LinearLayout linearLayoutP;
        LinearLayout linearLayoutH;

        linearLayoutP = new LinearLayout(context);
        linearLayoutP.setOrientation(LinearLayout.VERTICAL);
        linearLayoutH = new LinearLayout(context);
        linearLayoutH.setOrientation(LinearLayout.HORIZONTAL);

        txtDate = new TextView(context);
        txtTitleType = new TextView(context);
        txtTitlePriority = new TextView(context);
        txtTitleContent = new TextView(context);

        linearLayoutH.addView(txtTitleType);
        linearLayoutH.addView(txtTitlePriority);
        linearLayoutH.addView(txtTitleContent);

        linearLayoutP.addView(txtDate);
        linearLayoutP.addView(linearLayoutH);


        txtTitleType.setTextColor(Color.RED);

        txtDate.setTextSize(20);
        txtTitleType.setTextSize(20);
        txtTitlePriority.setTextSize(20);
        txtTitleContent.setTextSize(20);

        txtTitleContent.setSingleLine();
        txtTitleContent.setEllipsize(TextUtils.TruncateAt.END);

        addView(linearLayoutP);

    }

    public void setInfo(String date, String titleType, String titlePriority, String titleContent) {
        txtDate.setText(date);
        txtTitleType.setText("【" + titleType + "】");
        txtTitlePriority.setText("【" + titlePriority + "】");
        txtTitleContent.setText(titleContent);
    }

    public void setInfo(InfoAnn info) {
        txtDate.setText(info.mDate);
        txtTitleType.setText("【" + info.mTitleType + "】");
        txtTitlePriority.setText("【" + info.mTitlePriority + "】");
        txtTitleContent.setText(info.mTitleContent);
    }

    public TextView getTxtDate() {
        return txtDate;
    }

    public TextView getTxtTitleType() {
        return txtTitleType;
    }

    public TextView getTxtTitlePriority() {
        return txtTitlePriority;
    }

    public TextView getTxtTitleContent() {
        return txtTitleContent;
    }
}
