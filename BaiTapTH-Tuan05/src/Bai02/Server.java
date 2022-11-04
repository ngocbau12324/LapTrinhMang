/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai02;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
                String rs=perfectNumber(lineString);
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
    public static String perfectNumber(String s){
        if(s.equals("exit")) return "See you agian!";        
        long num;
        try{
            num=Long.parseLong(s);           
        }catch(Exception e){
            return "Please enter a Positive Interger";
        }
        if(num<=0) return "Please enter a Positive number.";
        long sum=1;
        for(long i = 2 ; i*i < num ; i++) {
        	if(num % i == 0)  {
                    if(i*i != num){
                        sum = sum +i + num/i;
                    }else sum = sum + i;
			}
		}
        if(sum == num && num != 1)return num+" is a Perfect number!";
        else return num+ " is NOT a Perfect number. ";
    }
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
