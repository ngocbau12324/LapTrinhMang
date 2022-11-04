/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGOC BAU
 */
public class scan_port {
    public static void main(String[] args) {
        String hostname = "8.8.8.8";
        int beginPort = 400;
        int endPort = 500;
        int timeout=200;
        for(int port=beginPort;port<=endPort;port++){
            try {
                Socket s=new Socket();
                s.connect(new InetSocketAddress(hostname,port), timeout);
                System.out.println("#Port "+port+" is opened.");
                s.close();
            } catch (IOException ex) {
                System.out.println("Port "+port+" is closed.");
            }
        }
    }
    
}
