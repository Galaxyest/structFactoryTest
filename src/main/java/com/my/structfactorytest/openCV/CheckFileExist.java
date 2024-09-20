package com.my.structfactorytest.openCV;

import java.io.File;

public class CheckFileExist {

    public static void checkFileExist(String path){

        // 创建File对象
        File directory = new File(path);

        // 检测文件夹是否存在
        if (!directory.exists()) {
            // 文件夹不存在，尝试创建
            boolean wasSuccessful = directory.mkdir();
            if (wasSuccessful) {
                System.out.println("文件夹已成功创建: " + path);
            } else {
                System.out.println("文件夹创建失败: " + path);
            }
        } else{
            System.out.println("文件夹已存在: " + path);
        }
    }



}
