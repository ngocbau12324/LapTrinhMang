
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class Bai03 {
    public static void main(String[] args) {
        String url="D:\\MONHOC\\LtJava\\BaiTapTH-Tuan03\\src\\input3.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(url);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bai02.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner input=new Scanner(fileInputStream);
        String ip;
        while (input.hasNextLine()){
            ip=input.nextLine();
            InetAddress add;
            try {
                add = InetAddress.getByName(ip);
                if (add.isReachable(3000))
                    System.out.println("IP "+ip+" is reachable");
                else System.out.println("IP "+ip+" is not reachable");
            } catch (IOException ex) {
                System.out.println("");
            }
            
        }
    }
    
}
