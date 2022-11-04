/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TraCuuIp;


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
        if(s.equals("hello")) {
            return "Hi! I'am " + socket.getLocalAddress().toString();
        }        
        if(s.equals("exit")) return "See you!";
        String[] req =s.split(" ");
        if((req.length != 2)||!(req[0].equals("req")))
            return "Hãy nhập đúng định dạng: req x(x là Ip)!";
        return searchIpAddress(req[1]);
        
    }
    
    public String searchIpAddress(String ip){
        BufferedReader reader;
        String line;
        String urlString="http://ip-api.com/json/"+ip+"?fields=status,message,continent,country,city,lat,lon";        
        StringBuffer responseContent = new StringBuffer();
        try{
            URL url =  new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            //Requesr settup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            //System.out.println(status);
            if(status >299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.disconnect();
        }
        //Convert String to Json        
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(responseContent.toString());        
        String status = json.get("status").toString();
        if(status.equals("\"fail\"")){            
            String message =json.get("message").toString();
            if(message.equals("\"private range\"")) return "Private IP. Không thể tìm!";
            if(message.equals("\"reserved range\"")) return "Reserved IP addresses. Không thể tìm!";
            return "IP không hợp lệ.";
        }                                
        String result ="IP: "+ip+"\n";
        result +="Vĩ độ: "+json.get("lat").toString()+"\n";
        result +="Kinh Độ: "+json.get("lon").toString()+"\n";
        result +="Thành phố: "+json.get("city").toString()+"\n";
        result +="Quốc gia: "+json.get("country").toString()+"\n";
        result +="Châu lục: "+json.get("continent").toString();
        return result;
    }
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
