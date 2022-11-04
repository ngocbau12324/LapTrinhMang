/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TraCuuThongTinSinhVien;


import MASOTHUE.*;
import TraCuuIp.*;
import Bai04.*;
import Bai03.*;
import Bai02.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author NGOC BAU
 */
public class Server {
    private Socket socket=null;
    private ServerSocket server=null;
    BufferedWriter out=null;
    BufferedReader in = null;  
    
    public static HttpURLConnection connection;
    public Server(int port){
        try{            
            server = new ServerSocket(port) ;
            System.out.println("Server started. Waiting for Client....");
            socket=server.accept();
            System.out.println("Client "+socket.getInetAddress()+" connected at port "+socket.getPort());
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String lineString="";         
            while(!lineString.equals("exit")){
                lineString=in.readLine();                
                System.out.println("Server received: "+lineString);                
                //Respone 
                String rs = returnResult(lineString)+"\n ";                
                System.out.println("Server returned: "+ rs);
                out.write(rs);
                out.newLine();
                out.flush();
            }
            System.out.println("Closing connection");
            in.close();
            out.close();
            socket.close();
            server.close();
        }catch(IOException e){
            System.err.println(e);
        }
            
    }
    public String returnResult(String s) {                
        if(s.equals("exit")) return "See you!";        
        return searchInfo(s)+xemDiemThiTheoHK(s);
        
    }
    
    public String searchInfo(String id){
        String infor = "";
        //String url ="http://thongtindaotao.sgu.edu.vn/Default.aspx?page=xemdiemthi&id=3119410035";
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
                .data("ctl00$ContentPlaceHolder1$ctl00$txtMaSV",id)
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
        if(childrenSize<10) return "Không tìm thấy mã vừa nhập";
        for(int i=0;i<10;i++){
            infor += element.child(i).child(0).text()+": ";
            infor += element.child(i).child(1).text()+"\n";
        }          
        }catch(IOException e){
            System.err.println(e);
        }  
        return infor;
    }
    public String xemDiemThiTheoHK(String id){
        String danhSachDiem="";
        String domain = "http://thongtindaotao.sgu.edu.vn/";
        String urlXemDiemThiTheoHK = domain+"Default.aspx?page=xemdiemthi&id="+id;
        String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Mobile Safari/537.36";
        try{
        Connection.Response respone = Jsoup.connect(urlXemDiemThiTheoHK)                
                .method(Connection.Method.GET)
                .execute();
        Document XemDiemPage = respone.parse();
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
        for(int i=2 ;i < (soLuongMonHoc+2); i++){
            danhSachDiem += element1.child(i).child(1).text()+" - ";
            danhSachDiem += element1.child(i).child(2).text()+" - ";
            danhSachDiem += "TK(10)="+element1.child(i).child(9).text()+"\n";            
        }
        }catch(IOException e){
            System.err.println(e);
        }
        return danhSachDiem;
    }
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
