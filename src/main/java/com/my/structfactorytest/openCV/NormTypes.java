package com.my.structfactorytest.openCV;


public enum NormTypes {
    NORM_INF(0),
    NORM_L1(1),
    NORM_L2(2),
    NORM_L2SQR(3),
    NORM_HAMMING(4),
    NORM_HAMMING2(5),
    NORM_TYPE_MASK(0x7);

    private final int value;

    NormTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
