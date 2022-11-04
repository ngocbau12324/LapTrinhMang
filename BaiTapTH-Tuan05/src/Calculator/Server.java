/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;
import com.google.gson.Gson;
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
                String rs = returnResult(lineString);                
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
        return calculate(s);
        
    }
    
    public String calculate(String s){
        String result = "";        
        String domain = "https://web2.0calc.com/calc";
        try{                
        Connection.Response respone = Jsoup.connect(domain)
                .data("in[]",s)
                .data("trig","deg")
                .data("p","0")
                .data("s","0")                               
                .ignoreContentType(true)
                .method(Connection.Method.POST)
                .execute();
        org.jsoup.nodes.Document XemDiemPage = respone.parse();
        String data = XemDiemPage.body().text();
        JsonObject jsonData=new Gson().fromJson(data, JsonObject.class);              
        result =(jsonData.getAsJsonArray("results").get(0).getAsJsonObject().get("out").getAsString());            
        }catch(IOException e){
            System.err.println(e);
        }
        return result;
    } 
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
