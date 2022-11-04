/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;


import Bai05.*;
import Bai03.*;
import Bai02.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author NGOC BAU
 */
public class Server {
    private Socket socket=null;
    private ServerSocket server=null;
    BufferedWriter out=null;
    BufferedReader in = null;
    Map<String, String> dictionary = new HashMap<>();
    public Server(int port){
        createsDictionary();
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
    public void createsDictionary(){
        dictionary.put("Hi", "Xin chào");
        dictionary.put("hi", "xin chào");
        dictionary.put("Hello", "Xin chào");
        dictionary.put("hello", "xin chào");
        dictionary.put("Bye", "Tạm biệt");
        dictionary.put("bye", "tạm biệt");
        dictionary.put("one", "một");
        dictionary.put("One", "Một");
        dictionary.put("tow","hai");
        dictionary.put("three","số ba");
        dictionary.put("father", "cha");
        dictionary.put("tree", "cây");
    } 
    public String returnResult(String word) {
        if(word.equals("exit")) return "Thoát!";
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }else{
            String vi;
            Set set  = dictionary.keySet();            
            for(Object key : set){
                vi=dictionary.get(key);
                if(vi.equals(word)){
                    return key.toString();
                }
            }            
        } 
        return "Bó tay";
    }
    
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
