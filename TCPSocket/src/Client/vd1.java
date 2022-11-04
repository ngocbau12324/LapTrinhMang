/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author NGOC BAU
 */
public class vd1 {
    /*CHương tình lấy ngày giờ hiện tại từ time.nist.gov*/
    public static void main(String[] args) {
        String hostname="time.nist.gov";
        int port=13;
        BufferedReader in;
        int c;
        try {
            Socket s=new Socket(hostname,port);
            in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            StringBuilder data=new StringBuilder();
            while((c=in.read())!=-1){
                data.append((char)c);
            }
            System.out.println(data);
            in.close();
            s.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
