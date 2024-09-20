//package com.my.structfactorytest.configuration;
//
//import java.util.Arrays;
//import java.util.Random;
//
//public class NyWaveFunctionCollapseTest {
//    public static void main(String[] args) {
//        //定义一组随机数组(先10个，之后随机)
//        int arr[] = new int[10];
//
//        for (int i = 0; i < arr.length; i++) {
//        Random random = new Random();
//        arr[i] = random.nextInt(100);
//        }
//
//        System.out.println(Arrays.toString(arr));
//
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        Integer brr[][] = new Integer[10][10];
//        Random random = new Random();
//        int x = random.nextInt(10);//brr横
//        int y = random.nextInt(10);//brr纵
//        int z = random.nextInt(10);//brr
//        System.out.println(Arrays.deepToString(brr));
//
//        if (brr[x][y] == null) {
//            brr[x][y] = arr[z];
//        }
//        if (brr[x][y] >= brr[x + 1][y]) {
//            brr[x][y] = arr[z+1];
//        }
//        if (brr[x][y] >= brr[x][y + 1]) {
//            brr[x][y] = arr[z+1];
//        }
//
//
//    }
//}
