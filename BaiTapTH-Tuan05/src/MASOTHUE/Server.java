/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MASOTHUE;


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
import org.jsoup.Jsoup;
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
        return searchInfo(s);
        
    }
    
    public String searchInfo(String id){
        String info = "";
        String urString="https://masothue.com/Search/?q="+id+"&type=auto&token=hPRep5qONi";
        try {
             String url =Jsoup.connect(urString)
                     .followRedirects(true)
                     .execute()
                     .url()
                     .toExternalForm();
             org.jsoup.nodes.Document doc = Jsoup.connect(url).get();             
             org.jsoup.select.Elements elements= doc.getElementsByClass("table-taxinfo");
             if(elements.size()==0) return "Không tìm thấy.";
             Element e=doc.getElementsByClass("table-taxinfo").get(0); 
             //System.out.println(e.childrenSize());//Số lượng nhánh con của "table-taxinfo"
             info +="Tên: "+ (e.child(0).child(0).child(0).text())+"\n";
             
             int childrenSize=e.child(1).childrenSize();//số lượng nhánh con của child(1)
             for(int i=0;i<childrenSize;i++){
                 info += (e.child(1).child(i).child(0).text())+": ";
                 info += (e.child(1).child(i).child(1).text())+"\n";
                 if((e.child(1).child(i).child(0).text()).equals("Tình trạng")) break;
             }                                                     
        } catch (IOException ex) {
            return "Quá trình tìm Bị lỗi.";
        }
        return info;
    }
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
