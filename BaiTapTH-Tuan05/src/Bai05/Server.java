/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai05;


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
    public static String returnResult(String data) {
        if(data.equals("exit")) return "See you!";
        int num1, num2;
        float result=0;
        String op;
        try{
        StringTokenizer st=new StringTokenizer(data, "+-*/",true);//có true thì in ra cả dấu phép tính
        num1=Integer.parseInt(st.nextToken());
        op=st.nextToken();
        num2=Integer.parseInt(st.nextToken());
        }catch(Exception e){
            return "Vui long nhap dung dinh dang.";
        }
        switch (op){
            case "+":
                result=num1+num2;
                break;
            case "-":
                result=num1-num2;
                break;
            case "*":
                result=num1*num2;
                break;
            case "/":
                result=num1/num2;
                break;
            default:
                break;
        }
        return String.valueOf(result);
    }
    
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
