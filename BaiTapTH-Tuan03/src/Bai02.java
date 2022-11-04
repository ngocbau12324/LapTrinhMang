
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
public class Bai02 {
    public static void main(String[] args) {
        
        //String url="D:\\MONHOC\\LtJava\\BaiTapTH-Tuan03\\src\\input2.txt";
        String url="src\\input2.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(url);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        Scanner input=new Scanner(fileInputStream);
        String domain;
        while (input.hasNextLine()){
            domain=input.nextLine();
            InetAddress add;
            try {
                add = InetAddress.getByName(domain);
                System.out.println("Domain name "+domain+" has IP: "+ add.getHostAddress());
            } catch (UnknownHostException ex) {
                System.out.println("Domain name "+domain+" is not valid");
            }
            
        }
    }
}
