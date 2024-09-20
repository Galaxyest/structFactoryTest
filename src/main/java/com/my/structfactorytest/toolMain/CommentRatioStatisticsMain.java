package com.my.structfactorytest.toolMain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

//注释统计占比工具
public class CommentRatioStatisticsMain {
    public static void main(String[] args) {

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        // 请确保此路径指向正确的文件
        String path = "C:\\Users\\Administrator\\Desktop\\SafetyProjectActivityRecordServiceImpl";
        String type = "java";


        try {
            // 输入流
            fis = new FileInputStream(path + "." + type);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line;
            int totalLineNumber = 0;
            int ratioCount = 0;
            int lineNumber = 1;
            int prevrCount = 0;
            int nextrCount;
            while ((line = br.readLine()) != null) {
                String outputLine = lineNumber + ": " + line;
                // 是否输出读入的代码行数以及其行数？
                //System.out.println(outputLine);
                if (line.contains("//")){
                    ratioCount++;
                }
                if (line.contains("/*")){
                    prevrCount = lineNumber;
                }
                if (line.contains("*/")){
                    nextrCount = lineNumber;
                    ratioCount = ratioCount + (nextrCount - prevrCount) + 1;
                }
                //空行跳过
                if (line.isEmpty()){
                    totalLineNumber++;
                    continue;
                }
                totalLineNumber++;
                lineNumber++;
            }
            System.out.println("总行数 = " + totalLineNumber);
            System.out.println("注释行数 = " + ratioCount);
            System.out.println("净代码行数 = " + lineNumber);
            //代码注释净占比：
            Double netProportion = (double) ratioCount/lineNumber;
            //总占比
            Double totalProportion = (double)ratioCount/totalLineNumber;
            //转化成百分比：
            DecimalFormat df = new DecimalFormat("#.00");
            String netFormatRP = df.format(netProportion*100) + "%";
            String totalFormatRP = df.format(totalProportion*100) + "%";
            //输出
            System.out.println("当前代码的总占比为： " + totalFormatRP);
            System.out.println("当前代码的注释净占比为：" + netFormatRP);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (br != null) br.close();
                if (isr != null) isr.close();
                if (fis != null) fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
