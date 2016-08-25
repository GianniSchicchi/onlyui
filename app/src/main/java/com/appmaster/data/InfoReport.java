package com.appmaster.data;

/**
 * Created by Gianni on 2016/8/22.
 */

public class InfoReport {

    public String mDate;
    public boolean mIsRead;

    public String mTitleType;
    public String mTitlePriority;

    public InfoReport() {
        mDate = "2016-08-22";
        mIsRead = false;

        mTitleType = "進擊吧！三國";
        mTitlePriority = "帳號問題";
    }

    public InfoReport(boolean isRead) {
        mDate = "2016-08-22";
        mIsRead = isRead;

        mTitleType = "進擊吧！三國";
        mTitlePriority = "帳號問題";
    }

    InfoReport(String date, boolean isRead, String titleType, String titlePriority, String titlecontent) {
        mDate = date;
        mIsRead = isRead;

        mTitleType = titleType;
        mTitlePriority = titlePriority;
    }

}
