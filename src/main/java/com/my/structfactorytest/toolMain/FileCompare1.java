package com.my.structfactorytest.toolMain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//优化逻辑
public class FileCompare1 {
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
                compareList.add(fileLine1.replace(" ",""));
                lineNumber++;
            }

            while ((fileLine2 = br2.readLine()) != null) {
                if (fileLine2.contains("//")){
                    continue;
                }
                if (fileLine2.length() < 1){
                    continue;
                }
                fileLine2.replace(" ", "");
                compareList.add(fileLine2.replace(" ",""));
            }
            //文件1的行数少于等于文件2(lineNumber从0开始计数)
            List<String> bigFile;
            List<String> smallFile;
            //文件二较大
            if ((compareList.size() - lineNumber) >= 0){
                bigFile = compareList.subList(lineNumber + 1,compareList.size());
                smallFile = compareList.subList(0,lineNumber);
                System.out.println("File2 Is Big File!");
            }else {
                bigFile = compareList.subList(0,lineNumber);
                smallFile = compareList.subList(lineNumber+1,compareList.size());
                System.out.println("File1 Is Big File!");
            }
            System.out.println("Big File Total Line = " + bigFile.size());
            System.out.println("Small File Total Line = " + smallFile.size());
            for (int i = 0; i < bigFile.size(); i++) {
                    if (!bigFile.get(i).equals(smallFile.get(i)) && i < smallFile.size()) {
                        System.out.println("File Line = " + i);
                        System.out.println("Big File Content : " + bigFile.get(i));
                        System.out.println("--------------------------对比分割线-----------------------------");
                        System.out.println("Small File Content : " + smallFile.get(i));
                        System.out.println("--------------------------结束分割线-----------------------------");
                    }else{
                        System.out.println("File Line = " + i);
                        System.out.println("Big File Content : " + bigFile.get(i));
                        System.out.println("--------------------------对比分割线-----------------------------");
                        System.out.println("Small File Content : Is NULL!" );
                        System.out.println("--------------------------结束分割线-----------------------------");
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
