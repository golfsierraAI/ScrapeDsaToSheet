package com.gourav.utils;

import com.gourav.pojo.Pojo;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.util.List;

@Component
public class Util {
    public void interviewBitWriter(List<Pojo> pojoList) {
        try {
            String filename = "U:\\DSA.xlsx";
            XSSFWorkbook myWorkbook = new XSSFWorkbook();
            XSSFSheet newSpreadsheet = myWorkbook.createSheet("DSA ALL QUESTIONS");
            XSSFRow rowHead = newSpreadsheet.createRow((short) 0);
            rowHead.createCell(0).setCellValue("Question Name");
            rowHead.createCell(1).setCellValue("Question Tags");
            rowHead.createCell(2).setCellValue("Companies");
            int[] i = {1};

            pojoList.forEach((pojo) -> {
                XSSFRow row = newSpreadsheet.createRow(i[0]);
                Hyperlink link = myWorkbook.getCreationHelper().createHyperlink(HyperlinkType.URL);
                link.setAddress(pojo.getLink());
                Cell cell = row.createCell(0);
                cell.setHyperlink(link);
                cell.setCellValue(pojo.getName());
                row.createCell(1).setCellValue(String.valueOf(pojo.getTags()).substring(1, String.valueOf(pojo.getTags()).length() - 1));
                row.createCell(2).setCellValue(String.valueOf(pojo.getCompanies()).substring(1, String.valueOf(pojo.getCompanies()).length() - 1));
                i[0]++;
            });

            FileOutputStream fileOut = new FileOutputStream(filename);
            myWorkbook.write(fileOut);
            fileOut.close();
            myWorkbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void blind75Writer(List<Pojo> pojoList) {
        try {
            String filename = "U:\\BLIND-75.xlsx";
            XSSFWorkbook myWorkbook = new XSSFWorkbook();
            XSSFSheet newSpreadsheet = myWorkbook.createSheet("BLIND-75");
            XSSFRow rowHead = newSpreadsheet.createRow((short) 0);
            rowHead.createCell(0).setCellValue("Question Name");
            rowHead.createCell(1).setCellValue("Question Tags");

            int[] i = {1};
            pojoList.forEach((pojo) -> {
                XSSFRow row = newSpreadsheet.createRow(i[0]);
                Hyperlink link = myWorkbook.getCreationHelper().createHyperlink(HyperlinkType.URL);
                link.setAddress(pojo.getLink());
                Cell cell = row.createCell(0);
                cell.setHyperlink(link);
                cell.setCellValue(pojo.getName());
                row.createCell(1).setCellValue(String.valueOf(String.valueOf(pojo.getTags()).substring(1, String.valueOf(pojo.getTags()).length() - 1)));
                i[0]++;
            });
            FileOutputStream fileOut = new FileOutputStream(filename);
            myWorkbook.write(fileOut);
            fileOut.close();
            myWorkbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
