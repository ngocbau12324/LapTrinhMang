
import java.net.InetAddress;
import java.net.UnknownHostException;
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
public class Bai01 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String domain;
        do{
            System.out.print("Input domain name: ");
            domain=input.nextLine();
            try {
            // TODO code application logic here
            InetAddress[] add= InetAddress.getAllByName(domain);
            for(int i=0;i< add.length;i++)
                System.out.println(add[i].getHostAddress());
                } catch (UnknownHostException ex) {
                   System.out.println("Can't find host "+domain);
                 }
        }while(!domain.equals("exit"));
        input.close();
        
        /*InetAddress myAddress;
        try {
            myAddress = InetAddress.getLocalHost();
            System.out.println(myAddress.getHostName());
            System.out.println(myAddress.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(BaiTapTHTuan03.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
    
}
