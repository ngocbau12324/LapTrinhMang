package PerfectNumber;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class server {
    public static int buffersize = 512;
    public static int port = 1234;
    public static void main(String[] args) {
        DatagramSocket socket;
        DatagramPacket dpSend, dpReceive;
        try{
            socket = new DatagramSocket(port);
            while(true){
                dpReceive = new DatagramPacket(new byte[buffersize],buffersize);
                socket.receive(dpReceive);
                String tmp = new String(dpReceive.getData(),0,dpReceive.getLength());
                System.out.println("Server receive "+tmp+" from client "+dpReceive.getAddress()+
                        " port number "+dpReceive.getPort());
                if(tmp.equals("bye")){
                    System.out.println("Server socket closed.");
                    socket.close();
                    break;
                }
                //send back
                tmp = perfectNumber(tmp);
                dpSend = new DatagramPacket(tmp.getBytes(),tmp.getBytes().length,dpReceive.getAddress(),dpReceive.getPort());
                socket.send(dpSend);
                System.out.println("Server send  back: "+new String(dpSend.getData(),0,dpSend.getLength()));
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
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
}
