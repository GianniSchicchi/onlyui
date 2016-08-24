package com.appmaster.data;

/**
 * Created by Gianni on 2016/8/24.
 */

public enum ReportType {


    TYPE0(0),
    TYPE1(1),
    TYPE2(2);


    private int value;

    private ReportType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
