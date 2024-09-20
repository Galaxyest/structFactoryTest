package com.my.structfactorytest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PidToExe {
    //映像名称
    private String name;
    //pid
    private String pid;
    //会化名
    private String sessionName;
    //会话#
    private String sessionNumber;
    //内存使用
    private String memoryUse;
}
