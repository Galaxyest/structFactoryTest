package com.my.structfactorytest.importExcel;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;

//Excel导入数据库
public class importExcel {
    //导入Excel
    public static void main(String[] args) {
        //Excel路径->更换成自己本地的
        String excelPath = "C:\\Users\\Administrator\\Desktop\\应急物资.xlsx";

        XSSFWorkbook workbook1 = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook1.createSheet("外包人员导入模板");
        XSSFCellStyle cellStyle = workbook1.createCellStyle();
        //设置文本自适应，顶端对齐
        cellStyle.setWrapText(true);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        /** 创建表头 */
        String[] headStr = {"所属模块","字典名称","字典类型","字典数据"};









        try(FileInputStream fis = new FileInputStream(new File(excelPath))){
            //文件流读取

            Workbook workbook = new XSSFWorkbook(fis);

            //获取工作表->将其中的下标替换为你的工作表下标,从0开始
            XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(1);


            //遍历工作表中的所有行
            //如果第一行是表头，则i = 1；若不是，则为0
            for (int i = 0;i <= sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);

                switch (i){
                    case 0:
                        //遍历工作表中的所有单元格
                        for (Cell cell : row){
                            String cellValue = cell.getStringCellValue();
                            System.out.println(cellValue);
                        }
                    break;
                    case 1:
                        //遍历工作表中的所有单元格
                        for (Cell cell : row){
                            String cellValue = cell.getStringCellValue();
                            System.out.println(cellValue);
                            //调用ServiceImpl层代码存入数据库中
                        }

                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
