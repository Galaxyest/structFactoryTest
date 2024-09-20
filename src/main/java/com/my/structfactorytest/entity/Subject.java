package com.my.structfactorytest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Subject {
    private Long sId;
    private Long mId;
    private String mName;
    private String sCode;
    private String sName;
    private Date createTime;
}
