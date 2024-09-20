package com.my.structfactorytest.openCV;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class KnowFaceController {
    //加载openCV的dll(检测jdk的bin中有没有470的dll)
    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    /**
     * path: 图片存放的路径
     **/
    public static void knowFace(String inputPath, String outputPath, String fileName){
        // 读取输入图像
        Mat image = Imgcodecs.imread(inputPath + fileName);

        // 创建灰度图像
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        // 加载Haar级联分类器（xml为模型的训练结果，如果需要识别什么，则需要训练什么，将该文件的xml替换即可，记得将xml放入文件的resources中，记得读取）
        CascadeClassifier faceCascade = new CascadeClassifier("C:\\Users\\Administrator\\Desktop\\haarcascade_frontalface_default.xml");

        // 创建MatOfRect实例来存储检测结果
        MatOfRect facesArray = new MatOfRect();

        // 检测人脸
        faceCascade.detectMultiScale(grayImage, facesArray);

        // 获取检测到的人脸矩形数组
        Rect[] faces = facesArray.toArray();

        // 在检测到的人脸上绘制矩形框
        for (Rect rect : faces) {
            Imgproc.rectangle(image, rect.tl(), rect.br(), new Scalar(245, 255, 100), 2);
        }

        // 保存结果图像
        Imgcodecs.imwrite(outputPath + fileName, image);




    }
}
