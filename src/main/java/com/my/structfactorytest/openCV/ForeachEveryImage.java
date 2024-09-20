package com.my.structfactorytest.openCV;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class ForeachEveryImage {

    public static List<File> listImageFiles(String inputPath) {
        File folder = new File(inputPath);

        // 检查是否是目录
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException(inputPath + " is not a directory");
        }

        // 定义图像文件扩展名数组
        String[] imageExtensions = { "jpg", "jpeg", "png", "gif", "bmp", "tiff" };

        // 创建一个过滤器，用于过滤图像文件
        FilenameFilter imageFilter = (dir, name) -> {
            for (String extension : imageExtensions) {
                if (name.toLowerCase().endsWith("." + extension)) {
                    return true;
                }
            }
            return false;
        };

        // 列出文件夹下的所有文件，并过滤出图像文件
        File[] files = folder.listFiles(imageFilter);

        // 创建File类型的List来存储图像文件
        List<File> imageFileList = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                imageFileList.add(file);
            }
        }

        return imageFileList;
    }
}
