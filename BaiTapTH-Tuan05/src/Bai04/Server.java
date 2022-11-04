/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai04;


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
import java.util.Random;
import java.util.Set;

/**
 *
 * @author NGOC BAU
 */
public class Server {
    private Socket socket=null;
    private ServerSocket server=null;
    BufferedWriter out=null;
    BufferedReader in = null;
    long startTime=0;
    long endTime;
    int step=0;
    public Server(int port){
        try{
            Random r=new Random();
            int number=r.nextInt(100);
            server = new ServerSocket(port) ;
            System.out.println("Server started. Waiting for Client....");
            socket=server.accept();
            System.out.println("Client "+socket.getInetAddress()+" connected at port "+socket.getPort());
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String lineString="";         
            while(!lineString.equals("exit")){
                lineString=in.readLine();
                if(startTime==0)startTime=System.currentTimeMillis();
                System.out.println("Server received: "+lineString);                
                //Respone 
                String rs = returnResult(lineString,number);                
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
    public String returnResult(String s, int n) {
        if(s.equals("exit"))return "Bye bye!";        
        int number;
        String rs;
        step++;
        try{
            number = Integer.parseInt(s);                       
        }catch(NumberFormatException e){            
            return "Please enter a number.";
        }
        if(number < n) return "Hay nhap so lon hon.";
        if(number > n) return "Hay nhap so nho hon.";
        endTime=System.currentTimeMillis();
        return "WIN!"+" [Step: "+ step+", Time: "+ (endTime-startTime)/1000+"s]";
    }
    
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
