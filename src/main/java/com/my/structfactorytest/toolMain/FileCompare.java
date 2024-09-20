package com.my.structfactorytest.toolMain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileCompare {
    public static void main(String[] args) {
        //文件1
        FileInputStream fis1 = null;
        InputStreamReader isr1 = null;
        BufferedReader br1 = null;
        //文件2
        FileInputStream fis2 = null;
        InputStreamReader isr2 = null;
        BufferedReader br2 = null;
        //两个文件的路径
        String absolutyPath1 = "C:\\Users\\Administrator\\Desktop\\1.txt";
        String absolutyPath2 = "C:\\Users\\Administrator\\Desktop\\2.txt";

        try {
            // 输入流
            fis1 = new FileInputStream(absolutyPath1);
            isr1 = new InputStreamReader(fis1);
            br1 = new BufferedReader(isr1);

            fis2 = new FileInputStream(absolutyPath2);
            isr2 = new InputStreamReader(fis2);
            br2 = new BufferedReader(isr2);

            String fileLine1;
            String fileLine2;
            List<String> compareList = new ArrayList<>();
            int lineNumber = 0;

            while ((fileLine1 = br1.readLine()) != null) {
                if (fileLine1.contains("//")){
                    continue;
                }
                if (fileLine1.length() < 1){
                    continue;
                }
                fileLine1.replace(" ", "");
//                System.out.println(fileLine1.replace(" ", ""));
                compareList.add(fileLine1.replace(" ",""));
                lineNumber++;
            }

//            System.out.println("------------分隔线-------------");

            while ((fileLine2 = br2.readLine()) != null) {
                if (fileLine2.contains("//")){
                    continue;
                }
                if (fileLine2.length() < 1){
                    continue;
                }
                fileLine2.replace(" ", "");
//                System.out.println(fileLine2.replace(" ", ""));
                compareList.add(fileLine2.replace(" ",""));
            }
            //文件1的行数少于等于文件2(lineNumber从0开始计数)
            if (lineNumber  * 2 < compareList.size()){
                for (int i = 0; i < lineNumber; i++) {
                    if (i <= lineNumber){
                        if (!compareList.get(i).equals(compareList.get(lineNumber + i))) {
                            System.out.println("File1 Line = " + i + "; File2 Line = " + (lineNumber + i));
                            System.out.println("File1 Content : " + compareList.get(i));
                            System.out.println("--------------------------对比分割线-----------------------------");
                            System.out.println("File2 Content : " + compareList.get(lineNumber + i));
                            System.out.println("--------------------------结束分割线-----------------------------");
                        }
                    }else{
                        System.out.println("File2 Line = " + (lineNumber + i));
                        System.out.println("File1 Content : This File Line Is NULL!" );
                        System.out.println("--------------------------对比分割线-----------------------------");
                        System.out.println("File2 Content : " + compareList.get(lineNumber + i));
                        System.out.println("--------------------------结束分割线-----------------------------");
                    }
                }
            }else{
                //文件2行数少于文件1
                for (int i = 0; i < lineNumber; i++) {
                    if ((lineNumber + i) < compareList.size()){
                        if (!compareList.get(i).equals(compareList.get(lineNumber + i))) {
                            System.out.println("File1 Line = " + i + "; File2 Line = " + (lineNumber + i));
                            System.out.println("File1 Content : " + compareList.get(i));
                            System.out.println("--------------------------对比分割线-----------------------------");
                            System.out.println("File2 Content : " + compareList.get(lineNumber + i));
                            System.out.println("--------------------------结束分割线-----------------------------");
                        }
                    }else{
                        System.out.println("File1 Line = " + i);
                        System.out.println("File1 Content : " + compareList.get(i));
                        System.out.println("--------------------------对比分割线-----------------------------");
                        System.out.println("File2 Content : This File Line Is NULL!" );
                        System.out.println("--------------------------结束分割线-----------------------------");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 确保所有资源都被关闭
            try {
                if (br1 != null) br1.close();
                if (isr1 != null) isr1.close();
                if (fis1 != null) fis1.close();
                if (br2 != null) br2.close();
                if (isr2 != null) isr2.close();
                if (fis2 != null) fis2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
