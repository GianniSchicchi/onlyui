package com.appmaster.data;

/**
 * Created by Gianni on 2016/8/24.
 */

public enum AccountType {
    TYPE0(0),
    TYPE1(1),
    TYPE2(2),
    TYPE3(3),
    TYPE4(4);


    private int value;

    private AccountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
