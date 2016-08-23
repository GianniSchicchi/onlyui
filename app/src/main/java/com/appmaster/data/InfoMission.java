package com.appmaster.data;

/**
 * Created by Gianni on 2016/8/23.
 */

public class InfoMission {

    public int mIConType;
    public String mText;
    public MissiongPrizeStatus mStatus;

    public InfoMission() {
        mIConType = 1;
        mText = "邀請好友達五人，獎勵XXXXXX \n【5/5】";
        mStatus = MissiongPrizeStatus.Complete;
    }

    public InfoMission(int iconType, String text, MissiongPrizeStatus status) {
        mIConType = iconType;
        mText = text;
        mStatus = status;
    }
}
