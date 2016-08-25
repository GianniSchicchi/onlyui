package com.appmaster.data;

/**
 * Created by Gianni on 2016/8/23.
 */

public enum FansClubStatus {
    Error(-2),
    Error1(-1),
    NotYet(0),
    Like(1),
    Liked(2);


    private int value;

    private FansClubStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
