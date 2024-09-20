package com.my.structfactorytest.openCV;



import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class FaceTest {
    //加载 opencv_javaXX.dll
    static{

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {

        //测试图片地址
        String imgPath = "C:\\Users\\Administrator\\Desktop\\test1.jpeg";
        //读取图片
        Mat img = Imgcodecs.imread(imgPath);
        //生成灰度图
        Mat gray = new Mat();
        Imgproc.cvtColor(img,gray, Imgproc.COLOR_BGR2GRAY);
        //保存图片
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\test12.jpeg", gray);









    }

}
