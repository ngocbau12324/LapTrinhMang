/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author NGOC BAU
 */
public class vd0 {
    public static void main(String[] args) {
        int n=Integer.parseInt("-2");
        System.out.println(n);
        try {
            //Socket s=new Socket("sgu.edu.vn",443);
            Socket s=new Socket("172.255.6.236",6000);
            if(s.isConnected())
                System.out.println("Connected to "+ s.getInetAddress()+" on port "+s.getPort()+" from Port "+s.getLocalPort()+" of "+
                        s.getLocalAddress());
        } catch(UnknownHostException e){
            System.err.println(e);  
        } catch (IOException e) {
            System.err.println(e);  
        }
    }
    
}
