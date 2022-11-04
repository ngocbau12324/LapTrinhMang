package GuessNumber;



import PerfectNumber.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

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
    static long startTime=0;
    long endTime;
    int step=0;

    public server() {
        DatagramSocket socket;
        DatagramPacket dpSend, dpReceive;
        try{
            Random r=new Random();
            int number=r.nextInt(100);
            socket = new DatagramSocket(port);
            while(true){
                dpReceive = new DatagramPacket(new byte[buffersize],buffersize);
                socket.receive(dpReceive);
                if(startTime==0)startTime=System.currentTimeMillis();
                String tmp = new String(dpReceive.getData(),0,dpReceive.getLength());
                System.out.println("Server receive "+tmp+" from client "+dpReceive.getAddress()+
                        " port number "+dpReceive.getPort());
                if(tmp.equals("bye")){
                    System.out.println("Server socket closed.");
                    socket.close();
                    break;
                }
                //send back
                tmp = returnResult(tmp,number);
                dpSend = new DatagramPacket(tmp.getBytes(),tmp.getBytes().length,dpReceive.getAddress(),dpReceive.getPort());
                socket.send(dpSend);
                System.out.println("Server send  back: "+new String(dpSend.getData(),0,dpSend.getLength()));
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        server s = new server();
    }
    public  String returnResult(String s, int n) {                
        int number;
        String rs;
        step++;
        try{
            number = Integer.parseInt(s);                       
        }catch(NumberFormatException e){            
            return "Vui lòng nhập một số.";
        }
        if(number < n) return "Hãy nhập số lớn hơn.";
        if(number > n) return "Hãy hập số nhỏ hơn.";
        endTime=System.currentTimeMillis();
        return "WIN!"+" [Step: "+ step+", Time: "+ (endTime-startTime)/1000+"s]";
    }
}
