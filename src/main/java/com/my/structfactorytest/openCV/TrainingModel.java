package com.my.structfactorytest.openCV;

import org.opencv.core.*;
import org.opencv.features2d.BFMatcher;
import org.opencv.features2d.ORB;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.ArrayList;
import java.util.List;

public class TrainingModel {

    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        // 读取参考图片
        Mat img1 = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\test1.jpeg", Imgcodecs.IMREAD_GRAYSCALE);
        Mat img2 = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\test2.jpeg", Imgcodecs.IMREAD_GRAYSCALE);

        // 特征提取
        ORB orb = ORB.create();
        Mat descriptors1 = new Mat();
        Mat descriptors2 = new Mat();
        MatOfKeyPoint keypoints1 = new MatOfKeyPoint();
        MatOfKeyPoint keypoints2 = new MatOfKeyPoint();

        orb.detectAndCompute(img1, new Mat(), keypoints1, descriptors1);
        orb.detectAndCompute(img2, new Mat(), keypoints2, descriptors2);

        // 特征匹配
        BFMatcher matcher = BFMatcher.create();
        List<MatOfDMatch> matches = new ArrayList<>();
        matcher.knnMatch(descriptors1, descriptors2, matches, 2);

        // 筛选匹配
        List<DMatch> goodMatches = new ArrayList<>();
        float ratioThresh = 0.75f;

        for (MatOfDMatch matOfDMatch : matches) {
            DMatch[] dmArray = matOfDMatch.toArray();
            if (dmArray[0].distance < ratioThresh * dmArray[1].distance) {
                goodMatches.add(dmArray[0]);
            }
        }

        // 输出结果
        System.out.println("Good matches: " + goodMatches.size());
    }

}
