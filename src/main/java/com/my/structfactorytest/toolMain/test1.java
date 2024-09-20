package com.my.structfactorytest.toolMain;


public enum test1 {
    ACTIVITY("1","活动表");

    String code;
    String name;

    test1(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
