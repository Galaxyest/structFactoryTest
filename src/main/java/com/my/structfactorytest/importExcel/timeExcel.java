package com.my.structfactorytest.importExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class timeExcel {

    public static void main(String[] args) {

        String excelPath = "C:\\Users\\Administrator\\Desktop\\应急管理字典.xlsx";
        try (FileInputStream fis = new FileInputStream(new File(excelPath))) {
            //文件流读取
            Workbook workbook = new XSSFWorkbook(fis);
            //获取工作表->将其中的下标替换为你的工作表下标,从0开始

            XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);

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
                if (range.getLastColumn() == 0){
                    cellRCList.add(cellRC);
                }




//                System.out.println("合并单元格 = " + range.formatAsString());
            }
//            System.out.println("cellRCList == " + cellRCList);

            System.out.println(cellRCList);

            List<Timeee> timeees = new ArrayList<>();
            for (int i = 0; i < cellRCList.size(); i++) {
                Timeee timeee = new Timeee();
                timeee.setClazz(cellRCList.get(i).getCellContent());
            }
            System.out.println(timeees);

















        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
