package com.appmaster.data;

/**
 * Created by Gianni on 2016/8/23.
 */

public class InfoFansClub {

    public int mIConType;
    public String mText;
    public FansClubStatus mStatus;

    public InfoFansClub() {
        mIConType = 1;
        mText = "粉絲團名稱 \n成為粉絲，獲得獎勵XXX";
        mStatus = FansClubStatus.Like;
    }

    public InfoFansClub(int iconType, String text, FansClubStatus status) {
        mIConType = iconType;
        mText = text;
        mStatus = status;
    }
}
