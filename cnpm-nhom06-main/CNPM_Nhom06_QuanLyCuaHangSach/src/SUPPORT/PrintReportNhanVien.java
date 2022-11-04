/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUPPORT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author xenov
 */
public class PrintReportNhanVien {
    private String path = "";
    public boolean copyFile(String source, String dest) throws FileNotFoundException, IOException {
//        file nguồn
        File sourceFile = new File(source);
//        file đích
        File destFile = new File(dest);
//        kiem tra file nguồn có tồn tại không
        if (sourceFile.exists()) {
//           luồng đọc file
          FileInputStream fis = new FileInputStream(sourceFile);
//           luồng ghi file
            FileOutputStream fos = new FileOutputStream(destFile);
            byte[] arr = new byte[1024];
            while ((fis.read(arr)) != -1) {
                fos.write(arr);
                fos.flush();
            }
            fis.close();
            fos.close();
            System.out.println("copy thành công");
            return true;
        } else {
            System.out.println("file nguồn không tồn tại");
            return false;
        }
    }
    public PrintReportNhanVien(String path,int tongso,int tongluong, int min, int max){
        try{
            Workbook wb2003 = new HSSFWorkbook(new FileInputStream("reportSample.xls"));
            Sheet sheet = wb2003.getSheetAt(0);
            Row row = sheet.getRow(9);
            Cell cell = row.getCell(4);
            cell.setCellValue(tongso);
            row = sheet.getRow(10);
            cell = row.getCell(4);
            cell.setCellValue(tongluong);
            row = sheet.getRow(11);
            cell = row.getCell(4);
            cell.setCellValue(tongluong/tongso);
            row = sheet.getRow(12);
            cell = row.getCell(4);
            cell.setCellValue(min);
            row = sheet.getRow(13);
            cell = row.getCell(4);
            cell.setCellValue(max);
            FileOutputStream fo = new FileOutputStream(path);
            wb2003.write(fo);
            fo.close();
            wb2003.close();
        }catch(Exception e){
            e.printStackTrace();}
    }
}
