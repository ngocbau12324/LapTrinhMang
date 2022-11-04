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
public class crawSanPham {
    
    public static void main(String[] args) throws IOException {                
        FileOutputStream file = new FileOutputStream("sanphamCaoCapSangTrong.xlsx");
                        XSSFWorkbook wb = new XSSFWorkbook();
                        XSSFSheet worksheet = wb.createSheet("sanpham");
                        XSSFRow row = null;
                        XSSFCell cell;                        
                        XSSFCell cellA;        
                        XSSFCell cellB;
                        XSSFCell cellC;
                        XSSFCell cellD;
                        XSSFCell cellE;
                        XSSFCell cellF;
                        XSSFCell cellG;    
                        XSSFCell cellH;
                        XSSFCell cellI;
                        XSSFCell cellK;
        try {    
            //chi tiet san pham: 
            String url =Jsoup.connect("https://www.thegioididong.com/laptop?g=cao-cap-sang-trong")
                     .followRedirects(true)
                     .execute()
                     .url()
                     .toExternalForm();
             org.jsoup.nodes.Document doc = Jsoup.connect(url).get();                        
             org.jsoup.select.Elements elements= doc.getElementsByClass("listproduct");
                Element e=doc.getElementsByClass("listproduct").get(0); 
                 int n=(e.childrenSize());//Số lượng nhánh con của "table-taxinfo"                 
                 String gia;
                 String ten ;
                 String brand ;
                 String ram;
                 String oCung ;
                 String manhinh ;                 
                 String cpu ;
                 String card ;
                 String pin;
                 String hinhanh ;                 
                 for(int i=0 ;i<n; i++){
                     gia = e.child(i).attr("data-price");
                     ten = e.child(i).child(0).getElementsByTag("h3").text();
                     brand = e.child(i).child(0).attr("data-brand");  
                     
                     hinhanh = e.child(i).child(0).child(1).child(0).attr("data-src");
                     
                     String[] itemcompare =e.child(i).getElementsByClass("item-compare").text().split("\\s");
                     ram = itemcompare[0]+" "+ itemcompare[1]+" "+itemcompare[2];
                     oCung = itemcompare[3]+" "+itemcompare[4]+" "+itemcompare[5];                     
                     
                     String utility = e.child(i).getElementsByClass("utility").text();
                     
                     String thongTinManHinh = StringUtils.substringBetween(utility, "M.Hình","CPU");
                     manhinh = thongTinManHinh;                     
                     
                     String thongTinCPU = StringUtils.substringBetween(utility,"CPU","Card");
                     cpu = thongTinCPU.trim();
                     
                     card = StringUtils.substringBetween(utility,"Card","Pin").trim();                     
                     
                     pin = (StringUtils.substringAfterLast(utility, "Pin").trim());
                     //System.out.println(thongTinManHinh);
//                     manhin = thongTinManHinh[0];
//                     doPhanGiai = thongTinManHinh[1];
                     //System.out.println(manhin+" "+doPhanGiai);
                        row = worksheet.createRow((short)i);
                        cellA = row.createCell((short)0);
                        cellA.setCellValue(ten);

                        cellB = row.createCell((short)1);
                        cellB.setCellValue(gia);

                        cellC = row.createCell((short)2);
                        cellC.setCellValue(hinhanh);
                        //
                        
                        cellD = row.createCell((short)3);
                        cellD.setCellValue(manhinh);
                        
                        cellE = row.createCell((short)4);
                        cellE.setCellValue(cpu);
                        
                        cellF = row.createCell((short)5);
                        cellF.setCellValue(ram);
                        
                        cellG = row.createCell((short)6);
                        cellG.setCellValue(card);
                        
                        cellH = row.createCell((short)7);
                        cellH.setCellValue(oCung);
                        
                        cellI = row.createCell((short)8);
                        cellI.setCellValue(pin);
                                                
                   
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
