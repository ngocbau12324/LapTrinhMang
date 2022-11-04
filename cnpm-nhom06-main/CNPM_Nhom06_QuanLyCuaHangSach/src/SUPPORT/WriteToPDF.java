/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUPPORT;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author xenov
 */
public class WriteToPDF {
    public WriteToPDF(String path, int luong[], int buoi[], int thu[]) throws Exception{
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(path));
        doc.open();
        Font f = new Font(BaseFont.createFont("arial.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED));
        
        Paragraph pa = new Paragraph();
        pa.setFont(f);
        pa.add("CÔNG TY: MINISHOP-CV                                  CỘNG HÒA - XÃ HỘI - CHỦ NGHĨA - VIỆT NAM");
        pa.add("                                                                                                 Độc lập - Tự do - Hạnh phúc");
        Calendar c = Calendar.getInstance();
        pa.add(createParagraph(f,"  "));
        pa.add(createParagraph(f,"                                                                                           Tp.HCM, ngày " + c.get(Calendar.DATE) + ", tháng " + (c.get(Calendar.MONTH) + 1) + ", năm " + c.get(Calendar.YEAR)));
        pa.add(createParagraph(f," "));
        pa.add(createParagraph(f,"                                                        ==========**=========="));
        pa.add(createParagraph(f,"                                                    BÁO CÁO QUẢN LÝ NHÂN VIÊN"));
        pa.add(createParagraph(f," "));
        pa.add(createParagraph(f,"                                                                      TUẦN " + c.get(Calendar.WEEK_OF_YEAR)));
        doc.add(pa);
        
        //muc luong================
        f.setColor(255, 0, 0);
        doc.add(createParagraph(f,"Báo cáo mức lương"));
        f.setColor(0, 0, 0);
        PdfPTable t = new PdfPTable(5);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);

        PdfPCell c1 = new PdfPCell(createPhrase(f,"Tổng số"));
      
        t.addCell(c1);
        PdfPCell c2 = new PdfPCell(createPhrase(f,"Tổng lương"));
        t.addCell(c2);
        PdfPCell c3 = new PdfPCell(createPhrase(f,"Lương trung bình"));
        t.addCell(c3);
        PdfPCell c4 = new PdfPCell(createPhrase(f,"Mức lương thấp nhất"));
        t.addCell(c4);
        PdfPCell c5 = new PdfPCell(createPhrase(f,"Mức lương cao nhất"));
        t.addCell(c5);

        t.addCell(luong[0]+"");
        t.addCell(luong[1]+"");
        t.addCell(luong[2]+"");
        t.addCell(luong[3]+"");
        t.addCell(luong[4]+"");
        
        doc.add(t);
        
        //=========ca lam
        f.setColor(255, 0, 0);
        doc.add(createParagraph(f,"Báo cáo số lượng nhân viên theo buổi"));
        f.setColor(0, 0, 0);
        t = new PdfPTable(3);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);

        c1 = new PdfPCell(createPhrase(f,"Sáng"));
        t.addCell(c1);
        c2 = new PdfPCell(createPhrase(f,"Chiều"));
        t.addCell(c2);
        c3 = new PdfPCell(createPhrase(f,"Tối"));
        t.addCell(c3);
        t.addCell(buoi[0]+"");
        t.addCell(buoi[1]+"");
        t.addCell(buoi[2]+"");
        doc.add(t);
        
        //================== thu lam
        f.setColor(255, 0, 0);
        doc.add(createParagraph(f,"Báo cáo số lượng nhân viên theo ngày"));
        f.setColor(0, 0, 0);
        t = new PdfPTable(7);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);

        c1 = new PdfPCell(createPhrase(f,"Thứ 2"));
      
        t.addCell(c1);
        c2 = new PdfPCell(createPhrase(f,"Thứ 3"));
        t.addCell(c2);
        c3 = new PdfPCell(createPhrase(f,"Thứ 4"));
        t.addCell(c3);
        c4 = new PdfPCell(createPhrase(f,"Thứ 5"));
        t.addCell(c4);
        c5 = new PdfPCell(createPhrase(f,"Thứ 6"));
        t.addCell(c5);
        PdfPCell c6 = new PdfPCell(createPhrase(f,"Thứ 7"));
        t.addCell(c6);
        PdfPCell c7 = new PdfPCell(createPhrase(f,"Chủ nhật"));
        t.addCell(c7);
        
        t.addCell(thu[0]+"");
        t.addCell(thu[1]+"");
        t.addCell(thu[2]+"");
        t.addCell(thu[3]+"");
        t.addCell(thu[4]+"");
        t.addCell(thu[5]+"");
        t.addCell(thu[6]+"");
        
        doc.add(t);
        //=====
        doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        doc.add(createParagraph(f, "                                                                                                             Người báo cáo"));
      
        doc.add(createParagraph(f, "                                                                                                              ..........."));
        doc.close();
        
    }
   
    public Paragraph createParagraph(Font f, String content){
        Paragraph pa = new Paragraph();
        pa.setFont(f);
        pa.add(content);
        return pa;
    }
    public Phrase createPhrase(Font f, String content){
        Phrase ph = new Phrase();
        ph.setFont(f);
        ph.add(content);
        return ph;
    }
    
}
