package IQAIR;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class client {
    public static int destPort = 1234;
    public static String hostName = "localhost";
    public static void main(String[] args) {
        DatagramSocket socket ;
        DatagramPacket dpSend, dpReceive;
        Scanner stdin = new Scanner(System.in);
        try{
            while(true){
                socket = new DatagramSocket();
                System.out.print("Client input:");
                String tmp = stdin.nextLine();
                byte[] data = tmp.getBytes();
                dpSend = new DatagramPacket(data,data.length,InetAddress.getByName(hostName),destPort);
                System.out.println("Client send: "+ tmp);
                socket.send(dpSend);
                if(tmp.equals("bye")){
                    System.out.println("Client socket closed.");
                    stdin.close();
                    socket.close();
                    break;
                }
                //get resp from server
                dpReceive = new DatagramPacket(new byte[2048],2048);
                socket.receive(dpReceive);
                tmp = new String(dpReceive.getData(),0,dpReceive.getLength());
                System.out.println("Client receive: \n"+ tmp);
            }
        }catch(IOException e){
            System.err.println(e);                  
        }
    }
 }
