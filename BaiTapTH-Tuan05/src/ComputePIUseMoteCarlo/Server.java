/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComputePIUseMoteCarlo;


import Bai04.*;
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
        try{
            number = Integer.parseInt(s);                       
        }catch(NumberFormatException e){            
            return "Please enter a number.";
        }
        if(number < 1000000) return "Enter number > 1000000.";
        double pi=computePIUseMoteCarlo(number);
        endTime=System.currentTimeMillis();
        return "PI="+pi+", Time: "+ (endTime-startTime)/1000+"s";
    }
    public double computePIUseMoteCarlo(int a){
        int i;
        double x,y;  
        int nThrows=0;
        int nSuccess=0;
        for(i=0;i<a;i++){
            x=Math.random();//Ném phi tiêu
            y=Math.random();
            
            nThrows++;//Số lần ném
            
            if(x*x+y*y < 1) nSuccess++;// Số lần ném trong vòng tròn
        }
        return 4*(double)nSuccess/(double)nThrows;
    }
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
