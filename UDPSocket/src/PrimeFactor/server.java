package PrimeFactor;


import ReverseString.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
                tmp = returnResult(tmp);
                dpSend = new DatagramPacket(tmp.getBytes(),tmp.getBytes().length,dpReceive.getAddress(),dpReceive.getPort());
                socket.send(dpSend);
                System.out.println("Server send  back: "+new String(dpSend.getData(),0,dpSend.getLength()));
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    public static String returnResult(String s) {
        int number;
        String rs;
        try{
            number = Integer.parseInt(s);                       
        }catch(NumberFormatException e){            
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
}
