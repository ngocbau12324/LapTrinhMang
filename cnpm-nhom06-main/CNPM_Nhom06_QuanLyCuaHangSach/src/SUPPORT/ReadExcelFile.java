/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUPPORT;

import DTO.NhanVienDTO;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author xenov
 */
public class ReadExcelFile {
    private String path = "";
    public ReadExcelFile(String path){
        this.path = path;
    }
    public ArrayList<NhanVienDTO> readData() throws Exception{
        ArrayList<NhanVienDTO> ds = new ArrayList<NhanVienDTO>();
        FileInputStream fi = new FileInputStream(path);
        Workbook wb2003 = new HSSFWorkbook(fi);
        Sheet sheet = wb2003.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        iterator.next();
        while(iterator.hasNext()){
            NhanVienDTO nv = new NhanVienDTO();
            Row row = iterator.next();
            nv.setMa(row.getCell(0).getStringCellValue());
            nv.setHo(row.getCell(1).getStringCellValue());
            nv.setTen(row.getCell(2).getStringCellValue());
            nv.setGioitinh((row.getCell(3).getStringCellValue().equals("Nam"))?true:false);
            nv.setNgaysinh(row.getCell(4).getStringCellValue());
            nv.setCa(row.getCell(5).getStringCellValue());
            nv.setLuong((int)row.getCell(6).getNumericCellValue());
            ds.add(nv);
        }
        return ds;
    }
}
