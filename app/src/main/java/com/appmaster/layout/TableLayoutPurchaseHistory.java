package com.appmaster.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.appmaster.data.InfoPurchaseHistory;

/**
 * Created by Gianni on 2016/8/19.
 */

public class TableLayoutPurchaseHistory {

    Context mContext;

    TableLayout tableLayout;
    TableRow tableRow1;
    TableRow tableRow2;
    TableRow tableRow3;

    TextView txtItem;
    TextView txtBuyTime;
    TextView txtMoney;
    TextView txtTransactionID;


    public TableLayoutPurchaseHistory(Context context) {
        mContext = context;
    }

    public void init() {
        tableLayout = new TableLayout(mContext);
        AbsListView.LayoutParams params1 = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tableLayout.setLayoutParams(params1);


//        TableRow.LayoutParams params2 = new TableRow.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        tableRow1 = new TableRow(mContext);
        tableRow2 = new TableRow(mContext);
        tableRow3 = new TableRow(mContext);
//        tableRow1.setLayoutParams(params2);
//        tableRow2.setLayoutParams(params2);
//        tableRow3.setLayoutParams(params2);

        txtItem = setTitleTxtView("項目", Gravity.CENTER, Color.BLACK, Color.parseColor("#F0F0F0"));
        txtBuyTime = setTitleTxtView("購買時間", Gravity.CENTER, Color.BLACK, Color.parseColor("#F0F0F0"));
        txtMoney = setTitleTxtView("金額", Gravity.CENTER, Color.BLACK, Color.parseColor("#F0F0F0"));
        txtTransactionID = setTitleTxtView("交易序號", Gravity.CENTER, Color.BLACK, Color.parseColor("#F0F0F0"), 2);

        TextView txtTitleTransactionID = new TextView(mContext);
        txtTitleTransactionID.setText("交易序號");


        tableRow1.addView(setTitleTxtView("項目"));
        tableRow1.addView(setTitleTxtView("購買時間"));
        tableRow1.addView(setTitleTxtView("金額"));

        tableRow2.addView(txtItem);
        tableRow2.addView(txtBuyTime);
        tableRow2.addView(txtMoney);


        tableRow3.addView(setTitleTxtView("交易序號", Gravity.CENTER, Color.BLACK, Color.parseColor("#F0F0F0"), 1));
        tableRow3.addView(txtTransactionID);

        TableRow.LayoutParams params = (TableRow.LayoutParams) txtTransactionID.getLayoutParams();
        params.span = 2;
        txtTransactionID.setLayoutParams(params); // causes layout update


        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        tableLayout.addView(tableRow3);


    }

    public void setDataInfo(InfoPurchaseHistory info) {

        txtItem.setText(info.mItem);
        txtBuyTime.setText(info.mBuyTime);
        txtMoney.setText("NT$" + info.mMoney);
        txtTransactionID.setText(info.mTransactionID);


    }

    public TableLayout getTableLayout() {
        return tableLayout;
    }

    TextView setTitleTxtView(String name) {

        return setTitleTxtView(name, Gravity.CENTER, Color.WHITE, Color.BLACK);
    }


    TextView setTitleTxtView(String name, int gravity, int txtColor, int bgColor) {
        return setTitleTxtView(name, gravity, txtColor, bgColor, 1);
    }


    TextView setTitleTxtView(String name, int gravity, int txtColor, int bgColor, int initWeight) {
        TableRow.LayoutParams params = new TableRow.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, initWeight);
        TextView txtTitle = new TextView(mContext);
        txtTitle.setGravity(gravity);
        txtTitle.setTextColor(txtColor);
        txtTitle.setBackgroundColor(bgColor);
        txtTitle.setText(name);
        txtTitle.setTextSize(20);
        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setColor(bgColor);
        gdDefault.setStroke(1, Color.BLACK);
        txtTitle.setBackgroundDrawable(gdDefault);
        if (params != null) {
            txtTitle.setLayoutParams(params);
        }

        return txtTitle;
    }


}
