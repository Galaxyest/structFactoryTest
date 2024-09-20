package com.my.structfactorytest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Major {
    private Long mId;
    private String mCode;
    private String mName;
    private Date createTime;
}
