package com.my.structfactorytest.importExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelToExcelutils {

    public static void columnSorting(String excelPath){
        try (FileInputStream fis = new FileInputStream(new File(excelPath))) {
            //文件流读取
            Workbook workbook = new XSSFWorkbook(fis);
            //获取工作表->将其中的下标替换为你的工作表下标,从0开始

            XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(2);

            //获取合并单元格数量：
            int margeCount = sheet.getNumMergedRegions();

            List<CellRC> cellRCList = new ArrayList<>();

            for (int i = 0; i < margeCount; i++) {
                //获取合并区域
                CellRangeAddress range = sheet.getMergedRegion(i);

                CellRC cellRC = new CellRC();
                cellRC.setFirstRow(range.getFirstRow());
                cellRC.setLastRow(range.getLastRow());
                cellRC.setFirstColumn(range.getFirstColumn());
                cellRC.setLastColumn(range.getLastColumn());
                //获取合并单元格中的内容
                Row row = sheet.getRow(range.getFirstRow());
                Cell cell = row.getCell(range.getFirstColumn());
                cellRC.setCellContent(cell.getStringCellValue());
                cellRCList.add(cellRC);
//                System.out.println("合并单元格 = " + range.formatAsString());
            }
            System.out.println("cellRCList == " + cellRCList);





            //读取每一行第一个作为一级分类
            List<String> oneList = new ArrayList<>();

            HashMap<String,List<String>> levelMap = new HashMap<>();

            List<String> secondList = new ArrayList<>();

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                if (cell != null){
                    oneList.add(cell.getStringCellValue());
                }




                System.out.println("i = " + i);



            }
            LinkedHashSet<String> asSet = new LinkedHashSet<>(oneList);
//            System.out.println(asSet);

            oneList = new ArrayList<>(asSet);
            System.out.println(oneList);



            //遍历工作表中的所有行
            //如果第一行是表头，则i = 1；若不是，则为0
//                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//                    Row row = sheet.getRow(i);
//                    //遍历工作表中的所有单元格
//                    for (Cell cell : row) {
//                        String cellValue = cell.getStringCellValue();
//
//                    }
//                }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

















    //提取单元格
    public static String extractLetters(String input) {
        // 创建一个Pattern对象，用于匹配字母
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(input);

        StringBuilder letters = new StringBuilder();

        // 遍历匹配结果
        while (matcher.find()) {
            letters.append(matcher.group());
        }

        return letters.toString();
    }


    //是否为同一行合并
    public static boolean isColumnMarge(int firstRow,int lastRow){
        if (firstRow == lastRow){
            return true;
        }else {
            return false;
        }
    }

    //是否为同一列
    public static boolean isRowMarge(int firstColumn,int lastColumn){
        if (firstColumn == lastColumn){
            return true;
        }else {
            return false;
        }
    }


}
