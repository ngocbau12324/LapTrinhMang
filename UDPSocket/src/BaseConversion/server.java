package BaseConversion;


import ReverseString.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;

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
                tmp = handle(tmp);
                dpSend = new DatagramPacket(tmp.getBytes(),tmp.getBytes().length,dpReceive.getAddress(),dpReceive.getPort());
                socket.send(dpSend);
                System.out.println("Server send  back: "+new String(dpSend.getData(),0,dpSend.getLength()));
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    public static String handle(String s){
        StringTokenizer stringToken = new StringTokenizer(s,":");
        int sBase = Integer.parseInt(stringToken.nextToken());
        int dBase1, dBase2=0;
        String dBaseString = stringToken.nextToken();
        String number = stringToken.nextToken();
        if (dBaseString.contains(",")){
            dBase1= Integer.parseInt(dBaseString.split(",")[0]);
            dBase2= Integer.parseInt(dBaseString.split(",")[1]);
        }
        dBase1 = Integer.parseInt(dBaseString);                        
        return baseConversion(number, sBase, dBase1,dBase2);
    }
    public static String baseConversion(String number, int sBase, int dBase1, int dBase2){
       if(dBase2==0)return Integer.toString(Integer.parseInt(number,sBase),dBase1);
       return Integer.toString(Integer.parseInt(number,sBase),dBase1)+"-"+Integer.toString(Integer.parseInt(number,sBase),dBase2);
   } 
}
