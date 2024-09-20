package com.my.structfactorytest.toolMain;

import java.io.*;

//行数添加工具
public class AddRowLineNumber {
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        OutputStreamWriter osr = null;
        BufferedWriter bw = null;

        // 请确保此路径指向正确的文件
        String path = "C:\\Users\\Administrator\\Desktop\\DataSourceConfig";
        String type = "java";

        try {
            // 输入流
            fis = new FileInputStream(path + "." + type);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            // 输出流
            fos = new FileOutputStream(path + "1." + type);
            osr = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osr);

            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String outputLine = lineNumber + ": " + line;  // 不要多余的空格
                System.out.println(outputLine); // 使用println代替print确保换行
                bw.write(outputLine);
                bw.newLine();
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 确保所有资源都被关闭
            try {
                if (br != null) br.close();
                if (isr != null) isr.close();
                if (fis != null) fis.close();
                if (bw != null) bw.close();
                if (osr != null) osr.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
}