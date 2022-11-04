/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TraCuuThongTinSinhVien;

import MASOTHUE.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;


/**
 *
 * @author NGOC BAU
 */
public class main {
    public static void main(String[] args) {        
        String url ="http://thongtindaotao.sgu.edu.vn/Default.aspx?page=xemdiemthi&id=3119410035";
        String domain = "http://thongtindaotao.sgu.edu.vn/";
        try{
        String urlXemDiem = domain + "default.aspx?page=nhapmasv&flag=XemDiemThi";
        String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Mobile Safari/537.36";
        Connection.Response respone=Jsoup.connect(urlXemDiem)
                .method(Connection.Method.GET)
                .execute();
        org.jsoup.nodes.Document XemDiemPage = respone.parse();
        //Lấy thông tin sinh viên
        respone = Jsoup.connect(urlXemDiem)
                .data("__EVENTTARGET", "")
                .data("__EVENTARGUMENT","")
                .data("__VIEWSTATE", XemDiemPage.getElementById("__VIEWSTATE").val())
                .data("__VIEWSTATEGENERATOR",XemDiemPage.getElementById("__VIEWSTATEGENERATOR").val())
                .data("ctl00$ContentPlaceHolder1$ctl00$txtMaSV","3119410035")
                .data("ctl00$ContentPlaceHolder1$ctl00$btnOK","OK")
                .userAgent(userAgent)
                .timeout(0)
                .followRedirects(true)
                .cookies(respone.cookies())
                .method(Connection.Method.POST)
                .execute();
        XemDiemPage = respone.parse();
        //System.out.println(XemDiemPage.getElementsByClass("infor-member").get(0).getElementsByTag("tbody").get(0));
        Element element = XemDiemPage.getElementsByClass("infor-member").get(0).getElementsByTag("tbody").get(0);               
        int childrenSize = element.childrenSize();//Số lượng nút con của nút cha "tbody"
            System.out.println(childrenSize);
        String infor = "";
        for(int i=0;i<10;i++){
            infor += element.child(i).child(0).text()+": ";
            infor += element.child(i).child(1).text()+"\n";
        }
            System.out.println(infor);
        //Lấy điểm thi năm học 2019-2020 HKI
        String urlXemDiemThiTheoHK = domain+"Default.aspx?page=xemdiemthi&id=3119410035";
        respone = Jsoup.connect(urlXemDiemThiTheoHK)                
                .method(Connection.Method.GET)
                .execute();
        respone = Jsoup.connect(urlXemDiemThiTheoHK)
                .data("__EVENTTARGET", "")
                .data("__EVENTARGUMENT","")
                .data("__VIEWSTATE", XemDiemPage.getElementById("__VIEWSTATE").val())
                .data("__VIEWSTATEGENERATOR",XemDiemPage.getElementById("__VIEWSTATEGENERATOR").val())
                .data("ctl00$ContentPlaceHolder1$ctl00$txtChonHK","20201")
                .data("ctl00$ContentPlaceHolder1$ctl00$btnChonHK","Xem")
                .userAgent(userAgent)
                .timeout(0)
                .followRedirects(true)
                .cookies(respone.cookies())
                .method(Connection.Method.POST)
                .execute();
        XemDiemPage = respone.parse();
        Element element1 = XemDiemPage.getElementsByClass("view-table").get(0).getElementsByTag("tbody").get(0);
        int childrenSizeOfElement1 = element1.childrenSize();//số lượng thẻ <tr> hoặc số lượng nút con của nút cha tbody
        int soLuongMonHoc = childrenSizeOfElement1 - 8;
        String danhSachDiem="";
        for(int i=2 ;i < (soLuongMonHoc+2); i++){
            danhSachDiem += element1.child(i).child(1).text()+"-";
            danhSachDiem += element1.child(i).child(2).text()+"-";
            danhSachDiem += "TK(10)="+element1.child(i).child(9).text()+"\n";            
        }
        System.out.println(danhSachDiem);
        }catch(Exception e){
            System.out.println(e);
        }
    
}
}
