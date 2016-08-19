package com.appmaster;

import android.widget.TextView;

/**
 * Created by Gianni on 2016/8/19.
 */

public class PurchaseHistoryInfo {

    public String mItem;
    public String mBuyTime;
    public String mMoney;
    public String mTransactionID;

    PurchaseHistoryInfo() {
        mItem = "元寶30個 \tGoogle Play";
        mBuyTime = "2015/07/07 \t10:00:12";
        mMoney = "60";
        mTransactionID = "92015073000000715";
    }
}
