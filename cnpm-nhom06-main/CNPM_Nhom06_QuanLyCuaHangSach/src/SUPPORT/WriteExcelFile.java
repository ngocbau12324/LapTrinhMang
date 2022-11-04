/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUPPORT;
import DTO.NhanVienDTO;
import java.util.*;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author xenov
 */
public class WriteExcelFile{
    Workbook wb2003 = new HSSFWorkbook();
    Sheet sheet = wb2003.createSheet("QLNV");
    String[] title = new String[]{"Mã","Họ","Tên","GT","Ngày sinh","Ca làm","Lương"};
    Row row;
    Cell cell;
    int rowIndex = 0,colIndex = 0;
    ArrayList<NhanVienDTO>ds;
    String path ="C:/QLNV.xls";
    public WriteExcelFile(String path,ArrayList<NhanVienDTO>ds){
        this.path = path;
        this.ds = ds;
        taoFile();
        ghi();       
    }
    public void taoFile(){
        
        row = sheet.createRow(rowIndex++);
        for(int i=0;i<title.length;i++){
           cell = row.createCell(colIndex++);
           cell.setCellValue(title[i]);
           cell.setCellStyle(createCellStyleForTitle(sheet));
        }
        colIndex = 0;
    }
    public CellStyle createCellStyleForTitle(Sheet sheet){
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
        // Tạo cell style áp dụng font ở trên
        // Sử dụng màu nền xanh (Blue), định dạng border dưới 
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
    public void ghi(){

       for(int i=0;i<this.ds.size();i++){
           NhanVienDTO nv = ds.get(i);
           ArrayList<String>data = new ArrayList<String>();
           data.add(nv.getMa());
           data.add(nv.getHo());
           data.add(nv.getTen());
           data.add(nv.isGioitinh()?"Nam":"Nữ");
           data.add(nv.getNgaysinh());
           data.add(nv.getCa());
           row = sheet.createRow(rowIndex++);
           for(int k=0;k<data.size();k++){
                cell = row.createCell(colIndex++,CellType.STRING);
                cell.setCellValue(data.get(k));
           }
           cell = row.createCell(colIndex,CellType.NUMERIC);
           cell.setCellValue(nv.getLuong());
           colIndex=0;
           
       }
       for(int i=0;i<8;i++){
           sheet.autoSizeColumn(i);
       }
        try{
            FileOutputStream fos = new FileOutputStream(path);
            wb2003.write(fos);
            fos.close();
            wb2003.close();
        }catch(Exception e){}
    }
  
}
