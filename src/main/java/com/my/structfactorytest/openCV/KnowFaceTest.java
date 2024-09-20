package com.my.structfactorytest.openCV;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;



public class KnowFaceTest {

    // 加载OpenCV库
    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static void main(String[] args) {


        // 读取输入图像
        Mat image = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\test1.jpeg");

        // 创建灰度图像
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        // 加载Haar级联分类器
        CascadeClassifier faceCascade = new CascadeClassifier("C:\\Users\\Administrator\\Desktop\\haarcascade_frontalface_default.xml");

        // 创建MatOfRect实例来存储检测结果
        MatOfRect facesArray = new MatOfRect();

        // 检测人脸
        faceCascade.detectMultiScale(grayImage, facesArray);

        // 获取检测到的人脸矩形数组
        Rect[] faces = facesArray.toArray();

        // 在检测到的人脸上绘制矩形框
        for (Rect rect : faces) {
            Imgproc.rectangle(image, rect.tl(), rect.br(), new Scalar(255, 0, 0), 2);
        }

        // 保存结果图像
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\test2.jpeg", image);

        System.out.println("人脸检测完成，结果已保存为man2.jpg");
    }
}