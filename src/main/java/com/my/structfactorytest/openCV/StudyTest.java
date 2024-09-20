package com.my.structfactorytest.openCV;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.Features2d;
import org.opencv.features2d.ORB;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;


public class StudyTest {


    // 静态代码块，用于加载OpenCV的本地库
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        // 指定要加载的图像文件路径
        String imagePath = "C:\\Users\\Administrator\\Desktop\\test1.jpeg";

        // 调用loadImage方法加载图像
        Mat image = loadImage(imagePath);

        // 检查图像是否加载成功
        if (image.empty()) {
            System.out.println("Could not load image at: " + imagePath);
            return;
        }

        // 检测图像中的ORB关键点
        MatOfKeyPoint keypoints = detectORBKeypoints(image);

        // 在图像上绘制关键点
        Mat outputImage = drawKeypoints(image, keypoints);

        // 显示处理后的图像
        showImage("Keypoints", outputImage);
    }

    // 私有方法：加载图像
    private static Mat loadImage(String path) {
        // 使用Imgcodecs类读取图像文件，并返回Mat对象
        return Imgcodecs.imread(path);
    }

    // 私有方法：检测ORB关键点
    private static MatOfKeyPoint detectORBKeypoints(Mat image) {
        // 创建一个新的ORB特征检测器实例
        ORB orb = ORB.create();

        // 创建一个MatOfKeyPoint对象来存储检测到的关键点
        MatOfKeyPoint keypoints = new MatOfKeyPoint();

        // 使用ORB对象检测图像中的关键点，并将结果存储到keypoints中
        orb.detect(image, keypoints);

        // 返回检测到的关键点
        return keypoints;
    }

    // 私有方法：绘制关键点
    private static Mat drawKeypoints(Mat image, MatOfKeyPoint keypoints) {
        // 创建一个新的Mat对象，用于存储绘制后的图像
        Mat outputImage = new Mat();

        // 在原始图像上绘制关键点，并将结果存储在outputImage中
        Features2d.drawKeypoints(image, keypoints, outputImage);

        // 返回绘制后的图像
        return outputImage;
    }

    // 私有方法：显示图像
    private static void showImage(String windowName, Mat image) {
        // 使用HighGui库显示图像
        HighGui.imshow(windowName, image);

        // 等待用户按下任意键
        HighGui.waitKey(0);

        // 退出程序
        System.exit(0);
    }



}
