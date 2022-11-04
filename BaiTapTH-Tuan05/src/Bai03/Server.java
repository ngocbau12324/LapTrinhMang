/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai03;


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
    public static String returnResult(String s) {
        int number;
        String rs;
        try{
            number = Integer.parseInt(s);                       
        }catch(NumberFormatException e){
            if(s.equals("exit")) return "See you!";
            return "Input String cannot be factored into primes.";
        }
        if(number < 10) return "Please enter a number >=10.";
        return primeFactors(number);
    }
    public static String primeFactors(int n){
        String s="";
        int dem=0;
        Map<Integer, Integer> m=new HashMap<>();
        for(int i=2;i<=n;i++){
            while (n%i==0){
                dem++;
                m.put(i, dem);
                n/=i;
            }
            dem=0;
        }
        Set<Integer> keySet=m.keySet();
        for(Integer key : keySet)
            s+="x"+key+"^"+m.get(key);
        return s.substring(1);
    }
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
