package com.appmaster.data;

/**
 * Created by Gianni on 2016/8/23.
 */

public enum MissiongPrizeStatus {

    Error(-2),
    Error1(-1),
    NotYet(0),
    Complete(1),
    Geted(2);


    private int value;
    private MissiongPrizeStatus(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
