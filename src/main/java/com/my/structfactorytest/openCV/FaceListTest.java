package com.my.structfactorytest.openCV;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import static com.my.structfactorytest.openCV.CheckFileExist.checkFileExist;
import static com.my.structfactorytest.openCV.ForeachEveryImage.listImageFiles;

public class FaceListTest {
    public static void main(String[] args) {

        // 输入遍历的文件夹路径
        String inputPath = "C:\\Users\\Administrator\\Desktop\\knowFace\\";
        // 输出文件路径
        String outputPath = "C:\\Users\\Administrator\\Desktop\\knowFace2\\";

        checkFileExist(outputPath);

        List<File> imageFiles = listImageFiles(inputPath);
        List<String> picturePaths = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();


        // 打印找到的图片文件名
        for (File imageFile : imageFiles) {
            picturePaths.add(String.valueOf(imageFile));

        }

        for(String s: picturePaths){
            s = s.replace(inputPath,"");
            System.out.println(s);
            fileNames.add(s);
        }

        for (String s : fileNames){
            KnowFaceController.knowFace(inputPath,outputPath,s);
        }

        System.out.println("人脸检测完成，结果已保存在" + outputPath + "中！");


    }
}
