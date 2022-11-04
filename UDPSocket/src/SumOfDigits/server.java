package SumOfDigits;


import ReverseString.*;
import static SumOfDigits.test.findSumOfDigits;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    static Map<Integer, Integer> sumOfDigitsMap = new HashMap<>();
    public static void main(String[] args) {
        DatagramSocket socket;
        DatagramPacket dpSend, dpReceive;
        try {
            loadData();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public static String handle(String str ){
        int number = Integer.parseInt(str);
        int dem = 0;
        for(int key : sumOfDigitsMap.keySet()){
            if(sumOfDigitsMap.get(key) == number ) dem++;
        }
        return Integer.toString(dem);
    }
    public static void loadData() throws FileNotFoundException{ 
        String path = ".\\src\\SumOfDigits\\data.txt"; 
        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner input = new Scanner(fileInputStream);
        String line;
        int number;
        while(input.hasNextLine()){
            line = input.nextLine();
            number = Integer.parseInt(line);
            if(!sumOfDigitsMap.containsKey(number)){
                sumOfDigitsMap.put(number, findSumOfDigits(number));                
            }            
        }
    }
    static int findSumOfDigits(int number)  
        {               
        int sum = 0;         
        while (number != 0)  
            {              
            sum = sum + number % 10;              
            number = number/10;  
            }          
        return sum;  
        } 
}
