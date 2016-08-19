package com.appmaster;

/**
 * Created by Gianni on 2016/8/19.
 */

public class AnnInfo {

    public String mDate;
    public String mTitleType;
    public String mTitlePriority;
    public String mTitleContent;

    AnnInfo() {
        mDate = "2016-08-19";
        mTitleType = "系統";
        mTitlePriority = "重要提醒";
        mTitleContent = "快速帳號，請儘綁定帳號！";
    }

    AnnInfo(String date, String titleType, String titlePriority, String titlecontent) {
        mDate = date;
        mTitleType = titleType;
        mTitlePriority = titlePriority;
        mTitleContent = titlecontent;
    }

}
