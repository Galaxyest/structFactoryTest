package com.my.structfactorytest.importExcel;


//Excel导入数据库
public class ExcelToExcel {
    //导入Excel
    public static void main(String[] args) {
        //Excel路径->更换成自己本地的
        String excelPath = "C:\\Users\\Administrator\\Desktop\\应急物资.xlsx";

        ExcelToExcelutils.columnSorting(excelPath);






    }
}
