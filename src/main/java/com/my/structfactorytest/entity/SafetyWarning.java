package com.my.structfactorytest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SafetyWarning implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    //预警天数
    private Long warning;

    //类别
    private String modeCode;
}
