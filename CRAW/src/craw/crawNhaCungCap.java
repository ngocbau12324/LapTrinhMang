package craw;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;


/**
 *
 * @author NGOC BAU
 */
public class crawNhaCungCap {
    
    public static void main(String[] args) throws IOException {                
        FileOutputStream file = new FileOutputStream("nhaCungCap.xlsx");
                        XSSFWorkbook wb = new XSSFWorkbook();
                        XSSFSheet worksheet = wb.createSheet("nhacungcap");
                        XSSFRow row = null;
                        XSSFCell cell;                        
                        XSSFCell cellA;        
                        XSSFCell cellB;
                        XSSFCell cellC;
                        XSSFCell cellD;
                        XSSFCell cellE;
//                        XSSFCell cellF;
//                        XSSFCell cellG;    
//                        XSSFCell cellH;
//                        XSSFCell cellI;
//                        XSSFCell cellK;
        try {    
            //chi tiet san pham: 
            String url =Jsoup.connect("http://trangvangtructuyen.vn/c3/may-vi-tinh-laptop-nha-cung-cap.html")
                     .followRedirects(true)
                     .execute()
                     .url()
                     .toExternalForm();
             org.jsoup.nodes.Document doc = Jsoup.connect(url).get();                        
             org.jsoup.select.Elements elements= doc.getElementsByClass("chitiet");
             for(int j=1;j<21;j++){
                Element e=doc.getElementsByClass("chitiet").get(j); 
                //System.out.println(e);
                 int n=(e.childrenSize());//Số lượng nhánh con của "table-taxinfo"                 
                 String ten_ncc=e.getElementsByTag("h3").text();
                 System.out.println(ten_ncc);
                 
                 String diachi =e.getElementsByClass("diachi").text();
                 System.out.println(diachi);
                 
                 String logo =e.getElementsByAttributeValue("title", ten_ncc).attr("src");
                 System.out.println(logo);
                 
                 String website =e.getElementsByClass("thongtin").text();
                 System.out.println(e.getElementsByClass("thongtin").text());
                 System.out.println("---------------------");
                 
//                 String email = e.getElementsByClass("glyphicon-envelope").text();
//                 System.out.println(email);
//                 
//                 String phone = e.getElementsByClass("glyphicon-phone-alt").text();
//                 System.out.println(phone);
                 
                 
                 
                     
                        row = worksheet.createRow((short)j);
                        cellA = row.createCell((short)0);
                        cellA.setCellValue(ten_ncc);

                        cellB = row.createCell((short)1);
                        cellB.setCellValue(diachi);

                        cellC = row.createCell((short)2);
                        cellC.setCellValue(logo);
                        //
                        
                        cellD = row.createCell((short)3);
                        cellD.setCellValue(website);
//                        
//                        cellE = row.createCell((short)4);
//                        cellE.setCellValue(phone);
                        
//                        cellF = row.createCell((short)5);
//                        cellF.setCellValue(ram);
//                        
//                        cellG = row.createCell((short)6);
//                        cellG.setCellValue(card);
//                        
//                        cellH = row.createCell((short)7);
//                        cellH.setCellValue(oCung);
//                        
//                        cellI = row.createCell((short)8);
//                        cellI.setCellValue(pin);
                                                
                   
                 
            }
             wb.write(file);
        wb.close();
        file.close();
        } catch (IOException ex) {
            System.out.println("LOI");
        } catch (Exception e){
            System.out.println(e);
        }
        
        
        
    }
    
}
